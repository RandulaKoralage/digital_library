/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.Membership;
import com.ijse.dl.server.dao.MemberDAO;
import com.ijse.dl.server.util.Encryption;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Randula
 */
public class MemberDAOImpl implements MemberDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private final Encryption encryption = new Encryption();// Encryption logic
    private final RandomAccessFile file; // File that save data

    public MemberDAOImpl() throws FileNotFoundException {
        file = new RandomAccessFile("./src/db/dbFile/Members.txt", "rw");
    }

    @Override
    public String addRecord(Membership membership)
            throws RemoteException, IOException, NotBoundException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(membership.getId()).append(":")
                    .append(membership.getUserName()).append(":")
                    .append(membership.getPassword()).append(":")
                    .append(membership.getRegDate()).append(":")
                    .append(membership.getType());

            String writeLine = encryption.encrypt(stringBuffer.toString());

            if (file.getFilePointer() != 0) {
                file.writeBytes(System.getProperty("line.separator"));
            }
            file.writeBytes(writeLine);

            if ((length < file.length())) {
                return membership.getId();
            }
            return null;
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public boolean deleteRecord(String id)
            throws RemoteException, IOException, NotBoundException {

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
    public boolean modifyRecord(Membership membership, String id)
            throws RemoteException, IOException, NotBoundException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            int size = 0;
            String data = null;
            ArrayList<Membership> list = new ArrayList<>();
            Membership tempMember = null;
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                if (record[0].equalsIgnoreCase(id)) {
                    tempMember = membership;
                } else {
                    tempMember = new Membership(record[0], record[1],
                            record[2], record[3], record[4]);
                }
                list.add(tempMember);
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            size = list.size();
            file.setLength(0);
            int count = 0;
            for (Membership mem : list) {
                count++;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(mem.getId()).append(":")
                        .append(mem.getUserName()).append(":")
                        .append(mem.getPassword()).append(":")
                        .append(mem.getRegDate()).append(":")
                        .append(mem.getType());
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
    public Membership searchRecord(String id)
            throws RemoteException, IOException, NotBoundException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Membership membership = null;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String userId = record[0];
                if (userId != null && userId.equals(id)) {
                    membership = new Membership(record[0], record[1],
                            record[2], record[3], record[4]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return membership;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    @Override
    public boolean isAvailabele(String id, String password, String type)
            throws RemoteException, IOException, NotBoundException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            boolean isAvailabe = false;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String subjectId = record[0];
                String userPass = record[2];
                String userType = record[4];
                if ((subjectId != null && subjectId.equals(id))
                        && userPass.equals(password) && userType.equals(type)) {
                    isAvailabe = true;
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);

            }
            return isAvailabe;
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

    @Override
    public int getSignUpCount(String date)
            throws RemoteException, IOException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Membership membership = null;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            int count = 0;
            while (data != null) {
                String[] record = data.split(":");
                String curDate = record[3];
                if (curDate != null && curDate.equals(date)) {
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
}
