/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface BackUpService extends Remote {

    public boolean setBackUp(File target) 
            throws IOException, RemoteException;

    public boolean resetBackUp(File source) 
            throws IOException, RemoteException;
}
