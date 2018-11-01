/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Request;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface RequestDAO {

    public boolean addRequest(Request request)
            throws IOException, RemoteException;

    public Request serchRequest(String id)
            throws IOException, RemoteException;

    public boolean deleteRequest(String id)
            throws IOException, RemoteException;

    public ArrayList<Request> viewAllRequests()
            throws IOException, RemoteException;
}
