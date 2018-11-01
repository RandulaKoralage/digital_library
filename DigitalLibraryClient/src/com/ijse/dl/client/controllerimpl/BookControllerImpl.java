/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.BookController;
import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.observer.BookObserver;
import com.ijse.dl.common.service.BookService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class BookControllerImpl implements BookController {

    @Override
    public boolean newBook(Book book) throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        BookService bookService
                = ServerConnector.getServerConnector().getBookService();
        boolean isAdded = bookService.newBook(book);
        return isAdded;
    }

    @Override
    public Book searchBook(String id)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().searchBook(id);
    }

    @Override
    public boolean checkBooksAvailbility(String id)
            throws IOException, RemoteException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBook(String id)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().deleteBook(id);
    }

    @Override
    public ArrayList<Book> getAll()
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector().getBookService().getAll();
    }

    @Override
    public boolean updateBook(Book book, String id)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().updateBook(book, id);
    }

    @Override
    public String getNextId() throws IOException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserveBook(String id)
            throws RemoteException, NotBoundException,
            MalformedURLException, IOException {

        return ServerConnector.getServerConnector()
                .getBookService().reserveBook(id);
    }

    @Override
    public boolean releaseBook(String id)
            throws RemoteException, NotBoundException,
            MalformedURLException, IOException {

        return ServerConnector.getServerConnector()
                .getBookService().releaseBook(id);
    }

    @Override
    public ArrayList<Book> searchBookByTypeAndSubject(
            String subject, String type) throws IOException,
            RemoteException, MalformedURLException, NotBoundException {
        BookService bookService
                = ServerConnector.getServerConnector().getBookService();
        return bookService.searchBookByTypeAndSubject(subject, type);
    }

    @Override
    public ArrayList<Book> searchBookBySubject(String subject)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        BookService bookService
                = ServerConnector.getServerConnector().getBookService();
        return bookService.searchBookBySubject(subject);
    }

    @Override
    public ArrayList<Book> searchBookByType(String type)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().searchBookByType(type);
    }

    @Override
    public boolean updateRate(Book book, String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().updateRate(book, id);
    }

    @Override
    public ArrayList<Book> searchBookByName(String name)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().searchBookByName(name);
    }

    @Override
    public ArrayList<Book> searchBookByAuthor(String author)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().searchBookByAuthor(author);
    }

    @Override
    public byte[] viewBook(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getBookService().viewBook(id);
    }

    @Override
    public void addBookObserver(BookObserver bookObserver) throws RemoteException, IOException, NotBoundException {
        ServerConnector.getServerConnector().getBookService().addBookObserver(bookObserver);
    }

    @Override
    public void removeBookObserver(BookObserver bookObserver) throws RemoteException, IOException, NotBoundException {
       ServerConnector.getServerConnector().getBookService().removeBookObserver(bookObserver);
    }

   

}
