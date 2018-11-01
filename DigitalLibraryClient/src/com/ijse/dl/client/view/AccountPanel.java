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

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class AccountPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountPanel
     */
    private String id;
    private String password;
    private String tempOldPassword;
    private boolean isPanelVisible = false;
    private Icon icon = new ImageIcon(getClass().getResource(
            "/com/ijse/dl/client/view/images/block.png"));

    public AccountPanel(String id) {
        try {
            initComponents();
            panel.setVisible(false);
            Membership membership
                    = new ControllerFactoryImpl().getMemberController()
                    .searchMembership(id);
            User user = new ControllerFactoryImpl().getUserController()
                    .searchUser(id);
            setTextFields(user, membership);
            lblErrorMsg.setVisible(false);
            lblReset.setVisible(false);

        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected",
                    "Oops!",
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

        lblPrivateDetailTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNic = new javax.swing.JTextField();
        lblNic = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        txtDob = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelephone = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblAccountDetailTitle = new javax.swing.JLabel();
        lblUseId = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblRegDate = new javax.swing.JLabel();
        txtRegDate = new javax.swing.JTextField();
        seperator = new javax.swing.JSeparator();
        panel = new javax.swing.JPanel();
        pssNewPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        pssConfirmPassword = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        lblErrorMsg = new javax.swing.JLabel();
        lblReset = new javax.swing.JLabel();
        lblPasswordTitle = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblNewAdmin = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrivateDetailTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPrivateDetailTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblPrivateDetailTitle.setText("Private Details...");
        add(lblPrivateDetailTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 210, 30));

        lblName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Full Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 90, 30));

        txtName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 51, 204));
        txtName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 320, 30));

        txtNic.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNic.setForeground(new java.awt.Color(0, 51, 204));
        txtNic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        txtNic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicActionPerformed(evt);
            }
        });
        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });
        add(txtNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 320, 30));

        lblNic.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNic.setForeground(new java.awt.Color(255, 255, 255));
        lblNic.setText("NIC");
        add(lblNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 90, 30));

        lblDob.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblDob.setForeground(new java.awt.Color(255, 255, 255));
        lblDob.setText("DOB");
        add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 90, 30));

        txtDob.setEditable(false);
        txtDob.setBackground(java.awt.Color.white);
        txtDob.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtDob.setForeground(new java.awt.Color(0, 51, 204));
        txtDob.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 320, 30));

        txtGender.setEditable(false);
        txtGender.setBackground(java.awt.Color.white);
        txtGender.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGender.setForeground(new java.awt.Color(0, 51, 204));
        txtGender.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 320, 30));

        lblGender.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Gender");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 90, 30));

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 90, 30));

        lblTelephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTelephone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelephone.setText("Telephone");
        add(lblTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 90, 30));

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 51, 204));
        txtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 320, 30));

        txtTelephone.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(0, 51, 204));
        txtTelephone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        txtTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyTyped(evt);
            }
        });
        add(txtTelephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 320, 30));

        lblTitle.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Admin Account Settings...");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 26));

        lblAccountDetailTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAccountDetailTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblAccountDetailTitle.setText("Account Details...");
        add(lblAccountDetailTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 210, 30));

        lblUseId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUseId.setForeground(new java.awt.Color(255, 255, 255));
        lblUseId.setText("User ID");
        add(lblUseId, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 110, 30));

        txtUserId.setEditable(false);
        txtUserId.setBackground(java.awt.Color.white);
        txtUserId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtUserId.setForeground(new java.awt.Color(0, 51, 204));
        txtUserId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 270, 30));

        txtUserName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(0, 51, 204));
        txtUserName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 270, 30));

        lblUserName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("User Name");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 110, 30));

        lblRegDate.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblRegDate.setForeground(new java.awt.Color(255, 255, 255));
        lblRegDate.setText("Registered Date");
        add(lblRegDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 120, 30));

        txtRegDate.setEditable(false);
        txtRegDate.setBackground(java.awt.Color.white);
        txtRegDate.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtRegDate.setForeground(new java.awt.Color(0, 51, 204));
        txtRegDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtRegDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 270, 30));
        add(seperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 420, 12));

        panel.setOpaque(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pssNewPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pssNewPassword.setForeground(new java.awt.Color(0, 51, 204));
        pssNewPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
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
        panel.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 70, 60));

        pssConfirmPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pssConfirmPassword.setForeground(new java.awt.Color(0, 51, 204));
        pssConfirmPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
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

        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 430, 170));

        lblPasswordTitle.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPasswordTitle.setForeground(new java.awt.Color(255, 255, 255));
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
        add(lblPasswordTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 210, 30));

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
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 110, 90));

        lblNewAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/addAdmin.png"))); // NOI18N
        lblNewAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNewAdminMouseClicked(evt);
            }
        });
        add(lblNewAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 60, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        Validation.name(txtName);
    }//GEN-LAST:event_txtNameKeyReleased

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/accept2.png")));
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/accept1.png")));
    }//GEN-LAST:event_btnSubmitMouseExited

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

    private void lblResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseClicked
        password = tempOldPassword;
        lblReset.setVisible(false);
        lblErrorMsg.setVisible(false);
        pssNewPassword.setText(null);
        pssConfirmPassword.setText(null);
    }//GEN-LAST:event_lblResetMouseClicked

    private void lblResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseEntered
        underlineLabelText(lblReset);
    }//GEN-LAST:event_lblResetMouseEntered

    private void lblResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseExited
        removeUnderlineLabelText(lblReset);
    }//GEN-LAST:event_lblResetMouseExited

    private void lblPasswordTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordTitleMouseClicked
        if (isPanelVisible == false) {
            panel.setVisible(true);
            isPanelVisible = true;
        } else {
            panel.setVisible(false);
            isPanelVisible = false;
        }
    }//GEN-LAST:event_lblPasswordTitleMouseClicked

    private void lblPasswordTitleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordTitleMouseEntered
        lblPasswordTitle.setFont(new Font("Verdana", 1, 16));
    }//GEN-LAST:event_lblPasswordTitleMouseEntered

    private void lblPasswordTitleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordTitleMouseExited
        lblPasswordTitle.setFont(new Font("Verdana", 1, 14));
    }//GEN-LAST:event_lblPasswordTitleMouseExited

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/save2.png")));
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/save1.png")));
    }//GEN-LAST:event_btnSaveMouseExited

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
            JOptionPane.showMessageDialog(null, "Server Disconnected",
                    "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lblNewAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewAdminMouseClicked
        AdminSignUp adminSignUp = new AdminSignUp(null, true);
        adminSignUp.setVisible(true);
    }//GEN-LAST:event_lblNewAdminMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtNic.requestFocusInWindow();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtNicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicActionPerformed

    private void txtTelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelephoneKeyTyped

    private void txtTelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyReleased
        Validation.phoneNumber(txtNic, evt);
    }//GEN-LAST:event_txtTelephoneKeyReleased

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        Validation.textNIC(txtNic);
    }//GEN-LAST:event_txtNicKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblAccountDetailTitle;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorMsg;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewAdmin;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblPasswordTitle;
    private javax.swing.JLabel lblPrivateDetailTitle;
    private javax.swing.JLabel lblRegDate;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblTitle;
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
        String type = "Admin";

        User user = new User(id, name, nic, telephone, email, type);

        String userName = txtUserName.getText();
        String regDate = txtRegDate.getText();

        Membership membership = new Membership(id, userName,
                password, regDate, type);

        return new ControllerFactoryImpl().getMemberController()
                .modifyMember(membership, id, user);
    }
}