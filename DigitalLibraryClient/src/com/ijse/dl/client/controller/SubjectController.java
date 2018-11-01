/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.BookObserver;
import com.ijse.dl.common.observer.SubjectObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface SubjectController {

    public boolean addRecord(Subject subject)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public Subject searchRecord(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public Subject searchRecordByName(String name)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean checkRecordAvailbility(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean deleteRecord(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Subject> getAll()
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean updateRecord(Subject subject, String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean reserveSubject(String id)
            throws RemoteException, IOException, NotBoundException;

    public boolean releaseSubject(String id)
            throws RemoteException, IOException, NotBoundException;

    public void addSubjectObserver(SubjectObserver subjectObserver)
            throws RemoteException, IOException, NotBoundException;

    public void removeSubjectObserver(SubjectObserver subjectObserver)
            throws RemoteException, IOException, NotBoundException;
}
