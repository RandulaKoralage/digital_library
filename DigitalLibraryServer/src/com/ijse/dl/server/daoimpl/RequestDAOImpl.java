/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.Request;
import com.ijse.dl.server.dao.RequestDAO;
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
public class RequestDAOImpl implements RequestDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private final Encryption encryption = new Encryption(); // Encryption logic
    private final RandomAccessFile file; // File that save data

    public RequestDAOImpl() throws FileNotFoundException {
        file = new RandomAccessFile("./src/db/dbFile/Requests.txt", "rw");
    }

    @Override
    public boolean addRequest(Request request)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(createId()).append(":")
                    .append(request.getMember()).append(":")
                    .append(request.getBookName()).append(":")
                    .append(request.getDescription()).append(":")
                    .append(request.getAuthor()).append(":")
                    .append(request.getSubject()).append(":")
                    .append(request.getMediaType());

            String writeLine = encryption.encrypt(stringBuffer.toString());

            System.out.println(writeLine);
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
    public Request serchRequest(String id)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Request request = null;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                String reqId = record[0];
                if (reqId != null && reqId.equals(id)) {
                    request = new Request(record[0], record[1], record[2],
                            record[3], record[4], record[5], record[6]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return request;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }

    }

    @Override
    public boolean deleteRequest(String id)
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
    public ArrayList<Request> viewAllRequests()
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            String data;
            Request request = null;
            ArrayList<Request> list = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            System.out.println("un decypted" + dataLine);
            data = encryption.deEncrypt(dataLine);
            System.out.println(data);
            while (data != null) {
                String[] record = data.split(":");
                request = new Request(record[0], record[1], record[2],
                        record[3], record[4], record[5], record[6]);
                list.add(request);
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return list;
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
                    System.out.println(targetLine);
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
            //This is responsible for reading complete file
            ArrayList<Request> list = new ArrayList<>();
            Request request = null;

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
