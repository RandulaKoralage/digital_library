/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import com.ijse.dl.common.dto.Log;
import com.ijse.dl.common.observer.LogInObserver;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface LogController {

    public boolean saveLog(Log log)
            throws RemoteException, IOException, NotBoundException;

    public boolean deleteLog()
            throws RemoteException, IOException, NotBoundException;

    public ArrayList<Log> searchLog(String id, String date)
            throws RemoteException, IOException, NotBoundException;

    public ArrayList<Log> searchLogsOfADay(String date)
            throws RemoteException, IOException, NotBoundException;

}
