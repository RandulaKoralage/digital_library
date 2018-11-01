/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.reservation;

import com.ijse.dl.common.service.BookService;
import java.util.HashMap;

/**
 *
 * @author Randula
 */
public class BookReservation {

    private final static HashMap<String, BookService> RESERVED_DATA
            = new HashMap<>();

    /**
     * @param id the id of object
     * @param bookService the object to reserve
     * @return whether it is reserved
     */
    public boolean reserveBook(String id, BookService bookService) {

        if (RESERVED_DATA.containsKey(id)) {
            return (bookService.equals(RESERVED_DATA.get(id)));
        } else {
            RESERVED_DATA.put(id, bookService);
            return true;
        }

    }

    /**
     * @param id the id of object
     * @param bookService the object to release
     * @return whether it is released
     */
    public boolean releaseBook(String id, BookService bookService) {

        if ((bookService.equals(RESERVED_DATA.get(id)))) {
            RESERVED_DATA.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
