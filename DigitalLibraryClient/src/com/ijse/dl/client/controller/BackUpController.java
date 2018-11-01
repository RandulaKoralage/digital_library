/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface BackUpController {

    public boolean setBackUp(File target) throws RemoteException, IOException, NotBoundException;

    public boolean resetBackUp(File source) throws RemoteException, IOException, NotBoundException;

}
