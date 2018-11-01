/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Randula
 */
public interface ReportController {

    public int getLogInCount(String date)
            throws RemoteException, IOException, NotBoundException;

    public int getSignUpCount(String date)
            throws RemoteException, IOException, NotBoundException;

    public int getAccessCount(String date)
            throws RemoteException, IOException, NotBoundException;

    public int getDownloadCount(String date)
            throws RemoteException, IOException, NotBoundException;

    public Map<String, Integer> subjectAccess(String date)
            throws RemoteException, IOException, NotBoundException;

    public HashMap<String, Integer> getsBookCountAccordingToSubjects()
            throws RemoteException, IOException, NotBoundException;
}
