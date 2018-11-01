/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.BackUpController;
import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public class BackUpControllerImpl implements BackUpController {

     @Override
    public boolean setBackUp(File target) 
            throws RemoteException, IOException, NotBoundException {
        
        return ServerConnector.getServerConnector()
                .getBackUpService().setBackUp(target);
    }

    @Override
    public boolean resetBackUp(File source) 
            throws RemoteException,IOException, NotBoundException {
        
        return ServerConnector.getServerConnector()
                .getBackUpService().resetBackUp(source);
    }

   
    
}
