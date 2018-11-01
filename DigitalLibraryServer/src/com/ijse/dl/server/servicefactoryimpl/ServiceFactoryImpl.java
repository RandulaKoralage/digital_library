/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.servicefactoryimpl;

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
import com.ijse.dl.server.serviceimpl.AccessServiceImpl;
import com.ijse.dl.server.serviceimpl.BackUpServiceImpl;
import com.ijse.dl.server.serviceimpl.BookServiceImpl;
import com.ijse.dl.server.serviceimpl.CommentServiceImpl;
import com.ijse.dl.server.serviceimpl.DownloadServiceImpl;
import com.ijse.dl.server.serviceimpl.LogServiceImpl;
import com.ijse.dl.server.serviceimpl.MemberServiceImpl;
import com.ijse.dl.server.serviceimpl.ReportServiceImpl;
import com.ijse.dl.server.serviceimpl.RequestServiceImpl;
import com.ijse.dl.server.serviceimpl.SubjectServiceImpl;
import com.ijse.dl.server.serviceimpl.UserServiceImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Randula
 */
public class ServiceFactoryImpl extends
        UnicastRemoteObject implements ServiceFactory {

    public ServiceFactoryImpl() throws RemoteException {
    }

    /**
     *
     * @return SubjectServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public SubjectService getSubjectController()
            throws IOException, RemoteException {

        return new SubjectServiceImpl();
    }

    /**
     *
     * @return BookServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public BookService getBookService()
            throws IOException, RemoteException {

        return new BookServiceImpl();
    }

    /**
     *
     * @return RequestServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public RequestService getRequestService()
            throws IOException, RemoteException {

        return new RequestServiceImpl();
    }

    /**
     *
     * @return CommentServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public CommentService getCommentService()
            throws IOException, RemoteException {

        return new CommentServiceImpl();
    }

    /**
     *
     * @return UserServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public UserService getUserService()
            throws IOException, RemoteException {

        return new UserServiceImpl();
    }

    /**
     *
     * @return MemberServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public MemberService getMemberService()
            throws IOException, RemoteException {

        return new MemberServiceImpl();
    }

    /**
     *
     * @return LogServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public LogService getLogService()
            throws IOException, RemoteException {

        return new LogServiceImpl();
    }

    /**
     *
     * @return AccessServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public AccessService getAccessService()
            throws IOException, RemoteException {

        return new AccessServiceImpl();
    }

    /**
     *
     * @return DownloadServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public DownloadService getDownloadService()
            throws IOException, RemoteException {

        return new DownloadServiceImpl();
    }

    /**
     *
     * @return ReportServiceImpl
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public ReportService getReportService()
            throws IOException, RemoteException {

        return new ReportServiceImpl();
    }

    @Override
    public BackUpService getBackUpService()
            throws IOException, RemoteException {

        return new BackUpServiceImpl();
    }

}
