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
public class Download implements Serializable, Comparable<Download> {

    private String id;
    private String userId;
    private String mCode;
    private String downloadDate;
    private String downloadTime;

    public Download() {
    }

    public Download(String id, String userId, String mCode,
            String downloadDate, String downloadTime) {

        this.id = id;
        this.userId = userId;
        this.mCode = mCode;
        this.downloadDate = downloadDate;
        this.downloadTime = downloadTime;
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
     * @return the downloadDate
     */
    public String getDownloadDate() {
        return downloadDate;
    }

    /**
     * @param downloadDate the downloadDate to set
     */
    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }

    /**
     * @return the downloadTime
     */
    public String getDownloadTime() {
        return downloadTime;
    }

    /**
     * @param downloadTime the downloadTime to set
     */
    public void setDownloadTime(String downloadTime) {
        this.downloadTime = downloadTime;
    }

    @Override
    public String toString() {
        return "Download{" + "id=" + id + ", userId="
                + userId + ", mCode=" + mCode + ", downloadDate="
                + downloadDate + ", downloadTime=" + downloadTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Download other = (Download) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Download o) {
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
