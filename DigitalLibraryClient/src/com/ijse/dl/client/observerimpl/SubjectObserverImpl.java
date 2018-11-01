/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.observerimpl;

import com.ijse.dl.client.view.AllSubjectsPanel;
import com.ijse.dl.client.view.ManageSubjectPanel;
import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.SubjectObserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Randula
 */
public class SubjectObserverImpl extends
        UnicastRemoteObject implements SubjectObserver{
    
    private  ManageSubjectPanel manageSubjectPanel;
    private AllSubjectsPanel allSubjectsPanel;

    public SubjectObserverImpl(ManageSubjectPanel manageSubjectPanel)
            throws RemoteException{
        
        this.manageSubjectPanel = manageSubjectPanel;
    }
    
    public SubjectObserverImpl (AllSubjectsPanel allSubjectsPanel) 
            throws RemoteException{
        
        this.allSubjectsPanel = allSubjectsPanel;
    }
    
    @Override
    public void setNewSubjectList(List<Subject> subjectList)
            throws RemoteException {
        
        if(manageSubjectPanel != null){
            manageSubjectPanel.setNewSubjectList(subjectList);
        }
        if(allSubjectsPanel != null){
            allSubjectsPanel.setNewSubjectList(subjectList);
        }
        
    }

    @Override
    public void setMessage(String message) throws RemoteException {
         if(manageSubjectPanel != null){
             manageSubjectPanel.setMessage(message);
        }
       
    }
    
}
