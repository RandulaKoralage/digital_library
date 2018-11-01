/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.observer.BookObserver;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface BookService extends Remote {

   
    public boolean newBook(Book book)
            throws IOException, RemoteException;

    public Book searchBook(String id)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookByName(String name)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookByAuthor(String author)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookByTypeAndSubject(
            String subject, String type)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookBySubject(String subject)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookByType(String type)
            throws IOException, RemoteException;

    public byte[] viewBook(String id)
            throws IOException, RemoteException;

    public boolean checkBooksAvailbility(String id)
            throws IOException, RemoteException;

    public boolean deleteBook(String id)
            throws IOException, RemoteException;

    public ArrayList<Book> getAll()
            throws IOException, RemoteException;

    public boolean updateBook(Book book, String id)
            throws IOException, RemoteException;

    public boolean updateRate(Book book, String id)
            throws IOException, RemoteException;

    public String getNextId()
            throws IOException, RemoteException;

    public boolean reserveBook(String id)
            throws RemoteException;

    public boolean releaseBook(String id)
            throws RemoteException;

    public void addBookObserver(BookObserver bookObserver)
            throws RemoteException;
      
       public void removeBookObserver(BookObserver bookObserver)
            throws RemoteException;
}
