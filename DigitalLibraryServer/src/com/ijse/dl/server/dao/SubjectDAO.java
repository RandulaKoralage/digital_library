/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Subject;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface SubjectDAO {

    public boolean addRecord(Subject subject)
            throws IOException, RemoteException;

    public Subject searchRecord(String id)
            throws IOException, RemoteException;

    public Subject searchRecordByName(String name)
            throws IOException, RemoteException;

    public boolean checkRecordAvailbility(String id)
            throws IOException, RemoteException;

    public boolean deleteRecord(String id)
            throws IOException, RemoteException;

    public ArrayList<Subject> getAll()
            throws IOException, RemoteException;

    public boolean updateRecord(Subject subject, String id)
            throws IOException, RemoteException;

}
