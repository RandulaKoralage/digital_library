/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface UserDAO {

    public String addRecord(User user)
            throws IOException, RemoteException;

    public boolean modifyRecord(User user, String id)
            throws IOException, RemoteException;

    public boolean removeRecord(String id)
            throws IOException, RemoteException;

    public User searchRecord(String id)
            throws IOException, RemoteException;

    public ArrayList<User> getAllRecord()
            throws IOException, RemoteException;
}
