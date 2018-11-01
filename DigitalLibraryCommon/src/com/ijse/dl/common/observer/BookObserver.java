/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.observer;

import com.ijse.dl.common.dto.Book;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Randula
 */
public interface BookObserver extends Remote{
    
    public void updateRate(String newRate) throws RemoteException;
    
    public void setMessage(String message) throws RemoteException;
    
    public void updateBookList(List<Book> list) throws RemoteException;
}
