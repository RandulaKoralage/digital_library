/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.User;
import com.ijse.dl.server.dao.UserDAO;
import com.ijse.dl.server.util.Encryption;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Randula
 */
public class UserDAOImpl implements UserDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private final Encryption encryption = new Encryption();// Encryption logic
    private final RandomAccessFile file;// File that save data

    public UserDAOImpl() throws FileNotFoundException {
        file = new RandomAccessFile("./src/db/dbFile/Users.txt", "rw");
    }

    @Override
    public String addRecord(User user) 
            throws IOException, RemoteException {
        
        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();
            String id = createId();
            stringBuffer.append(id).append(":")
                    .append(user.getName()).append(":")
                    .append(user.getNic()).append(":")
                    .append(user.getTelephone()).append(":")
                    .append(user.getEmail()).append(":")
                    .append(user.getType());

            String writeLine = encryption.encrypt(stringBuffer.toString());

            if (file.getFilePointer() != 0) {
                file.writeBytes(System.getProperty("line.separator"));
            }
            file.writeBytes(writeLine);
            if ((length < file.length())) {
                return id;
            } else {
                return null;
            }
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public boolean modifyRecord(User user, String id)
            throws IOException, RemoteException {
        
        READ_WRITE_LOCK.writeLock().lock();
        try {
            int size = 0;
            String data = null;
            ArrayList<User> list = new ArrayList<>();
            User tempUser = null;
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                if (record[0].equalsIgnoreCase(id)) {
                    tempUser = user;
                } else {
                    tempUser = new User(record[0], record[1], record[2],
                            record[3], record[4], record[5]);
                }
                list.add(tempUser);
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            size = list.size();
            file.setLength(0);
            int count = 0;
            for (User u : list) {
                count++;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(u.getId()).append(":")
                        .append(u.getName()).append(":")
                        .append(u.getNic()).append(":")
                        .append(u.getTelephone()).append(":")
                        .append(u.getEmail()).append(":")
                        .append(u.getType());

                String writeLine = encryption.encrypt(stringBuffer.toString());

                if (file.getFilePointer() != 0) {
                    file.writeBytes(System.getProperty("line.separator"));
                }
                file.writeBytes(writeLine);
            }
            return count == size;
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public boolean removeRecord(String id) 
            throws IOException, RemoteException {
        
        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(0);
            int toRemove = selectLine(id);
            file.seek(0);
            // Leave the n first lines unchanged.
            for (int i = 0; i < toRemove; i++) {
                file.readLine();
            }

            // Shift remaining lines upwards.
            long writePos = file.getFilePointer();
            file.readLine();
            long readPos = file.getFilePointer();

            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = file.read(buf))) {
                file.seek(writePos);
                file.write(buf, 0, n);
                readPos += n;
                writePos += n;
                file.seek(readPos);
            }

            file.setLength(writePos);
            return (length > file.length());
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public User searchRecord(String id) throws IOException, RemoteException {
        READ_WRITE_LOCK.readLock().lock();
        try {
            User user = null;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String userId = record[0];
                if (userId != null && userId.equals(id)) {
                    user = new User(record[0], record[1], record[2], 
                            record[3], record[4], record[5]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return user;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    @Override
    public ArrayList<User> getAllRecord() 
            throws IOException, RemoteException {
        
        READ_WRITE_LOCK.readLock().lock();
        try {
            User user = null;
            ArrayList<User> userList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                if (record != null) {
                    user = new User(record[0], record[1], record[2],
                            record[3], record[4], record[5]);
                    userList.add(user);
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return userList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    private int selectLine(String id) throws IOException {
        
        READ_WRITE_LOCK.readLock().lock();
        try {
            file.seek(0);
            int lineCount = 0;
            int targetLine = 0;
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            while (data != null) {
                lineCount++;
                String[] record = data.split(":");
                String s = record[0];
                if (s.equalsIgnoreCase(id)) {
                    targetLine = lineCount - 1;
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return targetLine;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    private String createId() throws IOException {
        
         READ_WRITE_LOCK.readLock().lock();
        try {
        String lastId = null;
        String data;
        ArrayList<Integer> keyArrayList = new ArrayList();
        file.seek(0);
        String dataLine = file.readLine();
        data = encryption.deEncrypt(dataLine);
        while (data != null) {
            String[] record = data.split(":");

            Integer keyValue = Integer.parseInt(record[0]);
            keyArrayList.add(keyValue);
            dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
        }
        Collections.sort(keyArrayList);
        if (keyArrayList.size() == 0) {
            return "1";
        }
        int last = keyArrayList.get(keyArrayList.size() - 1) + 1;
        lastId = Integer.toString(last);
        return lastId;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }
}
