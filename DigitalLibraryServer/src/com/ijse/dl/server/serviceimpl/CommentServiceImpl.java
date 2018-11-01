/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.serviceimpl;

import com.ijse.dl.common.dto.Comment;
import com.ijse.dl.common.service.CommentService;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daofactoryimpl.DAOFactoryImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class CommentServiceImpl extends
        UnicastRemoteObject implements CommentService {

    private static final DAOFactory dAOFactory = new DAOFactoryImpl();

    public CommentServiceImpl() throws RemoteException, IOException {

    }

    @Override
    public boolean saveComment(Comment comment)
            throws IOException, RemoteException {

        if (dAOFactory.getCommentDAO().addComment(comment)) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Comment> getCommentOnBook(String mCode)
            throws IOException, RemoteException {

        return dAOFactory.getCommentDAO().viewCommentOnBook(mCode);
    }

}
