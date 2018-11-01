/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.servicefactory;

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
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface ServiceFactory extends Remote {

    public SubjectService getSubjectController()
            throws IOException, RemoteException;

    public BookService getBookService()
            throws IOException, RemoteException;

    public RequestService getRequestService()
            throws IOException, RemoteException;

    public CommentService getCommentService()
            throws IOException, RemoteException;

    public UserService getUserService()
            throws IOException, RemoteException;

    public MemberService getMemberService()
            throws IOException, RemoteException;

    public LogService getLogService()
            throws IOException, RemoteException;

    public AccessService getAccessService()
            throws IOException, RemoteException;

    public DownloadService getDownloadService()
            throws IOException, RemoteException;
    
    public ReportService getReportService()
            throws IOException, RemoteException;
    
    public BackUpService getBackUpService()
            throws IOException, RemoteException;
}
