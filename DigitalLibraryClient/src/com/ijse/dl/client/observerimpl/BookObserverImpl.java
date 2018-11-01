/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.observerimpl;

import com.ijse.dl.client.view.CatalogForm;
import com.ijse.dl.client.view.ManageBooksPanel;
import com.ijse.dl.client.view.PreviewForm;
import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.observer.BookObserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Randula
 */
public class BookObserverImpl extends
        UnicastRemoteObject implements BookObserver {

    private CatalogForm catalogForm;
    private PreviewForm previewForm;
    private ManageBooksPanel manageBooksPanel;

    public BookObserverImpl(CatalogForm catalogForm)
            throws RemoteException {
        this.catalogForm = catalogForm;
    }

    public BookObserverImpl(PreviewForm previewForm)
            throws RemoteException {
        this.previewForm = previewForm;
    }

    public BookObserverImpl(ManageBooksPanel manageBooksPanel)
            throws RemoteException {
        this.manageBooksPanel = manageBooksPanel;
    }

    @Override
    public void updateRate(String newRate)
            throws RemoteException {
        if (previewForm != null) {
            previewForm.updateRate(newRate);
        }
    }

    @Override
    public void setMessage(String message)
            throws RemoteException {
        if (catalogForm != null) {
            catalogForm.setMessage(message);
        }
        if (manageBooksPanel != null) {
            manageBooksPanel.setMessage(message);
        }
    }

    @Override
    public void updateBookList(List<Book> list)
            throws RemoteException {
        if (manageBooksPanel != null) {
            manageBooksPanel.updateBookList(list);
        }
    }

}
