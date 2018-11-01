/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import com.ijse.dl.common.dto.Membership;
import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface MemberService extends Remote {

    public String addAsMember(Membership membership,User user)
            throws RemoteException, IOException, NotBoundException;

    public boolean deleteMember(String id)
            throws RemoteException, IOException, NotBoundException;

    public boolean modifyMember(Membership membership, String id,User user)
            throws RemoteException, IOException, NotBoundException;

    public Membership searchMembership(String id)
            throws RemoteException, IOException, NotBoundException;

    public boolean isAvailabele(String id, String password,String type)
            throws RemoteException, IOException, NotBoundException;
}
