/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Log;
import com.ijse.dl.common.service.LogService;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class LogServiceImpl extends
        UnicastRemoteObject implements LogService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public LogServiceImpl() throws RemoteException {

    }

    @Override
    public boolean saveLog(Log log) throws RemoteException, IOException {
        return dAOFactory.getLogDAO().saveRecord(log);
    }

    @Override
    public boolean deleteLog() throws RemoteException, IOException {
        return dAOFactory.getLogDAO().deleteRecord();
    }

    @Override
    public ArrayList<Log> searchLog(String id, String date)
            throws RemoteException, IOException {

        return dAOFactory.getLogDAO().searchRecord(id, date);
    }

    @Override
    public ArrayList<Log> searchLogsOfADay(String date)
            throws RemoteException, IOException {

        return dAOFactory.getLogDAO().searchLogsOfADay(date);
    }

}
