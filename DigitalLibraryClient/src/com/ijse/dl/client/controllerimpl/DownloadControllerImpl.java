/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerimpl;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.DownloadController;
import com.ijse.dl.common.dto.Download;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class DownloadControllerImpl implements DownloadController {

    @Override
    public boolean saveDownload(Download download)
            throws RemoteException, IOException, NotBoundException {
        
        return ServerConnector.getServerConnector()
                .getDownloadService().saveDownload(download);
    }

    @Override
    public boolean deleteDownload()
            throws RemoteException, IOException, NotBoundException {
        
        return ServerConnector.getServerConnector()
                .getDownloadService().deleteDownload();
    }

    @Override
    public ArrayList<Download> viewDownloadsOfADay(String date)
            throws RemoteException, IOException, NotBoundException {
        
        return ServerConnector.getServerConnector()
                .getDownloadService().viewDownloadsOfADay(date);
    }

    @Override
    public ArrayList<Download> viewRecentDownloads(String userId)
            throws RemoteException, IOException, NotBoundException {
        
        return ServerConnector.getServerConnector()
                .getDownloadService().viewRecentDownloads(userId);
    }

}
