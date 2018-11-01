/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daoimpl;

import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.util.TransportableImage;
import com.ijse.dl.common.util.TransportableItem;
import com.ijse.dl.server.dao.BookDAO;
import com.ijse.dl.server.util.Encryption;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.imageio.ImageIO;

/**
 *
 * @author Randula
 */
public class BookDAOImpl implements BookDAO {

    private static final ReentrantReadWriteLock READ_WRITE_LOCK
            = new ReentrantReadWriteLock(); // Lock that controlls access 
    private final Encryption encryption = new Encryption(); // Encryption logic
    private final RandomAccessFile file;  // File that save book data
    private final RandomAccessFile pathFile; //File to save book paths

    /**
     * Create BookDAOImpl
     *
     * @throws FileNotFoundException
     */
    public BookDAOImpl() throws FileNotFoundException {
        file = new RandomAccessFile("./src/db/dbFile/Books.txt", "rw");
        pathFile = new RandomAccessFile("./src/db/dbFile/BookPaths.txt", "rw");
    }

    /**
     *
     * @param book the Book object to save
     * @return whether Book saved
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public boolean addRecord(Book book)
            throws IOException, RemoteException {
        READ_WRITE_LOCK.writeLock().lock();

        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();
            String nextId = createId();
            boolean isBookSaved = bookFilter(book.getType(), nextId,
                    book.getBook());
            boolean isCoverSaved = saveCover(book.getImage(), nextId);
            if (isCoverSaved && isBookSaved) {
                stringBuffer.append(nextId)
                        .append(":").append(book.getName())
                        .append(":").append(book.getDescription())
                        .append(":").append(book.getAuthor())
                        .append((":")).append(book.getSubject())
                        .append((":")).append(book.getType())
                        .append(":").append(book.getLanguage())
                        .append(":").append(book.getDownloadable())
                        .append(":").append(book.getRating());

                String writeLine = encryption.encrypt(stringBuffer.toString());
                if (file.getFilePointer() != 0) {
                    file.writeBytes(System.getProperty("line.separator"));
                }
                file.writeBytes(writeLine);

                return (length < file.length());
            }
            return false;
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @param id the id of book
     * @return Book object that matches with id
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public Book searchRecord(String id)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;

            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String bookId = record[0];
                if (bookId != null && bookId.equals(id)) {

                    image = getCover(record[0]);
                    book = new Book(record[0], record[1], record[2],
                            record[3], image, record[4], record[5],
                            record[6], record[7], record[8]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return book;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param name the Book name
     * @return list of matched Books
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ArrayList<Book> searchRecordByName(String name)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;
            ArrayList<Book> bookList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String source = record[1];

                if (record != null) {
                    if (source.contains(name)) {
                        image = getCover(record[0]);
                        book = new Book(record[0], record[1], record[2],
                                record[3], image, record[4], record[5],
                                record[6], record[7], record[8]);
                        bookList.add(book);
                    }

                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return bookList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id of line need to delete
     * @return whether it is deleted
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public boolean deleteRecord(String id)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.writeLock().lock();
        try {

            long length = file.length();
            file.seek(0);
            int toRemove = selectLine(id, file);
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
            boolean isDeleted = false;

            if ((length > file.length())) {
                isDeleted = deleteBookAndCover(id);
                System.out.println("is Deleted");
            }
            return isDeleted;
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    /**
     *
     * @return list of all records
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ArrayList<Book> getAll()
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;
            ArrayList<Book> bookList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String sub = record[4];
                String typ = record[5];
                if (record != null) {

                    book = new Book(record[0], record[1], record[2],
                            record[3], record[4], record[5],
                            record[6], record[7], record[8]);
                    bookList.add(book);

                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return bookList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param book the new Book
     * @param id the id of old Book
     * @return whether Book is Updated
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public boolean updateRecord(Book book, String id)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            file.seek(0);

            Book oldRecord = null;
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] split = data.split(":");
                if (split[0].equals(id)) {
                    oldRecord = new Book(split[0] + ":", split[1] + ":",
                            split[2] + ":", split[3] + ":",
                            split[4] + ":", split[5] + ":",
                            split[6] + ":", split[7] + ":", split[8]);
                    break;
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            boolean deleteRecord = deleteRecord(id);
            boolean addRecord = false;
            if (deleteRecord) {
                addRecord = addRecord(book);
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

    /**
     *
     * @param subject Subject of Book
     * @param type Media type of Book
     * @return list of matched books
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ArrayList<Book> searchBookByTypeAndSubject(
            String subject, String type) throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;
            ArrayList<Book> bookList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String sub = record[4];
                String typ = record[5];
                if (sub != null && sub.equalsIgnoreCase(subject)
                        && typ.equalsIgnoreCase(type)) {

                    image = getCover(record[0]);
                    book = new Book(record[0], record[1], record[2],
                            record[3], image, record[4], record[5],
                            record[6], record[7], record[8]);
                    bookList.add(book);

                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return bookList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param subject Subject of Book
     * @return list of matched Books
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ArrayList<Book> searchBookBySubject(String subject)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;
            ArrayList<Book> bookList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String sub = record[4];
                if (sub != null && sub.equalsIgnoreCase(subject)) {

                    image = getCover(record[0]);
                    book = new Book(record[0], record[1], record[2],
                            record[3], image, record[4], record[5],
                            record[6], record[7], record[8]);
                    bookList.add(book);

                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return bookList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param type Media Type of Books
     * @return list of matched Books
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ArrayList<Book> searchBookByType(String type)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;
            ArrayList<Book> bookList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String typ = record[5];
                if (typ != null && typ.equalsIgnoreCase(type)) {

                    image = getCover(record[0]);
                    book = new Book(record[0], record[1], record[2],
                            record[3], image, record[4], record[5],
                            record[6], record[7], record[8]);
                    bookList.add(book);

                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return bookList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param book the new Book
     * @param id id of old Book
     * @return whether it is updated
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public boolean updateRate(Book book, String id)
            throws IOException, RemoteException {
        READ_WRITE_LOCK.writeLock().lock();
        try {
            int size = 0;
            String data = null;
            ArrayList<Book> list = new ArrayList<>();
            Book tempBook = null;
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                if (record[0].equalsIgnoreCase(id)) {
                    tempBook = book;
                } else {
                    tempBook = new Book(record[0], record[1], record[2],
                            record[3], record[4], record[5],
                            record[6], record[7], record[8]);
                }
                list.add(tempBook);
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            size = list.size();
            file.setLength(0);

            int count = 0;
            for (Book bk : list) {
                count++;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(bk.getmCode())
                        .append(":").append(bk.getName())
                        .append(":").append(bk.getDescription())
                        .append(":").append(bk.getAuthor())
                        .append((":")).append(bk.getSubject())
                        .append((":")).append(bk.getType())
                        .append(":").append(bk.getLanguage())
                        .append(":").append(bk.getDownloadable())
                        .append(":").append(bk.getRating());

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

    /**
     *
     * @param author the author of Book
     * @return list of matched Books
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ArrayList<Book> searchRecordByAuthor(String author)
            throws IOException, RemoteException {

        READ_WRITE_LOCK.readLock().lock();
        try {
            Book book = null;
            byte[] image = null;
            ArrayList<Book> bookList = new ArrayList<>();
            file.seek(0);
            String dataLine = file.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String source = record[3];

                if (record != null) {
                    if (source.contains(author)) {
                        image = getCover(record[0]);
                        book = new Book(record[0], record[1], record[2],
                                record[3], image, record[4], record[5],
                                record[6], record[7], record[8]);
                        bookList.add(book);
                    }

                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }

            return bookList;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id the id of Book
     * @return bytes of Book content
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public byte[] viewBookRecord(String id)
            throws IOException, RemoteException {
        READ_WRITE_LOCK.readLock().lock();
        try {

            byte[] eBook = null;
            pathFile.seek(0);
            String dataLine = pathFile.readLine();
            String data = encryption.deEncrypt(dataLine);

            while (data != null) {
                String[] record = data.split(":");
                String mCode = record[0];
                if (record != null) {

                    if (mCode.equals(id)) {
                        String path = record[1].replaceAll("\\\\", "/");
                        File bookFile = new File(path);
                        eBook = new TransportableItem()
                                .createByteArray(bookFile);
                        break;
                    }
                }
                dataLine = pathFile.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return eBook;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    @Override
    public HashMap<String, Integer> getsBookCountAccordingToSubjects()
            throws IOException {
        System.out.println("IN");

        READ_WRITE_LOCK.readLock().lock();
        HashMap<String, Integer> countMap = new HashMap<>();
        try {
            ArrayList<String> subjectList = getAllSubjects();
            for (String s : subjectList) {
                if (countMap.containsKey(s)) {
                    Integer count = countMap.get(s) + 1;
                    countMap.remove(s);
                    countMap.put(s, count);
                } else {
                    Integer count = 1;
                    countMap.put(s, count);
                }
            }
            return countMap;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

    /**
     *
     * @param id the id of Book
     * @return the line contains id
     * @throws IOException
     */
    private int selectLine(String id, RandomAccessFile file)
            throws IOException {
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

    /**
     *
     * @param book new Book
     * @return whether it is added
     * @throws IOException
     */
    private boolean addRecordsOnly(Book book) throws IOException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = file.length();
            file.seek(length);
            StringBuffer stringBuffer = new StringBuffer();

            stringBuffer.append(book.getmCode())
                    .append(":").append(book.getName())
                    .append(":").append(book.getDescription())
                    .append(":").append(book.getAuthor())
                    .append((":")).append(book.getSubject())
                    .append((":")).append(book.getType())
                    .append(":").append(book.getLanguage())
                    .append(":").append(book.getDownloadable())
                    .append(":").append(book.getRating());

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
     * Saves id and Book content
     *
     * @param mCode the Book id
     * @param path path of book content
     * @return whether it is saved
     * @throws IOException
     */
    private boolean saveBookPath(String mCode, String path)
            throws IOException {

        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = pathFile.length();
            pathFile.seek(length);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(mCode).append(":").append(path);

            String writeLine = encryption.encrypt(stringBuffer.toString());

            if (pathFile.getFilePointer() != 0) {
                pathFile.writeBytes(System.getProperty("line.separator"));
            }
            pathFile.writeBytes(writeLine);
            return (length < pathFile.length());
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    /**
     * Saves bytes as jpg in directory
     *
     * @param image
     * @param mCode
     * @return
     * @throws IOException
     */
    private boolean saveImage(byte[] image, String mCode)
            throws IOException {

        boolean isSaved = false;
        File file = new File("./src/db/dbimage/" + mCode + ".jpg");
        new TransportableItem().toFile(file, image);
        isSaved = file.exists();
        if (isSaved) {
            saveBookPath(mCode, file.getPath());
        }
        return isSaved;
    }

    /**
     * Saves bytes as mp3 in directory
     *
     * @param audio bytes of audio file
     * @param mCode id of Book
     * @return whether it is saved
     * @throws IOException
     */
    private boolean saveAudio(byte[] audio, String mCode)
            throws IOException {

        boolean isSaved = false;
        File file = new File("./src/db/dbaudio/" + mCode + ".mp3");
        new TransportableItem().toFile(file, audio);
        isSaved = file.exists();
        if (isSaved) {
            saveBookPath(mCode, file.getPath());
        }
        return isSaved;
    }

    /**
     * Saves bytes as pdf in directory
     *
     * @param pdf bytes of PDF file
     * @param mCode id ofBook
     * @return whether it is saved
     * @throws IOException
     */
    private boolean savePDF(byte[] pdf, String mCode)
            throws IOException {

        boolean isSaved = false;
        File file = new File("./src/db/dbpdf/" + mCode + ".pdf");
        new TransportableItem().toFile(file, pdf);
        isSaved = file.exists();
        if (isSaved) {
            saveBookPath(mCode, file.getPath());
        }
        return isSaved;
    }

    /**
     * Saves bytes of cover as jpg in directory
     *
     * @param cover bytes of cover image file
     * @param mCode id ofBook
     * @return whether it is saved
     * @throws IOException
     */
    private boolean saveCover(byte[] cover, String mCode)
            throws IOException {

        boolean isSaved = false;
        File file = new File("./src/db/dbcovers/" + mCode + ".jpg");
        new TransportableImage().toFile(file, cover);
        isSaved = file.exists();
        return isSaved;
    }

    /**
     * Saves bytes as mp4 in directory
     *
     * @param video bytes of cover image file
     * @param mCode id ofBook
     * @return whether it is saved
     * @throws IOException
     */
    private boolean saveVideo(byte[] video, String mCode)
            throws IOException {

        boolean isSaved = false;
        File file = new File("./src/db/dbvideo/" + mCode + ".mp4");
        new TransportableItem().toFile(file, video);
        isSaved = file.exists();
        if (isSaved) {
            saveBookPath(mCode, file.getPath());
        }
        return isSaved;
    }

    /**
     * Save eBooks by calling relevant support methods
     *
     * @param type Media Type of Book
     * @param mCode id of Book
     * @param eBook content of Book
     * @return bytes of cover image file
     * @throws IOException
     */
    private boolean bookFilter(String type, String mCode, byte[] eBook)
            throws IOException {

        boolean isSaved = false;

        switch (type) {
            case "Audio":
                isSaved = saveAudio(eBook, mCode);
                break;
            case "Video":
                isSaved = saveVideo(eBook, mCode);
                break;
            case "PDF":
                isSaved = savePDF(eBook, mCode);
                break;
            case "Image":
                isSaved = saveImage(eBook, mCode);
                break;
            default:
                isSaved = false;
        }
        return isSaved;
    }

    /**
     * Converts cover image in directory to bytes
     *
     * @param mCode id of Book
     * @return bytes of cover image
     * @throws IOException
     */
    private byte[] getCover(String mCode)
            throws IOException {

        return new TransportableImage().createByteArray(
                createBufferedImage(mCode));

    }

    /**
     * Saves buffered image in directory
     *
     * @param mCode id of Book
     * @return cover image as Buffered Image
     */
    private BufferedImage createBufferedImage(String mCode)
            throws IOException {

        String path = "./src/db/dbcovers/" + mCode + ".jpg";
        int width = 240;
        int height = 320;
        BufferedImage image = null;
        File f = null;
        f = new File(path);
        image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
        image = ImageIO.read(f);
        return image;
    }

    /**
     * Generates next Id from database
     *
     * @return next id
     */
    private String createId() throws IOException {
        READ_WRITE_LOCK.readLock().lock();
        try {
            String lastId = null;

            String data = null;
            //This is responsible for reading complete file
            ArrayList<Book> list = new ArrayList<>();

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

    /**
     * Deletes cover image and EBook
     *
     * @param id id of Book
     * @return whether ii is deleted
     */
    private boolean deleteBookAndCover(String id) throws IOException {
        READ_WRITE_LOCK.writeLock().lock();
        try {
            boolean isDeleted = false;
            isDeleted = deleteCover(id);
            if (isDeleted) {
                pathFile.seek(0);
                String dataLine = pathFile.readLine();
                String data = encryption.deEncrypt(dataLine);

                while (data != null) {
                    String[] record = data.split(":");
                    String mCode = record[0];
                    if (record != null) {

                        if (mCode.equals(id)) {

                            String path = record[1].replaceAll("\\\\", "/");

                            File bookFile = new File(path);
                            if (bookFile.exists()) {
                                bookFile.delete();
                                isDeleted = true;
                            } else {
                                isDeleted = false;
                            }
                            break;
                        }
                    }
                    dataLine = pathFile.readLine();
                    data = encryption.deEncrypt(dataLine);
                }
                if (isDeleted) {
                    isDeleted = deleteCoverPath(id);
                }
            }

            return isDeleted;
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    /**
     * Deletes cover of book
     *
     * @param id id of Book
     * @return whether ii is deleted
     */
    private boolean deleteCover(String id) {
        String path = "./src/db/dbcovers/" + id + ".jpg";
        boolean isDeleted = false;
        File f = new File(path);

        if (f.exists()) {
            f.delete();
            isDeleted = true;
        }
        return isDeleted;
    }

    /**
     * Deletes cover path in file
     *
     * @param id id of Book
     * @return whether ii is deleted
     */
    private boolean deleteCoverPath(String id) throws IOException {
        READ_WRITE_LOCK.writeLock().lock();
        try {
            long length = pathFile.length();
            pathFile.seek(0);
            int toRemove = selectLine(id, pathFile);
            pathFile.seek(0);

            for (int i = 0; i < toRemove; i++) {
                pathFile.readLine();
            }

            long writePos = pathFile.getFilePointer();
            pathFile.readLine();
            long readPos = file.getFilePointer();

            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = pathFile.read(buf))) {
                pathFile.seek(writePos);
                pathFile.write(buf, 0, n);
                readPos += n;
                writePos += n;
                pathFile.seek(readPos);
            }

            pathFile.setLength(writePos);

            return (length > pathFile.length());
        } finally {
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }

    private ArrayList<String> getAllSubjects() throws IOException {
        READ_WRITE_LOCK.readLock().lock();
        ArrayList<String> subjects = new ArrayList<>();
        try {
            String data;
            file.seek(0);
            String dataLine = file.readLine();
            data = encryption.deEncrypt(dataLine);
            while (data != null) {
                String[] record = data.split(":");
                if (record != null) {
                    subjects.add(record[4]);
                }
                dataLine = file.readLine();
                data = encryption.deEncrypt(dataLine);
            }
            return subjects;
        } finally {
            READ_WRITE_LOCK.readLock().unlock();
        }
    }

}
