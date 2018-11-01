/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import com.ijse.dl.common.dto.Request;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface RequestController {

    public boolean requestBook(Request request) throws IOException,
            RemoteException, MalformedURLException, NotBoundException;

    public Request viewRequest(String id) throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public boolean deleteRequest(String id) throws IOException, RemoteException,
            MalformedURLException, NotBoundException;

    public ArrayList<Request> getAllRequests() throws IOException, RemoteException,
            MalformedURLException, NotBoundException;
}
