/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerfactory;

import com.ijse.dl.client.controller.AccessController;
import com.ijse.dl.client.controller.BackUpController;
import com.ijse.dl.client.controller.BookController;
import com.ijse.dl.client.controller.CommentController;
import com.ijse.dl.client.controller.DownloadController;
import com.ijse.dl.client.controller.LogController;
import com.ijse.dl.client.controller.MemberController;
import com.ijse.dl.client.controller.ReportController;
import com.ijse.dl.client.controller.RequestController;
import com.ijse.dl.client.controller.SubjectController;
import com.ijse.dl.client.controller.UserController;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public interface ControllerFactory {

    public SubjectController getSubjectController();

    public BookController getBookController();

    public RequestController getRequestController();

    public CommentController getCommentController();

    public UserController getUserController();

    public MemberController getMemberController();

    public LogController getLogController();

    public AccessController getAccessController();

    public DownloadController getDownloadController();

    public ReportController getReportController();
    
    public BackUpController getBackUpController()throws RemoteException ;
}
