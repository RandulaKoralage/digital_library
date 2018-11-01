/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.daofactory;

import com.ijse.dl.server.dao.AccessDAO;
import com.ijse.dl.server.dao.BookDAO;
import com.ijse.dl.server.dao.CommentDAO;
import com.ijse.dl.server.dao.DownloadDAO;
import com.ijse.dl.server.dao.LogDAO;
import com.ijse.dl.server.dao.MemberDAO;
import com.ijse.dl.server.dao.RequestDAO;
import com.ijse.dl.server.dao.SubjectDAO;
import com.ijse.dl.server.dao.UserDAO;
import java.io.IOException;

/**
 *
 * @author Randula
 */
public interface DAOFactory {

    public SubjectDAO getSubjectDAO() throws IOException;

    public BookDAO getBookDAO() throws IOException;

    public RequestDAO getRequestDAO() throws IOException;

    public CommentDAO getCommentDAO() throws IOException;

    public UserDAO getUserDAO() throws IOException;

    public MemberDAO getMemberDAO() throws IOException;

    public LogDAO getLogDAO() throws IOException;

    public AccessDAO getAccessDAO() throws IOException;

    public DownloadDAO getDownloadDAO() throws IOException;
}
