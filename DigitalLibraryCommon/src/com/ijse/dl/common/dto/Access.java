/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Randula
 */
public class Access implements Serializable, Comparable<Access> {

    private String id;
    private String userId;
    private String mCode;
    private String viewDate;
    private String viewedTime;

    public Access() {
    }

    public Access(String id, String userId, String mCode, String viewDate, String viewedTime) {
        this.id = id;
        this.userId = userId;
        this.mCode = mCode;
        this.viewDate = viewDate;
        this.viewedTime = viewedTime;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the mCode
     */
    public String getmCode() {
        return mCode;
    }

    /**
     * @param mCode the mCode to set
     */
    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    /**
     * @return the viewDate
     */
    public String getViewDate() {
        return viewDate;
    }

    /**
     * @param viewDate the viewDate to set
     */
    public void setViewDate(String viewDate) {
        this.viewDate = viewDate;
    }

    /**
     * @return the viewedTime
     */
    public String getViewedTime() {
        return viewedTime;
    }

    /**
     * @param viewedTime the viewedTime to set
     */
    public void setViewedTime(String viewedTime) {
        this.viewedTime = viewedTime;
    }

    @Override
    public String toString() {
        return "Access{" + "id=" + id + ", userId="
                + getUserId() + ", mCode=" + mCode + ", viewDate="
                + viewDate + ", viewedTime=" + viewedTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Access other = (Access) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Access o) {
        int curId = Integer.parseInt(this.getId());
        int newId = Integer.parseInt(o.getId());
        // suit is identical: compare number
        if (curId < newId) {
            return -1;
        } else if (curId > newId) {
            return 1;
        } else {
            return 0;
        }
    }

}
