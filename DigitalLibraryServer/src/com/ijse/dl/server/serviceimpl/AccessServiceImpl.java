/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Access;
import com.ijse.dl.common.service.AccessService;
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
public class AccessServiceImpl extends
        UnicastRemoteObject implements AccessService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public AccessServiceImpl() throws RemoteException {

    }

    @Override
    public boolean saveAccess(Access access)
            throws RemoteException, IOException {

        return dAOFactory.getAccessDAO().saveRecord(access);
    }

    @Override
    public boolean deleteAccess()
            throws RemoteException, IOException {

        return dAOFactory.getAccessDAO().deleteRecord();
    }

    @Override
    public ArrayList<Access> viewAccessOfADay(String userId, String date)
            throws RemoteException, IOException {

        return dAOFactory.getAccessDAO().viewAccessOfADay(userId, date);
    }

}
