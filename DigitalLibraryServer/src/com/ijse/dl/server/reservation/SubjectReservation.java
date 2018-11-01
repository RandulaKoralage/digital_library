/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.reservation;

import com.ijse.dl.common.service.SubjectService;
import java.util.HashMap;

/**
 *
 * @author Randula
 */
public class SubjectReservation {

    private final static HashMap<String, SubjectService> RESERVED_DATA
            = new HashMap<>();

    /**
     * @param id the id of object
     * @param subjectService the object to reserve
     * @return whether it is reserved
     */
    public boolean reserveSubject(String id,
            SubjectService subjectService) {

        if (RESERVED_DATA.containsKey(id)) {

            return (subjectService.equals(RESERVED_DATA.get(id)));
        } else {
            RESERVED_DATA.put(id, subjectService);
            return true;
        }

    }

    /**
     * @param id the id of object
     * @param subjectService the object to release
     * @return whether it is released
     */
    public boolean releaseSubject(String id,
            SubjectService subjectService) {
        if ((subjectService.equals(RESERVED_DATA.get(id)))) {

            RESERVED_DATA.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
