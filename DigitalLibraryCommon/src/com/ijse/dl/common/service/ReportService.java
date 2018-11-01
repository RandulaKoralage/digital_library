/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Randula
 */
public interface ReportService extends Remote {

    public int getLogInCount(String date)
            throws RemoteException, IOException;

    public int getSignUpCount(String date)
            throws RemoteException, IOException;

    public int getAccessCount(String date)
            throws RemoteException, IOException;

    public int getDownloadCount(String date)
            throws RemoteException, IOException;

    public Map<String, Integer> subjectAccess(String date)
            throws RemoteException, IOException;

    public HashMap<String, Integer> getsBookCountAccordingToSubjects()
            throws IOException, RemoteException;
}
