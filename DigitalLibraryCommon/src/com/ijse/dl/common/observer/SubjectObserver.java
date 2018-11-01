/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.observer;

import com.ijse.dl.common.dto.Subject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Randula
 */
public interface SubjectObserver extends Remote {

    public void setNewSubjectList(List<Subject> subjectList)
            throws RemoteException;

    public void setMessage(String message) 
            throws RemoteException;
}
