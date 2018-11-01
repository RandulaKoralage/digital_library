/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.SubjectController;
import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.SubjectObserver;
import com.ijse.dl.common.service.SubjectService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class SubjectControllerImpl implements SubjectController {

    @Override
    public boolean addRecord(Subject subject)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        SubjectService subjectService = ServerConnector.
                getServerConnector().getSubjectService();
        boolean isAdded = subjectService.addRecord(subject);
        return isAdded;

    }

    @Override
    public Subject searchRecord(String id)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getSubjectService().searchRecord(id);
    }

    @Override
    public Subject searchRecordByName(String name)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getSubjectService().searchRecordByName(name);
    }

    @Override
    public boolean checkRecordAvailbility(String id)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getSubjectService().checkRecordAvailbility(id);
    }

    @Override
    public boolean deleteRecord(String id)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getSubjectService().deleteRecord(id);
    }

    @Override
    public ArrayList<Subject> getAll()
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getSubjectService().getAll();
    }

    @Override
    public boolean updateRecord(Subject subject, String id)
            throws IOException, RemoteException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getSubjectService().updateRecord(subject, id);
    }

    @Override
    public boolean reserveSubject(String id)
            throws RemoteException, NotBoundException,
            MalformedURLException, IOException {

        return ServerConnector.getServerConnector()
                .getSubjectService().reserveSubject(id);
    }

    @Override
    public boolean releaseSubject(String id)
            throws RemoteException, NotBoundException,
            MalformedURLException, IOException {

        return ServerConnector.getServerConnector()
                .getSubjectService().releaseSubject(id);
    }

    @Override
    public void addSubjectObserver(SubjectObserver subjectObserver) 
            throws RemoteException, IOException, NotBoundException {
        
      ServerConnector.getServerConnector().getSubjectService()
              .addSubjectObserver(subjectObserver);
    }
    @Override
    public void removeSubjectObserver(SubjectObserver subjectObserver)
            throws RemoteException, IOException, NotBoundException {
        
         ServerConnector.getServerConnector().getSubjectService()
                 .removeSubjectObserver(subjectObserver);
    }

}
