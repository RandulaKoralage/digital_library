/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.User;
import com.ijse.dl.common.service.UserService;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class UserServiceImpl extends 
        UnicastRemoteObject implements UserService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public UserServiceImpl() throws RemoteException, IOException {

    }

    @Override
    public String addUser(User user) 
            throws IOException, RemoteException {
        
        return dAOFactory.getUserDAO().addRecord(user);
    }

    @Override
    public boolean modifyUser(User user, String id) 
            throws IOException, RemoteException {
        
        return dAOFactory.getUserDAO().modifyRecord(user, id);
    }

    @Override
    public boolean removeUser(String id) 
            throws IOException, RemoteException {
        
        return dAOFactory.getUserDAO().removeRecord(id);
    }

    @Override
    public User searchUser(String id) 
            throws IOException, RemoteException {
        
        return dAOFactory.getUserDAO().searchRecord(id);
    }

    @Override
    public ArrayList<User> getAllUsers()
            throws IOException, RemoteException {
        
        return dAOFactory.getUserDAO().getAllRecord();
    }

}
