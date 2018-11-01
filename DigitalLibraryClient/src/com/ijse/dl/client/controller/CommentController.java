/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controller;

import com.ijse.dl.common.dto.Comment;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface CommentController {

    public boolean saveComment(Comment comment)
            throws IOException, RemoteException, NotBoundException;

    public ArrayList<Comment> getCommentOnBook(String mCode)
            throws IOException, RemoteException, NotBoundException;

}
