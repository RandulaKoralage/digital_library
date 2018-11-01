/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.UserController;
import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class UserControllerImpl implements UserController {

    @Override
    public String addUser(User user) throws IOException, NotBoundException, RemoteException {
        return ServerConnector.getServerConnector().getUserService().addUser(user);
    }

    @Override
    public boolean modifyUser(User user, String id) throws IOException, NotBoundException, RemoteException {
        return ServerConnector.getServerConnector().getUserService().modifyUser(user, id);
    }

    @Override
    public boolean removeUser(String id) throws IOException, NotBoundException, RemoteException {
        return ServerConnector.getServerConnector().getUserService().removeUser(id);
    }

    @Override
    public User searchUser(String id) throws IOException, NotBoundException, RemoteException {
        return ServerConnector.getServerConnector().getUserService().searchUser(id);
    }

    @Override
    public ArrayList<User> getAllUsers() throws IOException, NotBoundException, RemoteException {
        return ServerConnector.getServerConnector().getUserService().getAllUsers();
    }

}
