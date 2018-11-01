/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.Access;
import com.ijse.dl.server.dao.AccessDAO;
import com.ijse.dl.server.util.Encryption;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Randula
 */
public class AccessDAOImpl implements AccessDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private final Encryption encryption = new Encryption();// Encryption logic
    private final RandomAccessFile file; // File that save data

    public AccessDAOImpl() throws FileNotFoundException {
        file = new RandomAccessFile("./src/db/dbFile/Access.txt", "rw");
    }

    /**
     * Writes access data to file
     *
     * @param access the Access object to save
     * @return whether Access saved
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public boolean saveRecord(Access access)
            throws RemoteException, IOException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(createId()).append("&")
                    .append(access.getUserId()).append("&")
                    .append(access.getmCode()).append("&")
                    .append(access.getViewDate()).append("&")
                    .append(access.getViewedTime());
            String writeLine = encryption.encrypt(stringBuffer.toString());
            if (file.getFilePointer() != 0) {
                file.writeBytes(System.getProperty("line.separator"));
            }
            file.writeBytes(writeLine);

            return (length < file.length());
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public boolean deleteRecord() throws RemoteException, IOException {
        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(0);
            String data = null;

            int count = 0;
            data = file.readLine();
            while (data != null) {
                count++;
                data = file.readLine();
            }
            if (count > 10) {
                for (int j = 0; j < 10; j++) {
                    int toRemove = j;
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
                }
            }

            return (length > file.length());
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public ArrayList<Access> viewAccessOfADay(String userId, String date)
            throws RemoteException, IOException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            String data;
            Access access = null;
            ArrayList<Access> list = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split("&");
                String id = record[1];
                String curDate = record[3];
                if (record != null && userId.equalsIgnoreCase(id)
                        && curDate.equalsIgnoreCase(date)) {
                    access = new Access(record[0], record[1],
                            record[2], record[3], record[4]);
                    list.add(access);
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return list;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    private String createId() throws IOException {
        READ_WRITE_LOCK.readLock().lock();
        try {
            String lastId = null;

            String data;
            //This is responsible for reading complete file
            ArrayList<Access> list = new ArrayList<>();

            ArrayList<Integer> keyArrayList = new ArrayList();
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split("&");

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

    @Override
    public int getAccessCount(String date)
            throws RemoteException, IOException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            String data;
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
            int count = 0;
            while (data != null) {
                String[] record = data.split("&");
                String curDate = record[3];
                if (record != null && curDate.equalsIgnoreCase(date)) {
                    count++;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return count;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    @Override
    public Map<String, Integer> subjectAccess(String date)
            throws RemoteException, IOException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Map<String, Integer> subjectAccessMap = new HashMap<>();
            ArrayList<String> bookList = getAllBooks(date);

            for (String s : bookList) {
                if (subjectAccessMap.containsKey(s)) {
                    Integer count = subjectAccessMap.get(s) + 1;
                    subjectAccessMap.remove(s);
                    subjectAccessMap.put(s, count);
                } else {
                    Integer count = 1;
                    subjectAccessMap.put(s, count);
                }
            }

            return subjectAccessMap;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    private ArrayList<String> getAllBooks(String date) throws IOException {
        ArrayList<String> bookList = new ArrayList<>();
        String data;
        file.seek(0);
        String dataLine = file.readLine();
        data = encryption.deEncrypt(dataLine);
        while (data != null) {
            String[] record = data.split("&");
            String curDate = record[3];
            if (record != null && curDate.equalsIgnoreCase(date)) {
                bookList.add(record[2]);
            }
            dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
        }
        return bookList;
    }
}
