/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.controllerfactoryimpl;

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
import com.ijse.dl.client.controllerfactory.ControllerFactory;
import com.ijse.dl.client.controllerimpl.AccessControllerImpl;
import com.ijse.dl.client.controllerimpl.BackUpControllerImpl;
import com.ijse.dl.client.controllerimpl.BookControllerImpl;
import com.ijse.dl.client.controllerimpl.CommentControllerImpl;
import com.ijse.dl.client.controllerimpl.DownloadControllerImpl;
import com.ijse.dl.client.controllerimpl.LogControllerImpl;
import com.ijse.dl.client.controllerimpl.MemberControllerImpl;
import com.ijse.dl.client.controllerimpl.ReportControllerImpl;
import com.ijse.dl.client.controllerimpl.RequestControllerImpl;
import com.ijse.dl.client.controllerimpl.SubjectControllerImpl;
import com.ijse.dl.client.controllerimpl.UserControllerImpl;
import java.rmi.RemoteException;

/**
 *
 * @author Randula
 */
public class ControllerFactoryImpl implements ControllerFactory {

    @Override
    public SubjectController getSubjectController() {
        return new SubjectControllerImpl();
    }

    @Override
    public BookController getBookController() {
        return new BookControllerImpl();
    }

    @Override
    public RequestController getRequestController() {
        return new RequestControllerImpl();
    }

    @Override
    public CommentController getCommentController() {
        return new CommentControllerImpl();
    }

    @Override
    public UserController getUserController() {
        return new UserControllerImpl();
    }

    @Override
    public MemberController getMemberController() {
        return new MemberControllerImpl();
    }

    @Override
    public LogController getLogController() {
        return new LogControllerImpl();
    }

    @Override
    public AccessController getAccessController() {
        return new AccessControllerImpl();
    }

    @Override
    public DownloadController getDownloadController() {
       return new DownloadControllerImpl();
    }

    @Override
    public ReportController getReportController(){
        return new ReportControllerImpl();
    }

    @Override
    public BackUpController getBackUpController()throws RemoteException  {
        return new BackUpControllerImpl();
    }

}
