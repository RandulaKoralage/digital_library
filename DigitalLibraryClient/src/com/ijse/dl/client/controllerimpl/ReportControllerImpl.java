/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.ReportController;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Randula
 */
public class ReportControllerImpl implements ReportController {

    @Override
    public int getLogInCount(String date)
            throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector()
                .getReportService().getLogInCount(date);
    }

    @Override
    public int getSignUpCount(String date)
            throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector()
                .getReportService().getSignUpCount(date);
    }

    @Override
    public int getAccessCount(String date)
            throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector()
                .getReportService().getAccessCount(date);
    }

    @Override
    public int getDownloadCount(String date)
            throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector()
                .getReportService().getDownloadCount(date);
    }

    @Override
    public Map<String, Integer> subjectAccess(String date)
            throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector()
                .getReportService().subjectAccess(date);
    }

    @Override
    public HashMap<String, Integer> getsBookCountAccordingToSubjects()
            throws RemoteException, IOException, NotBoundException {

        return ServerConnector.getServerConnector().getReportService()
                .getsBookCountAccordingToSubjects();
    }

}
