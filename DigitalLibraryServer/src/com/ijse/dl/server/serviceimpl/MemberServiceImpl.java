/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Membership;
import com.ijse.dl.common.dto.User;
import com.ijse.dl.common.service.MemberService;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Randula
 */
public class MemberServiceImpl extends
        UnicastRemoteObject implements MemberService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public MemberServiceImpl() throws RemoteException, IOException {

    }

    @Override
    public String addAsMember(Membership membership, User user) 
            throws RemoteException, IOException, NotBoundException {
        
        String id = dAOFactory.getUserDAO().addRecord(user);
        boolean isSaved = false;
        if (id != null) {
            membership.setId(id);
            String id2 = dAOFactory.getMemberDAO().addRecord(membership);
            if (id.equals(id2)) {
                return id;
            }
        }
        return null;
    }

    @Override
    public boolean deleteMember(String id) 
            throws RemoteException, IOException, NotBoundException {
        
        return dAOFactory.getMemberDAO().deleteRecord(id);
    }

    @Override
    public boolean modifyMember(Membership membership, String id, User user) 
            throws RemoteException, IOException, NotBoundException {
        
        boolean isUserUpdated = dAOFactory.getUserDAO().modifyRecord(user, id);
        boolean isModified = false;
        if (isUserUpdated) {
            isModified = dAOFactory.getMemberDAO().modifyRecord(membership, id);
        }
        return isModified;
    }

    @Override
    public Membership searchMembership(String id) 
            throws RemoteException, IOException, NotBoundException {
        
        return dAOFactory.getMemberDAO().searchRecord(id);
    }

    @Override
    public boolean isAvailabele(String id, String password, String type)           
            throws RemoteException, IOException, NotBoundException {
        
        return dAOFactory.getMemberDAO().isAvailabele(id, password, type);
    }

}
