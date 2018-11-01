/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Request;
import com.ijse.dl.common.service.RequestService;
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
public class RequestServiceImpl extends
        UnicastRemoteObject implements RequestService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public RequestServiceImpl() throws RemoteException {

    }

    @Override
    public boolean requestBook(Request request)
            throws IOException, RemoteException {

        return dAOFactory.getRequestDAO().addRequest(request);
    }

    @Override
    public Request viewRequest(String id)
            throws IOException, RemoteException {
        return dAOFactory.getRequestDAO().serchRequest(id);
    }

    @Override
    public boolean deleteRequest(String id)
            throws IOException, RemoteException {
        return dAOFactory.getRequestDAO().deleteRequest(id);
    }

    @Override
    public ArrayList<Request> getAllRequests()
            throws IOException, RemoteException {
        return dAOFactory.getRequestDAO().viewAllRequests();
    }

}
