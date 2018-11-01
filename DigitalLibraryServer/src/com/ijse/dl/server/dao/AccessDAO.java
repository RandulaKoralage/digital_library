/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Access;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Randula
 */
public interface AccessDAO {

    public boolean saveRecord(Access access)
            throws RemoteException, IOException;

    public boolean deleteRecord()
            throws RemoteException, IOException;

    public ArrayList<Access> viewAccessOfADay(String userId, String date)
            throws RemoteException, IOException;

    public int getAccessCount(String date)
            throws RemoteException, IOException;

    public Map<String, Integer> subjectAccess(String date)
            throws RemoteException, IOException;
}
