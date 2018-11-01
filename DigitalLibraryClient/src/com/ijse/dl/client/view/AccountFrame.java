/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import com.ijse.dl.client.controllerfactoryimpl.ControllerFactoryImpl;
import com.ijse.dl.client.view.util.Validation;
import com.ijse.dl.common.dto.Membership;
import com.ijse.dl.common.dto.User;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class AccountFrame extends javax.swing.JFrame {

    /**
     * Creates new form AccountFrame
     */
    private boolean isPanelVisible = false;
    private HomeFrame homeFrame;
    private String id;
    private String password;
    private String tempOldPassword;
    private int posX;
    private int posY;
    private Icon icon = new ImageIcon(getClass().getResource(
            "/com/ijse/dl/client/view/images/block.png"));

    public AccountFrame() {
        initComponents();
        panel.setVisible(isPanelVisible);
        setFullScreen();
        getTime();
    }

    AccountFrame(HomeFrame homeFrame) {
        try {
            initComponents();
            setFullScreen();
            getTime();
            this.homeFrame = homeFrame;
            this.id = homeFrame.getId();
            panel.setVisible(isPanelVisible);

            Membership membership
                    = new ControllerFactoryImpl()
                    .getMemberController().searchMembership(id);
            User user = new ControllerFactoryImpl()
                    .getUserController().searchUser(id);

            setTextFields(user, membership);
            lblErrorMsg.setVisible(false);
            lblReset.setVisible(false);
        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(this, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        lblDob = new javax.swing.JLabel();
        txtDob = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblNic = new javax.swing.JLabel();
        txtNic = new javax.swing.JTextField();
        lblPrivateDetailTitle = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        lblPasswordTitle = new javax.swing.JLabel();
        lblUseId = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblAccountDetailTitle = new javax.swing.JLabel();
        seperator = new javax.swing.JSeparator();
        panel = new javax.swing.JPanel();
        pssNewPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        pssConfirmPassword = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblErrorMsg = new javax.swing.JLabel();
        lblReset = new javax.swing.JLabel();
        lblRegDate = new javax.swing.JLabel();
        txtRegDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblBackground1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/home1.png"))); // NOI18N
        btnHome.setText("Back");
        btnHome.setContentAreaFilled(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 110, 90));

        lblDob.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblDob.setForeground(new java.awt.Color(255, 255, 255));
        lblDob.setText("DOB");
        getContentPane().add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 90, 30));

        txtDob.setEditable(false);
        txtDob.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        getContentPane().add(txtDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 270, 30));

        lblGender.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Gender");
        getContentPane().add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 90, 30));

        txtGender.setEditable(false);
        txtGender.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        getContentPane().add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 270, 30));

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 90, 30));

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 270, 30));

        lblTelephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTelephone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelephone.setText("Telephone");
        getContentPane().add(lblTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 90, 30));

        txtTelephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTelephone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        getContentPane().add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 270, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/save1.png"))); // NOI18N
        btnSave.setText("Submit");
        btnSave.setContentAreaFilled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 110, 90));

        txtName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 270, 30));

        lblName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Full Name");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 90, 30));

        lblNic.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNic.setForeground(new java.awt.Color(255, 255, 255));
        lblNic.setText("NIC");
        getContentPane().add(lblNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 90, 30));

        txtNic.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        getContentPane().add(txtNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 270, 30));

        lblPrivateDetailTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPrivateDetailTitle.setText("Private Details...");
        getContentPane().add(lblPrivateDetailTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 210, 30));

        txtUserId.setEditable(false);
        txtUserId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtUserId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        getContentPane().add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 270, 30));

        lblPasswordTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPasswordTitle.setText("Change Password...");
        lblPasswordTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPasswordTitleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPasswordTitleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPasswordTitleMouseExited(evt);
            }
        });
        getContentPane().add(lblPasswordTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 210, 30));

        lblUseId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUseId.setForeground(new java.awt.Color(255, 255, 255));
        lblUseId.setText("User ID");
        getContentPane().add(lblUseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 250, 110, 30));

        txtUserName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 290, 270, 30));

        lblUserName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("User Name");
        getContentPane().add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 110, 30));

        lblAccountDetailTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAccountDetailTitle.setText("Account Details...");
        getContentPane().add(lblAccountDetailTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 210, 30));
        getContentPane().add(seperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 420, 12));

        panel.setOpaque(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pssNewPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pssNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pssNewPasswordKeyReleased(evt);
            }
        });
        panel.add(pssNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 270, 30));

        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/accept1.png"))); // NOI18N
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
        });
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        panel.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 70, 60));

        pssConfirmPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pssConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pssConfirmPasswordKeyReleased(evt);
            }
        });
        panel.add(pssConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 270, 30));

        lblNewPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblNewPassword.setText("New Password");
        panel.add(lblNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 30));

        lblConfirmPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmPassword.setText("Confirm Password");
        panel.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 30));

        lblErrorMsg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblErrorMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblErrorMsg.setText("Passwords do not match. Please re-enter your password...");
        panel.add(lblErrorMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 480, 30));

        lblReset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblReset.setForeground(new java.awt.Color(153, 204, 255));
        lblReset.setText("Reset password");
        lblReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResetMouseExited(evt);
            }
        });
        panel.add(lblReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 20));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 500, 170));

        lblRegDate.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblRegDate.setForeground(new java.awt.Color(255, 255, 255));
        lblRegDate.setText("Registered Date");
        getContentPane().add(lblRegDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 120, 30));

        txtRegDate.setEditable(false);
        txtRegDate.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtRegDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        getContentPane().add(txtRegDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, 270, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Account Manager");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/minimize.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 40, 50));

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/close2.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 40, 50));

        lblClock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 255, 255));
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClock.setText("Time");
        getContentPane().add(lblClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 70, 100, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1370, 10));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MAZE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        lblBackground1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBackground1.setForeground(new java.awt.Color(255, 255, 255));
        lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/back.jpg"))); // NOI18N
        lblBackground1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBackground1.setMaximumSize(new java.awt.Dimension(1368, 766));
        lblBackground1.setMinimumSize(new java.awt.Dimension(1368, 766));
        lblBackground1.setPreferredSize(new java.awt.Dimension(1368, 766));
        getContentPane().add(lblBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, -410, 1690, 1320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/home2.png")));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/home1.png")));
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        homeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/save2.png")));
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/save1.png")));
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/accept2.png")));
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/accept1.png")));
    }//GEN-LAST:event_btnSubmitMouseExited

    private void lblPasswordTitleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordTitleMouseEntered
        lblPasswordTitle.setFont(new Font("Verdana", 1, 16));
    }//GEN-LAST:event_lblPasswordTitleMouseEntered

    private void lblPasswordTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordTitleMouseClicked
        if (isPanelVisible == false) {
            panel.setVisible(true);
            isPanelVisible = true;
        } else {
            panel.setVisible(false);
            isPanelVisible = false;
        }
    }//GEN-LAST:event_lblPasswordTitleMouseClicked

    private void lblPasswordTitleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordTitleMouseExited
        lblPasswordTitle.setFont(new Font("Verdana", 1, 14));
    }//GEN-LAST:event_lblPasswordTitleMouseExited

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        Validation.name(txtName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            boolean isUpdated = updateDetails();

            if (isUpdated) {
                JOptionPane.showMessageDialog(this,
                        "Details Updated...", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Try Again...", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String password1 = String.valueOf(pssNewPassword.getPassword());
        String password2 = String.valueOf(pssConfirmPassword.getPassword());

        if (password1.equals(password2)) {
            if (this.tempOldPassword == null) {
                this.tempOldPassword = password;
            }
            this.password = password1;
            lblErrorMsg.setText("Password verfication successfull.."
                    + " This will be save as new Password ");
            lblErrorMsg.setVisible(true);
            lblReset.setVisible(true);
        } else {
            lblErrorMsg.setText("Passwords do not match. "
                    + "Please re-enter your password...");
            lblErrorMsg.setVisible(true);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void lblResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseEntered
        underlineLabelText(lblReset);
    }//GEN-LAST:event_lblResetMouseEntered

    private void lblResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseExited
        removeUnderlineLabelText(lblReset);
    }//GEN-LAST:event_lblResetMouseExited

    private void lblResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseClicked
        password = tempOldPassword;
        lblReset.setVisible(false);
        lblErrorMsg.setVisible(false);
        pssNewPassword.setText(null);
        pssConfirmPassword.setText(null);
    }//GEN-LAST:event_lblResetMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        homeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        Validation.removeSemiColen(txtEmail, evt);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
        Validation.removeSemiColen(txtUserName, evt);
    }//GEN-LAST:event_txtUserNameKeyReleased

    private void pssNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pssNewPasswordKeyReleased
        Validation.removeSemiColen(pssNewPassword, evt);
    }//GEN-LAST:event_pssNewPasswordKeyReleased

    private void pssConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pssConfirmPasswordKeyReleased
        Validation.removeSemiColen(pssConfirmPassword, evt);
    }//GEN-LAST:event_pssConfirmPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAccountDetailTitle;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorMsg;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblPasswordTitle;
    private javax.swing.JLabel lblPrivateDetailTitle;
    private javax.swing.JLabel lblRegDate;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblUseId;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField pssConfirmPassword;
    private javax.swing.JPasswordField pssNewPassword;
    private javax.swing.JSeparator seperator;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtRegDate;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
  /**
     * Underlines the text in label
     *
     * @param label the JLabel argument
     */
    private void underlineLabelText(JLabel label) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }

    /**
     * Removes underlines the text in label
     *
     * @param label the JLabel argument
     */
    private void removeUnderlineLabelText(JLabel label) {
        label.setFont(new java.awt.Font("Tahoma", 0, 12));
    }

    private void nicExtract(String nic) {

        if (nic.length() != 9) {
            JOptionPane.showMessageDialog(null, "Invalid NIC Number",
                    "Error!", 3);
        } else {
            String year = nic.substring(0, 2);
            String days = nic.substring(2, 5);

            int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int day = Integer.parseInt(days);

            String gender;
            if (day > 500) {
                gender = "Female";
                day = day - 500;
            } else {
                gender = "Male";
            }

            int i = 0;
            while (day > months[i]) {
                day = day - months[i];
                i++;
            }
            txtGender.setText(gender);
            txtDob.setText((19 + year) + "-" + (i + 1) + "-" + day);
        }
    }

    /**
     * sets account details in textFields
     *
     * @param user the user object
     * @param membership membership object
     */
    private void setTextFields(User user, Membership membership) {

        txtName.setText(user.getName());
        txtNic.setText(user.getNic());
        nicExtract(user.getNic());
        txtEmail.setText(user.getEmail());
        txtTelephone.setText(user.getTelephone());

        this.password = membership.getPassword();

        txtUserId.setText(user.getId());
        txtUserName.setText(membership.getUserName());
        txtRegDate.setText(membership.getRegDate());
    }

    private boolean updateDetails()
            throws IOException, RemoteException, NotBoundException {

        String id = txtUserId.getText();
        String name = txtName.getText();
        String nic = txtNic.getText();
        String telephone = txtTelephone.getText();
        String email = txtEmail.getText();
        String type = "User";

        User user = new User(id, name, nic, telephone, email, type);

        String userName = txtUserName.getText();
        String regDate = txtRegDate.getText();

        Membership membership = new Membership(id, userName,
                password, regDate, "User");

        return new ControllerFactoryImpl().getMemberController()
                .modifyMember(membership, id, user);
    }

    private void setFullScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);

        Component component = this;
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });

        component.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                Rectangle rectangle = getBounds();
                setBounds(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY,
                        rectangle.width, rectangle.height);
            }
        });
    }

    /**
     * Sets current time.
     */
    private void getTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date curDate = new Date();
                    SimpleDateFormat dateFormat
                            = new SimpleDateFormat("HH:mm aa");
                    String currentTime = dateFormat.format(curDate);

                    lblClock.setText(currentTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(
                                AccountFrame.this, "Database Error...");
                    }
                }
            }
        }).start();
    }
}