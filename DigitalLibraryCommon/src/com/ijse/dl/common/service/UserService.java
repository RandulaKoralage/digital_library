/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface UserService extends Remote {

    public String addUser(User user)
            throws IOException, RemoteException;

    public boolean modifyUser(User user, String id)
            throws IOException, RemoteException;

    public boolean removeUser(String id)
            throws IOException, RemoteException;

    public User searchUser(String id)
            throws IOException, RemoteException;

    public ArrayList<User> getAllUsers()
            throws IOException, RemoteException;
}
