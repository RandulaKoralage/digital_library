/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.service.SubjectService;
import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.SubjectObserver;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import com.ijse.dl.server.observable.SubjectObservable;
import com.ijse.dl.server.reservation.SubjectReservation;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Randula
 */
public class SubjectServiceImpl extends
        UnicastRemoteObject implements SubjectService {

    private static DAOFactory dAOFactory = new DAOFactoryImpl();
    private static final SubjectReservation SUBJECT_RESERVATION
            = new SubjectReservation();
    private static final SubjectObservable SUBJECT_OBSERVABLE
            = new SubjectObservable();

    public SubjectServiceImpl() throws RemoteException, IOException {

    }

    @Override
    public boolean addRecord(Subject subject)
            throws IOException, RemoteException {
        if (dAOFactory.getSubjectDAO().addRecord(subject)) {
            List<Subject> list = getAll();
            SUBJECT_OBSERVABLE.notifySubjectObservers(
                    "New Subject Added...", list);
            return true;
        }
        return false;
    }

    @Override
    public Subject searchRecord(String id)
            throws IOException, RemoteException {
        return dAOFactory.getSubjectDAO().searchRecord(id);
    }

    @Override
    public boolean checkRecordAvailbility(String id)
            throws IOException, RemoteException {
        return dAOFactory.getSubjectDAO().checkRecordAvailbility(id);
    }

    @Override
    public boolean deleteRecord(String id)
            throws IOException, RemoteException {

        if (SUBJECT_RESERVATION.reserveSubject(id, this)) {
            if (dAOFactory.getSubjectDAO().deleteRecord(id)) {
                List<Subject> list = getAll();
                SUBJECT_OBSERVABLE.notifySubjectObservers("Subject Id : "
                        + id + " has Deleted...", list);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Subject> getAll()
            throws IOException, RemoteException {
        return dAOFactory.getSubjectDAO().getAll();
    }

    @Override
    public boolean updateRecord(Subject subject, String id)
            throws IOException, RemoteException {
        if (SUBJECT_RESERVATION.reserveSubject(id, this)) {
            if (dAOFactory.getSubjectDAO().updateRecord(subject, id)) {
                List<Subject> list = getAll();
                SUBJECT_OBSERVABLE.notifySubjectObservers("Subject Id : "
                        + id + " has Updated...", list);
                return true;
            }
        }
        return false;
    }

    @Override
    public Subject searchRecordByName(String name)
            throws IOException, RemoteException {
        return dAOFactory.getSubjectDAO().searchRecordByName(name);
    }

    @Override
    public boolean reserveSubject(String id) throws RemoteException {

        return SUBJECT_RESERVATION.reserveSubject(id, this);
    }

    @Override
    public boolean releaseSubject(String id) throws RemoteException {

        return SUBJECT_RESERVATION.releaseSubject(id, this);
    }

    @Override
    public void addSubjectObserver(SubjectObserver subjectObserver)
            throws RemoteException {
        SUBJECT_OBSERVABLE.addSubjectObserver(subjectObserver);
    }

    @Override
    public void removeSubjectObserver(SubjectObserver subjectObserver)
            throws RemoteException {
        SUBJECT_OBSERVABLE.removeSubjectObserver(subjectObserver);
    }

}
