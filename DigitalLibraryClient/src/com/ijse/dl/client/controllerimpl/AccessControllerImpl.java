/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.AccessController;
import com.ijse.dl.common.dto.Access;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class AccessControllerImpl implements AccessController{

    @Override
    public boolean saveAccess(Access access) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getAccessService().saveAccess(access);
    }

    @Override
    public boolean deleteAccess() throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getAccessService().deleteAccess();
    }

    @Override
    public ArrayList<Access> viewAccessOfADay(String userId, String date) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getAccessService().viewAccessOfADay(userId, date);
    }
    
}