/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.BookObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface BookController {

    public boolean newBook(Book book)
            throws IOException, RemoteException, NotBoundException;

    public Book searchBook(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Book> searchBookByName(String name)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Book> searchBookByAuthor(String author)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public byte[] viewBook(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean checkBooksAvailbility(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean deleteBook(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Book> getAll()
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Book> searchBookBySubject(String subject)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Book> searchBookByType(String type)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Book> searchBookByTypeAndSubject(
            String subject, String type)
            throws IOException, RemoteException, NotBoundException;

    public boolean updateBook(Book book, String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean updateRate(Book book, String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public String getNextId()
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean reserveBook(String id)
            throws RemoteException,IOException,NotBoundException;

    public boolean releaseBook(String id)
            throws RemoteException,IOException,NotBoundException;
    
    public void addBookObserver(BookObserver bookObserver)
            throws RemoteException, IOException, NotBoundException;
      
       public void removeBookObserver(BookObserver bookObserver)
            throws RemoteException, IOException, NotBoundException;
}
