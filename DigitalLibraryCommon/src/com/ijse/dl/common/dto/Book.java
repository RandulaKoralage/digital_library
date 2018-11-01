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
public class Book implements Serializable, Comparable<Book> {

    private String mCode;
    private String name;
    private String description;
    private String author;
    private byte[] image;
    private byte[] book;
    private String subject;
    private String type;
    private String language;
    private String downloadable;
    private String rating = "0";

    public Book() {
    }

    public Book(String mCode, String name, String description,
            String author, byte[] image, byte[] book,
            String subject, String type, String language, String downloadable, String rating) {
        this.mCode = mCode;
        this.name = name;
        this.description = description;
        this.author = author;
        this.image = image;
        this.book = book;
        this.subject = subject;
        this.type = type;
        this.language = language;
        this.downloadable = downloadable;
        this.rating = rating;
    }

    public Book(String mCode, String name, String description,
            String author, byte[] image,
            String subject, String type, String language, 
            String downloadable, String rating) {
        this.mCode = mCode;
        this.name = name;
        this.description = description;
        this.author = author;
        this.image = image;
        this.subject = subject;
        this.type = type;
        this.language = language;
        this.downloadable = downloadable;
        this.rating = rating;
    }

    public Book(String mCode, String name, String description, String author,
            String subject, String type, String language,
            String downloadable, String rating) {
        this.mCode = mCode;
        this.name = name;
        this.description = description;
        this.author = author;
        this.subject = subject;
        this.type = type;
        this.language = language;
        this.downloadable = downloadable;
        this.rating = rating;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return the video
     */
    public byte[] getBook() {
        return book;
    }

    /**
     * @param video the video to set
     */
    public void setBook(byte[] book) {
        this.book = book;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the downloadable
     */
    public String getDownloadable() {
        return downloadable;
    }

    /**
     * @param downloadable the downloadable to set
     */
    public void setDownloadable(String downloadable) {
        this.downloadable = downloadable;
    }

    @Override
    public String toString() {
        return "Material{" + "mCode=" + mCode + ", name=" + name + ","
                + " description=" + description + ", author=" + author + ","
                + " image=" + image + ", book=" + book + ", subject="
                + subject + ", type=" + type + ", language=" + language + ","
                + " downloadable=" + downloadable + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.mCode);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.mCode, other.mCode)) {
            return false;
        }
        return true;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Book o) {
        int curId = Integer.parseInt(this.getmCode());
        int newId = Integer.parseInt(o.getmCode());
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
