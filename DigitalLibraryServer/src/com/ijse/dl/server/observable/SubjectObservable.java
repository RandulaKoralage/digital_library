/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.observable;

import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.SubjectObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Randula
 */
public class SubjectObservable {

    private final ArrayList<SubjectObserver> subjectObservers
            = new ArrayList<>();

    public void addSubjectObserver(SubjectObserver subjectObserver) {
        subjectObservers.add(subjectObserver);
    }

    public void removeSubjectObserver(SubjectObserver subjectObserver) {
        subjectObservers.remove(subjectObserver);
    }

    public void notifySubjectObservers(String message, List<Subject> subjectList)
            throws RemoteException {

        for (SubjectObserver subjectObserver : subjectObservers) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        subjectObserver.setNewSubjectList(subjectList);
                        subjectObserver.setMessage(message);
                    } catch (RemoteException ex) {
                        System.err.println();
                    }
                }
            }.start();
        }
    }
}
