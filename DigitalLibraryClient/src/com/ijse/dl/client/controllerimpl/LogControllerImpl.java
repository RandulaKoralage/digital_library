/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.LogController;
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
public class LogControllerImpl implements LogController {

    @Override
    public boolean saveLog(Log log)
            throws RemoteException, IOException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getLogService().saveLog(log);
    }

    @Override
    public boolean deleteLog()
            throws RemoteException, IOException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getLogService().deleteLog();
    }

    @Override
    public ArrayList<Log> searchLog(String id, String date)
            throws RemoteException, IOException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getLogService().searchLog(id, date);
    }

    @Override
    public ArrayList<Log> searchLogsOfADay(String date)
            throws RemoteException, IOException, NotBoundException {

        return ServerConnector.getServerConnector()
                .getLogService().searchLogsOfADay(date);
    }

}
