/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Download;
import com.ijse.dl.common.service.DownloadService;
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
public class DownloadServiceImpl extends
        UnicastRemoteObject implements DownloadService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public DownloadServiceImpl() throws RemoteException {

    }

    @Override
    public boolean saveDownload(Download download)
            throws RemoteException, IOException {

        return dAOFactory.getDownloadDAO().saveRecord(download);
    }

    @Override
    public boolean deleteDownload()
            throws RemoteException, IOException {

        return dAOFactory.getDownloadDAO().deleteRecord();
    }

    @Override
    public ArrayList<Download> viewDownloadsOfADay(String date)
            throws RemoteException, IOException {

        return dAOFactory.getDownloadDAO().viewDownloadsOfADay(date);
    }

    @Override
    public ArrayList<Download> viewRecentDownloads(String userId)
            throws RemoteException, IOException {

        return dAOFactory.getDownloadDAO().viewRecentDownloads(userId);
    }

}
