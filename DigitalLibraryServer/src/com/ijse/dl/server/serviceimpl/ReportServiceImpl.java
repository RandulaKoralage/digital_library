/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.service.ReportService;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Randula
 */
public class ReportServiceImpl extends
        UnicastRemoteObject implements ReportService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public ReportServiceImpl() throws RemoteException {

    }

    @Override
    public int getLogInCount(String date)
            throws RemoteException, IOException {

        return dAOFactory.getLogDAO().getSignInCount(date);
    }

    @Override
    public int getSignUpCount(String date)
            throws RemoteException, IOException {

        return dAOFactory.getMemberDAO().getSignUpCount(date);
    }

    @Override
    public int getAccessCount(String date)
            throws RemoteException, IOException {

        return dAOFactory.getAccessDAO().getAccessCount(date);
    }

    @Override
    public int getDownloadCount(String date)
            throws RemoteException, IOException {

        return dAOFactory.getDownloadDAO().getDownloadCount(date);
    }

    @Override
    public Map<String, Integer> subjectAccess(String date)
            throws RemoteException, IOException {

        return dAOFactory.getAccessDAO().subjectAccess(date);
    }

    @Override
    public HashMap<String, Integer> getsBookCountAccordingToSubjects()
            throws IOException, RemoteException {

        return dAOFactory.getBookDAO().getsBookCountAccordingToSubjects();
    }

}
