/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daofactoryimpl;

import com.ijse.dl.server.dao.AccessDAO;
import com.ijse.dl.server.dao.BookDAO;
import com.ijse.dl.server.dao.CommentDAO;
import com.ijse.dl.server.dao.DownloadDAO;
import com.ijse.dl.server.dao.LogDAO;
import com.ijse.dl.server.dao.MemberDAO;
import com.ijse.dl.server.dao.RequestDAO;
import com.ijse.dl.server.dao.SubjectDAO;
import com.ijse.dl.server.dao.UserDAO;
import com.ijse.dl.server.daofactory.DAOFactory;
import com.ijse.dl.server.daoimpl.AccessDAOImpl;
import com.ijse.dl.server.daoimpl.BookDAOImpl;
import com.ijse.dl.server.daoimpl.CommentDAOImpl;
import com.ijse.dl.server.daoimpl.DownloadDAOImpl;
import com.ijse.dl.server.daoimpl.LogDAOImpl;
import com.ijse.dl.server.daoimpl.MemberDAOImpl;
import com.ijse.dl.server.daoimpl.RequestDAOImpl;
import com.ijse.dl.server.daoimpl.SubjectDAOImpl;
import com.ijse.dl.server.daoimpl.UserDAOImpl;
import java.io.IOException;

/**
 *
 * @author Randula
 */
public class DAOFactoryImpl implements DAOFactory {

    @Override
    public SubjectDAO getSubjectDAO() throws IOException {
        return new SubjectDAOImpl();
    }

    @Override
    public BookDAO getBookDAO() throws IOException {
        return new BookDAOImpl();
    }

    @Override
    public RequestDAO getRequestDAO() throws IOException {
        return new RequestDAOImpl();
    }

    @Override
    public CommentDAO getCommentDAO() throws IOException {
        return new CommentDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() throws IOException {
        return new UserDAOImpl();
    }

    @Override
    public MemberDAO getMemberDAO() throws IOException {
        return new MemberDAOImpl();
    }

    @Override
    public LogDAO getLogDAO() throws IOException {
        return new LogDAOImpl();
    }

    @Override
    public AccessDAO getAccessDAO() throws IOException {
        return new AccessDAOImpl();
    }

    @Override
    public DownloadDAO getDownloadDAO() throws IOException {
        return new DownloadDAOImpl();
    }

}
