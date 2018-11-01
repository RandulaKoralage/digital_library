/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.Comment;
import com.ijse.dl.common.dto.Request;
import com.ijse.dl.server.dao.CommentDAO;
import com.ijse.dl.server.util.Encryption;
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
public class CommentDAOImpl implements CommentDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private final Encryption encryption = new Encryption();// Encryption logic
    private final RandomAccessFile file;  // File that save data

    public CommentDAOImpl() throws IOException {
        file = new RandomAccessFile("./src/db/dbFile/Comments.txt", "rw");
    }

    @Override
    public boolean addComment(Comment comment)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(createId()).append(":")
                    .append(comment.getmCode()).append(":")
                    .append(comment.getSender()).append(":")
                    .append(comment.getDate()).append(":")
                    .append(comment.getContent());
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
    public ArrayList<Comment> viewCommentOnBook(String mCode)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            String data;
            Comment comment = null;
            ArrayList<Comment> list = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");

                if (record != null && record[1].equalsIgnoreCase(mCode)) {
                    comment = new Comment(record[0], record[1], record[2],
                            record[3], record[4]);
                    list.add(comment);
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
