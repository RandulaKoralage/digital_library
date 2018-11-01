/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.connector;

import com.ijse.dl.common.service.AccessService;
import com.ijse.dl.common.service.BackUpService;
import com.ijse.dl.common.service.BookService;
import com.ijse.dl.common.service.CommentService;
import com.ijse.dl.common.service.DownloadService;
import com.ijse.dl.common.service.LogService;
import com.ijse.dl.common.service.MemberService;
import com.ijse.dl.common.service.ReportService;
import com.ijse.dl.common.service.RequestService;
import com.ijse.dl.common.service.SubjectService;
import com.ijse.dl.common.service.UserService;
import com.ijse.dl.common.servicefactory.ServiceFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public class ServerConnector {

    private static ServerConnector serverConnector;
    private ServiceFactory serviceFactory;
    private SubjectService subjectService;
    private BookService bookService;
    private RequestService requestService;
    private CommentService commentService;
    private UserService userService;
    private MemberService memberService;
    private LogService logService;
    private AccessService accessService;
    private DownloadService downloadService;
    private ReportService reportService;
    private BackUpService backUpService;
    private ServerConnector() throws NotBoundException,
            MalformedURLException, RemoteException {

        serviceFactory 
                = (ServiceFactory) Naming.lookup("rmi://localhost:5050/server");
    }

    public static ServerConnector getServerConnector() throws NotBoundException,
            MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }

    public SubjectService getSubjectService()
            throws RemoteException, IOException {
        if (subjectService == null) {
            subjectService = serviceFactory.getSubjectController();
        }
        return subjectService;
    }

    public BookService getBookService()
            throws RemoteException, IOException {
        if (bookService == null) {
            bookService = serviceFactory.getBookService();
        }
        return bookService;
    }

    public RequestService getRequestService()
            throws RemoteException, IOException {
        if (requestService == null) {
            requestService = serviceFactory.getRequestService();
        }
        return requestService;
    }

    public CommentService getCommentService()
            throws RemoteException, IOException {
        if (commentService == null) {
            commentService = serviceFactory.getCommentService();
        }
        return commentService;
    }

    public UserService getUserService()
            throws RemoteException, IOException {
        if (userService == null) {
            userService = serviceFactory.getUserService();
        }
        return userService;
    }

    public MemberService getMemberService()
            throws RemoteException, IOException {
        if (memberService == null) {
            memberService = serviceFactory.getMemberService();
        }
        return memberService;
    }

    public LogService getLogService()
            throws RemoteException, IOException {
        if (logService == null) {
            logService = serviceFactory.getLogService();
        }
        return logService;
    }

    public AccessService getAccessService()
            throws RemoteException, IOException {
        if (accessService == null) {
            accessService = serviceFactory.getAccessService();
        }
        return accessService;
    }
    public DownloadService getDownloadService()
            throws RemoteException, IOException {
        if (downloadService == null) {
            downloadService = serviceFactory.getDownloadService();
        }
        return downloadService;
    }
    
    public ReportService getReportService()
            throws RemoteException, IOException {
        if (reportService == null) {
            reportService = serviceFactory.getReportService();
        }
        return reportService;
    }
     public BackUpService getBackUpService()
            throws RemoteException, IOException {
        if (backUpService == null) {
            backUpService = serviceFactory.getBackUpService();
        }
        return backUpService;
    }
}
