/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.observable;

import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.observer.BookObserver;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Randula
 */
public class BookObservable {

    private final ArrayList<BookObserver> bookObservers
            = new ArrayList<>();

    public void addBookObserver(BookObserver bookObserver) {
        bookObservers.add(bookObserver);
    }

    public void removeBookObserver(BookObserver bookObserver) {
        bookObservers.remove(bookObserver);
    }

    public void notifyRate(String newRate)
            throws RemoteException {

        for (BookObserver bookObserver : bookObservers) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        bookObserver.updateRate(newRate);
                    } catch (RemoteException ex) {
                        System.err.println();
                    }
                }
            }.start();
        }
    }

    public void notifyMessage(String message, List<Book> list)
            throws RemoteException {

        for (BookObserver bookObserver : bookObservers) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        bookObserver.setMessage(message);
                        bookObserver.updateBookList(list);
                    } catch (RemoteException ex) {
                        System.err.println();
                    }
                }
            }.start();
        }
    }

}
