/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.observer.BookObserver;
import com.ijse.dl.common.service.BookService;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import com.ijse.dl.server.observable.BookObservable;
import com.ijse.dl.server.reservation.BookReservation;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Randula
 */
public class BookServiceImpl extends
        UnicastRemoteObject implements BookService {

    private static final DAOFactory dAOFactory
            = new DAOFactoryImpl();
    private static final BookReservation BOOK_RESERVATION
            = new BookReservation();
    private static final BookObservable BOOK_OBSERVABLE
            = new BookObservable();

    public BookServiceImpl() throws RemoteException {

    }

    @Override
    public boolean newBook(Book book)
            throws IOException, RemoteException {
        if (dAOFactory.getBookDAO().addRecord(book)) {
            List<Book> list = getAll();
            BOOK_OBSERVABLE.notifyMessage("New " + book.getSubject()
                    + " Book Added...", list);
            return true;
        }
        return false;
    }

    @Override
    public Book searchBook(String id)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().searchRecord(id);
    }

    @Override
    public boolean checkBooksAvailbility(String id)
            throws IOException, RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBook(String id)
            throws IOException, RemoteException {

        if (BOOK_RESERVATION.reserveBook(id, this)) {
            if (dAOFactory.getBookDAO().deleteRecord(id)) {
                List<Book> list = getAll();
                BOOK_OBSERVABLE.notifyMessage("Book, mCode : " + id
                        + " has Deleted...", list);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Book> getAll()
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().getAll();
    }

    @Override
    public boolean updateBook(Book book, String id)
            throws IOException, RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNextId()
            throws IOException, RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserveBook(String id)
            throws RemoteException {

        return BOOK_RESERVATION.reserveBook(id, this);
    }

    @Override
    public boolean releaseBook(String id)
            throws RemoteException {

        return BOOK_RESERVATION.releaseBook(id, this);
    }

    @Override
    public ArrayList<Book>
            searchBookByTypeAndSubject(String subject, String type)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO()
                .searchBookByTypeAndSubject(subject, type);
    }

    @Override
    public ArrayList<Book> searchBookBySubject(String subject)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().searchBookBySubject(subject);
    }

    @Override
    public ArrayList<Book> searchBookByType(String type)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().searchBookByType(type);
    }

    @Override
    public boolean updateRate(Book book, String id)
            throws IOException, RemoteException {

        if (dAOFactory.getBookDAO().updateRate(book, id)) {
            BOOK_OBSERVABLE.notifyRate(book.getRating());
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Book> searchBookByName(String name)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().searchRecordByName(name);
    }

    @Override
    public ArrayList<Book> searchBookByAuthor(String author)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().searchRecordByAuthor(author);
    }

    @Override
    public byte[] viewBook(String id)
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().viewBookRecord(id);
    }

    @Override
    public void addBookObserver(BookObserver bookObserver)
            throws RemoteException {
        BOOK_OBSERVABLE.addBookObserver(bookObserver);
    }

    @Override
    public void removeBookObserver(BookObserver bookObserver)
            throws RemoteException {
        BOOK_OBSERVABLE.removeBookObserver(bookObserver);
    }

}
