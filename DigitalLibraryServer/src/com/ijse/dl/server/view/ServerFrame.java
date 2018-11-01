/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.view;

import com.ijse.dl.common.servicefactory.ServiceFactory;
import com.ijse.dl.server.servicefactoryimpl.ServiceFactoryImpl;
import java.awt.Frame;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class ServerFrame extends javax.swing.JFrame {

    private boolean isConnected = false;    //Keep server status
    private Registry serverRegistry = null; //Remote registry
    private ServiceFactory serviceFactory; //Factory reference 

    /**
     * Creates new form ServerFrame
     */
    public ServerFrame() {
        initComponents();
        setConnectionStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblConnection = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblConnect = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConnection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/server/view/images/disconnected.png"))); // NOI18N
        getContentPane().add(lblConnection, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 210, 210));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/server/view/images/close2.png"))); // NOI18N
        lblClose.setText("jLabel2");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 20, 40));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MAZE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 50));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MAZE, The  Amazing Collection of Digital Books");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 360, 20));

        lblState.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        lblState.setForeground(new java.awt.Color(255, 255, 255));
        lblState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblState.setText("START CONNECTION");
        getContentPane().add(lblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 410, 50));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Server");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 60, 20));

        lblConnect.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblConnect.setForeground(new java.awt.Color(255, 255, 255));
        lblConnect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConnect.setText("Connect");
        lblConnect.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        lblConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConnectMouseClicked(evt);
            }
        });
        getContentPane().add(lblConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 110, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/server/view/images/minimize.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/server/view/images/servers.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 800, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConnectMouseClicked
        if (isConnected == false) {
            establishConnection();
        } else {
            endConnection();
        }
        setConnectionStatus();

    }//GEN-LAST:event_lblConnectMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblConnect;
    private javax.swing.JLabel lblConnection;
    private javax.swing.JLabel lblState;
    // End of variables declaration//GEN-END:variables

    /**
     * Connect or Disconnect Server
     */
    private void setConnectionStatus() {
        if (isConnected == false) {
            lblConnection.setIcon(
                    new javax.swing.ImageIcon(getClass().getResource(
                                    "/com/ijse/dl/server/view/"
                                    + "images/disconnected.png")));

            lblState.setText("START CONNECTION");
            lblConnect.setText("Connect");
        } else {
            lblConnection.setIcon(
                    new javax.swing.ImageIcon(getClass().getResource(
                                    "/com/ijse/dl/server/view/images/"
                                    + "connected.png")));

            lblState.setText("END CONNECTION");
            lblConnect.setText("Disconnect");
        }
    }

    /**
     * Binds registry
     */
    private void establishConnection() {
        try {
            serverRegistry = LocateRegistry.createRegistry(5050);
            serviceFactory = (ServiceFactory) new ServiceFactoryImpl();
            serverRegistry.rebind("server", serviceFactory);
            isConnected = true;

        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Server already connected",
                    "oops", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Unbind registry
     */
    private void endConnection() {
        try {
            serverRegistry.unbind("server");
            isConnected = false;
            UnicastRemoteObject.unexportObject(serverRegistry, true);
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(this, "Server unable to disconnected",
                    "oops", JOptionPane.ERROR_MESSAGE);
        }
    }
}
