/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.dao;

import com.ijse.dl.common.dto.Comment;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public interface CommentDAO {

    public boolean addComment(Comment comment)
            throws IOException, RemoteException;

    public ArrayList<Comment> viewCommentOnBook(String mCode)
            throws IOException, RemoteException;
}
