/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.observer;

import com.ijse.dl.common.dto.Log;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface LogInObserver extends Remote {

    public void updateLog(Log log) throws RemoteException;

    public void setCount(int count) throws RemoteException;

}
