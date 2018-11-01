/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Book;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Randula
 */
public interface BookDAO {

    public boolean addRecord(Book book)
            throws IOException, RemoteException;

    public Book searchRecord(String id)
            throws IOException, RemoteException;

    public ArrayList<Book> searchRecordByName(String name)
            throws IOException, RemoteException;

    public ArrayList<Book> searchRecordByAuthor(String author)
            throws IOException, RemoteException;

    public byte[] viewBookRecord(String id)
            throws IOException, RemoteException;

    public boolean deleteRecord(String id)
            throws IOException, RemoteException;

    public ArrayList<Book> getAll()
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookByTypeAndSubject(
            String subject, String type)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookBySubject(String subject)
            throws IOException, RemoteException;

    public ArrayList<Book> searchBookByType(String type)
            throws IOException, RemoteException;

    public boolean updateRecord(Book book, String id)
            throws IOException, RemoteException;

    public boolean updateRate(Book book, String id)
            throws IOException, RemoteException;

    public HashMap<String, Integer> getsBookCountAccordingToSubjects()
            throws IOException, RemoteException;

}
