/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.BookController;
import com.ijse.dl.client.controller.RequestController;
import com.ijse.dl.common.dto.Request;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class RequestControllerImpl implements RequestController {

    @Override
    public boolean requestBook(Request request) throws IOException, RemoteException, MalformedURLException, NotBoundException {
        return ServerConnector.getServerConnector().getRequestService().requestBook(request);
    }

    @Override
    public Request viewRequest(String id) throws IOException, RemoteException, MalformedURLException, NotBoundException {
        return ServerConnector.getServerConnector().getRequestService().viewRequest(id);
    }

    @Override
    public boolean deleteRequest(String id) throws IOException, RemoteException, MalformedURLException, NotBoundException {
        return ServerConnector.getServerConnector().getRequestService().deleteRequest(id);
    }

    @Override
    public ArrayList<Request> getAllRequests() throws IOException, RemoteException, MalformedURLException, NotBoundException {
        return ServerConnector.getServerConnector().getRequestService().getAllRequests();
    }

}
