/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.server.dao.SubjectDAO;
import com.ijse.dl.server.util.Encryption;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Randula
 */
public class SubjectDAOImpl implements SubjectDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private RandomAccessFile file;  // File that save data
    private Encryption encryption = new Encryption();  // Encryption logic

    /**
     * Class constructor.
     *
     * @throws java.io.IOException
     */
    public SubjectDAOImpl() throws IOException {
        file = new RandomAccessFile("./src/db/dbFile/Subjects.txt", "rw");
    }

    /**
     * @param subject the object to save
     * @return whether it is added
     * @throws java.io.IOException
     */
    @Override
    public boolean addRecord(Subject subject) throws IOException {
        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(createId()).append(":")
                    .append(subject.getSubjectName()).append(":")
                    .append(subject.getDescription());

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

    /**
     * @param id the id to search
     * @return object relevant to id
     * @throws java.io.IOException
     */
    @Override
    public Subject searchRecord(String id) throws IOException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Subject subject = null;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                String subjectId = record[0];
                if (subjectId != null && subjectId.equals(id)) {
                    subject = new Subject(record[0], record[1], record[2]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return subject;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     * @param id the to check
     * @return whether it is available
     * @throws java.io.IOException
     */
    @Override
    public boolean checkRecordAvailbility(String id) throws IOException {
        READ_WRITE_LOCK.readLock().lock();
        try {
            file.seek(0);
            boolean isAvailable = false;
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                if (record.length > 1) {
                    String subjectId = record[0];
                    if (subjectId != null && subjectId.equals(id)) {
                        isAvailable = true;
                        break;
                    } else {
                        isAvailable = false;
                    }
                    dataLine = file.readLine();
                    data = encryption.deEncrypt(dataLine);
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return isAvailable;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }

    }

    /**
     * @param id the id to delete
     * @return whether it is deleted
     * @throws java.io.IOException
     */
    @Override
    public boolean deleteRecord(String id) throws IOException {
        READ_WRITE_LOCK.writeLock().lock();
        try {
            file.seek(0);
            Subject subject = searchRecord(id);
            ArrayList<Subject> allSubjects = getAll();
            ArrayList<Subject> newSubjectList = new ArrayList<>();
            int addrecordCount = 0;
            int newListCount = 0;

            System.out.println(subject.toString() + " Get record");

            for (Subject sub : allSubjects) {
                if (!subject.toString().equals(sub.toString())) {
                    newSubjectList.add(sub);
                }
            }

            newListCount = newSubjectList.size();
            file.setLength(0);

            for (Subject newData : newSubjectList) {
                boolean addRecord = addRecord(newData);
                if (addRecord) {
                    addrecordCount++;
                }
            }
            if (addrecordCount == newListCount) {
                return true;
            } else {
                return false;
            }
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    /**
     * @return All Subjects
     * @throws java.io.IOException
     */
    @Override
    public ArrayList<Subject> getAll() throws IOException {
        READ_WRITE_LOCK.readLock().lock();
        try {
            String data;
            Subject subject = null;
            ArrayList<Subject> list = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                subject = new Subject(record[0], record[1], record[2]);
                list.add(subject);
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return list;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     * @param subject the new Object
     * @param id the key to update
     * @return whether it is updated
     * @throws java.io.IOException
     */
    @Override
    public boolean updateRecord(Subject subject, String id)
            throws IOException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            file.seek(0);

            Subject oldRecord = null;
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] split = data.split(":");
                if (split[0].equals(id)) {
                    oldRecord = new Subject(split[0] + ":",
                            split[1] + ":", split[2]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            boolean deleteRecord = deleteRecord(id);
            boolean addRecord = false;
            if (deleteRecord) {
                addRecord = addRecord(subject);
            }
            if (addRecord) {
                return true;
            } else {
                boolean addedOldOne = addRecord(oldRecord);
                return false;
            }
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    @Override
    public Subject searchRecordByName(String name)
            throws IOException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Subject subject = null;
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String subjectName = record[1];
                if (subjectName != null && subjectName.equals(name)) {
                    subject = new Subject(record[0], record[1], record[2]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return subject;
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
            ArrayList<Subject> list = new ArrayList<>();

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
