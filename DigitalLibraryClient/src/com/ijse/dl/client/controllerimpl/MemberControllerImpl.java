/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.MemberController;
import com.ijse.dl.common.dto.Membership;
import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public class MemberControllerImpl implements MemberController {

    @Override
    public String addAsMember(Membership membership, User user) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getMemberService().addAsMember(membership, user);
    }

    @Override
    public boolean deleteMember(String id) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getMemberService().deleteMember(id);
    }

    @Override
    public boolean modifyMember(Membership membership, String id,User user) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getMemberService().modifyMember(membership, id,user);
    }

    @Override
    public Membership searchMembership(String id) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getMemberService().searchMembership(id);
    }

    @Override
    public boolean isAvailabele(String id, String password, String type) throws RemoteException, IOException, NotBoundException {
        return ServerConnector.getServerConnector().getMemberService().isAvailabele(id, password, type);
    }

}
