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
public class Comment implements Serializable, Comparable<Comment> {

    private String cid;
    private String mCode;
    private String sender;
    private String date;
    private String content;

    public Comment() {
    }

    public Comment(String cid, String mCode, String sender, String date, String content) {
        this.cid = cid;
        this.mCode = mCode;
        this.sender = sender;
        this.date = date;
        this.content = content;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
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
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" + "cid=" + cid + ", mCode=" + mCode + ", "
                + "date=" + date + ", content=" + content + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cid);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.cid, other.cid)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Comment o) {
        int curId = Integer.parseInt(this.getCid());
        int newId = Integer.parseInt(o.getCid());
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
