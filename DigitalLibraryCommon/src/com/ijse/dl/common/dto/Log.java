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
public class Log implements Serializable, Comparable<Log> {

    private String logId;
    private String userId;
    private String logInTime;
    private String logOutTime;
    private String curDate;
    private String ipAddress;

    public Log() {
    }

    public Log(String logId, String userId, String logInTime, String logOutTime,
            String curDate, String ipAddress) {

        this.logId = logId;
        this.userId = userId;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.curDate = curDate;
        this.ipAddress = ipAddress;
    }

    public Log(String userId, String logInTime,
            String curDate, String ipAddress) {

        this.userId = userId;
        this.logInTime = logInTime;
        this.curDate = curDate;
        this.ipAddress = ipAddress;
    }

    /**
     * @return the logId
     */
    public String getLogId() {
        return logId;
    }

    /**
     * @param logId the logId to set
     */
    public void setLogId(String logId) {
        this.logId = logId;
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
     * @return the logInTime
     */
    public String getLogInTime() {
        return logInTime;
    }

    /**
     * @param logInTime the logInTime to set
     */
    public void setLogInTime(String logInTime) {
        this.logInTime = logInTime;
    }

    /**
     * @return the logOutTime
     */
    public String getLogOutTime() {
        return logOutTime;
    }

    /**
     * @param logOutTime the logOutTime to set
     */
    public void setLogOutTime(String logOutTime) {
        this.logOutTime = logOutTime;
    }

    /**
     * @return the curDate
     */
    public String getCurDate() {
        return curDate;
    }

    /**
     * @param curDate the curDate to set
     */
    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Log{" + "logId=" + logId + ", userId="
                + userId + ", logInTime=" + logInTime + ", logOutTime="
                + logOutTime + ", curDate=" + curDate + ", ipAddress="
                + ipAddress + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.logId);
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
        final Log other = (Log) obj;
        if (!Objects.equals(this.logId, other.logId)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Log o) {
        int curId = Integer.parseInt(this.getLogId());
        int newId = Integer.parseInt(o.getLogId());
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
