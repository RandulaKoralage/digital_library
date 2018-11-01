/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface UserController {

    public String addUser(User user)
            throws IOException, NotBoundException, RemoteException;

    public boolean modifyUser(User user, String id)
            throws IOException, NotBoundException, RemoteException;

    public boolean removeUser(String id)
            throws IOException, NotBoundException, RemoteException;

    public User searchUser(String id)
            throws IOException, NotBoundException, RemoteException;

    public ArrayList<User> getAllUsers()
            throws IOException, NotBoundException, RemoteException;
    
}
