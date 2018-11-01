/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.service.BackUpService;
import com.ijse.dl.common.util.BackUp;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Randula
 */
public class BackUpServiceImpl extends
        UnicastRemoteObject implements BackUpService {

    public BackUpServiceImpl() throws RemoteException {

    }

    @Override
    public boolean setBackUp(File target) throws IOException, RemoteException {
        boolean isSaved = false;
        File source = new File("./src/db/");
        BackUp backUp = new BackUp();
        backUp.copy(source, target);
        return isSaved;
    }

    @Override
    public boolean resetBackUp(File source) throws IOException, RemoteException {
        boolean isSaved = false;
        BackUp backUp = new BackUp();
        File target = new File("./src/db/");
        backUp.copy(source, target);
        isSaved = target.exists();
        return isSaved;
    }

}
