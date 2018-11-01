/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Log;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface LogDAO {

    public boolean saveRecord(Log log)
            throws RemoteException, IOException;

    public boolean deleteRecord()
            throws RemoteException, IOException;

    public ArrayList<Log> searchRecord(String id, String date)
            throws RemoteException, IOException;

    public ArrayList<Log> searchLogsOfADay(String date)
            throws RemoteException, IOException;

    public int getSignInCount(String date)
            throws RemoteException, IOException;
}
