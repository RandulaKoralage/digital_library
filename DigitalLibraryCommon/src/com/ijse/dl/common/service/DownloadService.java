/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.service;

import com.ijse.dl.common.dto.Download;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface DownloadService extends Remote {

    public boolean saveDownload(Download download)
            throws RemoteException, IOException;

    public boolean deleteDownload()
            throws RemoteException, IOException;

    public ArrayList<Download> viewDownloadsOfADay(String date)
            throws RemoteException, IOException;

    public ArrayList<Download> viewRecentDownloads(String userId)
            throws RemoteException, IOException;
}
