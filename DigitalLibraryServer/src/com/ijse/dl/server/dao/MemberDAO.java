/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Membership;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface MemberDAO {

    public String addRecord(Membership membership)
            throws RemoteException, IOException, NotBoundException;

    public boolean deleteRecord(String id)
            throws RemoteException, IOException, NotBoundException;

    public boolean modifyRecord(Membership membership, String id)
            throws RemoteException, IOException, NotBoundException;

    public Membership searchRecord(String id)
            throws RemoteException, IOException, NotBoundException;

    public boolean isAvailabele(String id, String password, String type)
            throws RemoteException, IOException, NotBoundException;

    public int getSignUpCount(String date)
            throws RemoteException, IOException;
}
