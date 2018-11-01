/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import com.ijse.dl.common.dto.Access;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface AccessService extends Remote {
    public boolean saveAccess(Access access)
            throws RemoteException, IOException;

    public boolean deleteAccess()
            throws RemoteException, IOException;

    public ArrayList<Access> viewAccessOfADay(String userId, String date)
            throws RemoteException, IOException;
        
}
