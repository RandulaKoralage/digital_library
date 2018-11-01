/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import com.ijse.dl.client.controller.BackUpController;
import com.ijse.dl.client.controllerfactory.ControllerFactory;
import com.ijse.dl.client.controllerfactoryimpl.ControllerFactoryImpl;
import com.ijse.dl.common.dto.Book;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randula
 */
public class AdminHomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminHomeFrame
     */
    private Icon icon = new ImageIcon(getClass().getResource(
            "/com/ijse/dl/client/view/images/block.png"));

    private String id;
    private int posX;
    private int posY;

    public AdminHomeFrame(String id) {
        initComponents();
        this.id = id;
        getTime();
        getDate();
        setFullScreen();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        lblView = new javax.swing.JLabel();
        lblSettings = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();
        lblLookUp = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        lblDbBackUp = new javax.swing.JLabel();
        lblDbBackUpTitle = new javax.swing.JLabel();
        lblReportTitle = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        lblRestoreTitle = new javax.swing.JLabel();
        lblRestore = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/minimize.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 40, 50));

        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/close2.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 40, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 10));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MAZE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Adminstrator");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 120, 20));

        lblAccount.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAccount.setText("Account");
        lblAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAccountMouseExited(evt);
            }
        });
        getContentPane().add(lblAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 70, 30));

        lblView.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblView.setForeground(new java.awt.Color(255, 255, 255));
        lblView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblView.setText("View");
        lblView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewMouseExited(evt);
            }
        });
        getContentPane().add(lblView, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 70, 30));

        lblSettings.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblSettings.setForeground(new java.awt.Color(255, 255, 255));
        lblSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSettings.setText("Settings");
        lblSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSettingsMouseExited(evt);
            }
        });
        getContentPane().add(lblSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 70, 30));

        lblLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/logOut.png"))); // NOI18N
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 50, 40, 50));

        lblLookUp.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblLookUp.setForeground(new java.awt.Color(255, 255, 255));
        lblLookUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLookUp.setText("Look Up");
        lblLookUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLookUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLookUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLookUpMouseExited(evt);
            }
        });
        getContentPane().add(lblLookUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 70, 30));

        panel.setOpaque(false);
        panel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                panelComponentRemoved(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/logoNew.png"))); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1120, 510));

        lblReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/report.png"))); // NOI18N
        lblReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportMouseClicked(evt);
            }
        });
        getContentPane().add(lblReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 30, 30));

        lblDbBackUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDbBackUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/backup.png"))); // NOI18N
        lblDbBackUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDbBackUpMouseClicked(evt);
            }
        });
        getContentPane().add(lblDbBackUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 30, 30));

        lblDbBackUpTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblDbBackUpTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDbBackUpTitle.setText("Database Backup");
        getContentPane().add(lblDbBackUpTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 90, -1));

        lblReportTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblReportTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportTitle.setText("Daily Report");
        getContentPane().add(lblReportTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 70, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("Date");
        getContentPane().add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, -1));

        lblClock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 255, 255));
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClock.setText("Time");
        getContentPane().add(lblClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, 20));

        lblRestoreTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblRestoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestoreTitle.setText("Database Restore");
        getContentPane().add(lblRestoreTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, 90, -1));

        lblRestore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/restore.png"))); // NOI18N
        lblRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestoreMouseClicked(evt);
            }
        });
        getContentPane().add(lblRestore, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 50, 40));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/NewAdminBack.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMouseEntered
        underlineLabelText(lblView);
    }//GEN-LAST:event_lblViewMouseEntered

    private void lblSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSettingsMouseEntered
        underlineLabelText(lblSettings);
    }//GEN-LAST:event_lblSettingsMouseEntered

    private void lblLookUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLookUpMouseEntered
        underlineLabelText(lblLookUp);
    }//GEN-LAST:event_lblLookUpMouseEntered

    private void lblAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountMouseEntered
        underlineLabelText(lblAccount);
    }//GEN-LAST:event_lblAccountMouseEntered

    private void lblViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMouseExited
        removeUnderlineLabelText(lblView);
    }//GEN-LAST:event_lblViewMouseExited

    private void lblSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSettingsMouseExited
        removeUnderlineLabelText(lblSettings);
    }//GEN-LAST:event_lblSettingsMouseExited

    private void lblLookUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLookUpMouseExited
        removeUnderlineLabelText(lblLookUp);
    }//GEN-LAST:event_lblLookUpMouseExited

    private void lblAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountMouseExited
        removeUnderlineLabelText(lblAccount);
    }//GEN-LAST:event_lblAccountMouseExited

    private void lblViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMouseClicked
        setViewPanel();
    }//GEN-LAST:event_lblViewMouseClicked

    private void lblSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSettingsMouseClicked
        setSettingsPanel();
    }//GEN-LAST:event_lblSettingsMouseClicked

    private void lblLookUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLookUpMouseClicked
        setLookUpPanel();
    }//GEN-LAST:event_lblLookUpMouseClicked

    private void lblAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccountMouseClicked
        setAccountPanel();
    }//GEN-LAST:event_lblAccountMouseClicked

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void panelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panelComponentRemoved
        try {
            ControllerFactory controllerFactory = new ControllerFactoryImpl();

            controllerFactory.getSubjectController()
                    .releaseSubject(ManageSubjectPanel.lockId);
            controllerFactory.getBookController()
                    .releaseBook(ManageBooksPanel.lockId);

            controllerFactory.getSubjectController()
                    .removeSubjectObserver(ManageSubjectPanel.subjectObserver);
            controllerFactory.getSubjectController()
                    .removeSubjectObserver(AllSubjectsPanel.subjectObserver);
            controllerFactory.getBookController()
                    .removeBookObserver(ManageBooksPanel.bookObserver);

        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected",
                    "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_panelComponentRemoved

    private void lblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseClicked
        try {
            Date date = new Date();
            SimpleDateFormat simpledateformat
                    = (SimpleDateFormat) DateFormat
                    .getDateInstance(DateFormat.LONG);
            String curDate = simpledateformat.format(date);
            generateReport(curDate);
        } catch (JRException | IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected",
                    "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_lblReportMouseClicked

    private void lblDbBackUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDbBackUpMouseClicked
        try {
            String targetDirectory = getTargetDirectory();
            if (targetDirectory != null) {
                File file = new File(targetDirectory);
                BackUpController backUpController
                        = new ControllerFactoryImpl().getBackUpController();
                boolean isSaved = backUpController.setBackUp(file);
                isSaved = file.exists();
                if (isSaved) {
                    JOptionPane.showMessageDialog(this, "BackUp Success",
                            "Message", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Back Up Faild",
                            "Message", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } catch (IOException | NotBoundException ex) {
            Logger.getLogger(AdminHomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblDbBackUpMouseClicked

    private void lblRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseClicked
        try {
            String targetDirectory = openTargetDirectory();
            if (targetDirectory != null) {
                File file = new File(targetDirectory);
                BackUpController backUpController = new ControllerFactoryImpl().getBackUpController();
                boolean isSaved = backUpController.resetBackUp(file);
                if (isSaved) {
                    JOptionPane.showMessageDialog(this, "Restore Success",
                            "Message", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Restore Faild",
                            "Message", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } catch (IOException | NotBoundException ex) {
            Logger.getLogger(AdminHomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblRestoreMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDbBackUp;
    private javax.swing.JLabel lblDbBackUpTitle;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblLookUp;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblReportTitle;
    private javax.swing.JLabel lblRestore;
    private javax.swing.JLabel lblRestoreTitle;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblView;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    /**
     * Sets current date.
     */
    private void getDate() {
        Date date = new Date();
        SimpleDateFormat simpledateformat
                = (SimpleDateFormat) DateFormat.
                getDateInstance(DateFormat.LONG);
        String newDate = simpledateformat.format(date);
        lblDate.setText(newDate);
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
                            = new SimpleDateFormat("HH:mm:ss aa");
                    String currentTime = dateFormat.format(curDate);

                    lblClock.setText(currentTime);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(
                                AdminHomeFrame.this, "Database Error...");
                    }
                }
            }
        }).start();
    }

    private void setFullScreen() {

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
        label.setFont(new java.awt.Font("Verdana", 0, 16));
    }

    /**
     * Loads View Panel in to Frame
     */
    private void setViewPanel() {

        ViewPanel viewPanel = new ViewPanel();
        panel.removeAll();
        viewPanel.setSize(panel.getSize());
        Component add = panel.add(viewPanel);
        panel.repaint();
        panel.revalidate();

        lblView.setForeground(new java.awt.Color(102, 255, 204));
        lblSettings.setForeground(new java.awt.Color(225, 225, 225));
        lblLookUp.setForeground(new java.awt.Color(225, 225, 225));
        lblAccount.setForeground(new java.awt.Color(225, 225, 225));
    }

    /**
     * Loads Settings Panel in to Frame
     */
    private void setSettingsPanel() {

        SettingsPanel settingsPanel = new SettingsPanel();
        panel.removeAll();
        settingsPanel.setSize(panel.getSize());
        Component add = panel.add(settingsPanel);
        panel.repaint();
        panel.revalidate();

        lblSettings.setForeground(new java.awt.Color(102, 255, 204));
        lblView.setForeground(new java.awt.Color(225, 225, 225));
        lblLookUp.setForeground(new java.awt.Color(225, 225, 225));
        lblAccount.setForeground(new java.awt.Color(225, 225, 225));
    }

    /**
     * Loads LookUp Panel in to Frame
     */
    private void setLookUpPanel() {

        LookUpPanel lookUpPanel = new LookUpPanel();
        panel.removeAll();
        lookUpPanel.setSize(panel.getSize());
        Component add = panel.add(lookUpPanel);
        panel.repaint();
        panel.revalidate();

        lblLookUp.setForeground(new java.awt.Color(102, 255, 204));
        lblView.setForeground(new java.awt.Color(225, 225, 225));
        lblSettings.setForeground(new java.awt.Color(225, 225, 225));
        lblAccount.setForeground(new java.awt.Color(225, 225, 225));
    }

    /**
     * Loads Account Panel in to Frame
     */
    private void setAccountPanel() {

        AccountPanel accountPanel = new AccountPanel(id);
        panel.removeAll();
        accountPanel.setSize(panel.getSize());
        Component add = panel.add(accountPanel);
        panel.repaint();
        panel.revalidate();

        lblAccount.setForeground(new java.awt.Color(102, 255, 204));
        lblView.setForeground(new java.awt.Color(225, 225, 225));
        lblSettings.setForeground(new java.awt.Color(225, 225, 225));
        lblLookUp.setForeground(new java.awt.Color(225, 225, 225));
    }

    private void generateReport(String curDate)
            throws JRException, IOException,
            RemoteException, NotBoundException {

        ControllerFactory controllerFactory = new ControllerFactoryImpl();
        InputStream is
                = getClass().getResourceAsStream("/com/ijse/dl/client"
                        + "/report/DailyReport.jrxml");

        JasperReport jr = JasperCompileManager.compileReport(is);
        HashMap<String, Object> hm = new HashMap<>();

        int logInCount = controllerFactory.getReportController()
                .getLogInCount(curDate);
        int signUpCount = controllerFactory.getReportController()
                .getSignUpCount(curDate);
        int accessCount = controllerFactory.getReportController()
                .getAccessCount(curDate);
        int downloadCount = controllerFactory.getReportController()
                .getDownloadCount(curDate);

        hm.put("login", logInCount + "");
        hm.put("signup", signUpCount + "");
        hm.put("access", accessCount + "");
        hm.put("downloads", downloadCount + "");

        HashMap<String, Integer> subjectAccess
                = (HashMap<String, Integer>) controllerFactory
                .getReportController().subjectAccess(curDate);

       
        Set<String> keySet = subjectAccess.keySet();
       
        Object[] col = {"Subject", "amount"};
        DefaultTableModel dtm = new DefaultTableModel(col, 0);
        JTable newTable = new JTable(dtm);

        Object[] toArray = keySet.toArray();

        for (int i = 0; i < subjectAccess.size(); i++) {
            Book book = controllerFactory.getBookController()
                    .searchBook(toArray[i].toString());
            if (book != null) {

                String amount = Integer.toString(subjectAccess
                        .get(toArray[i].toString()));
                Object[] rows = {book.getName(), amount};
                dtm.addRow(rows);
            }
        }

        JasperPrint jp = JasperFillManager.fillReport(jr,
                hm, new JRTableModelDataSource(newTable.getModel()));

        JasperViewer.viewReport(jp, false);
    }

    /**
     * gets path of target directory to save backup in client PC
     *
     * @returns path to save file
     */
    private String getTargetDirectory() {
        String saveTo = null;
        JFileChooser jf = new JFileChooser();
        int returnVal = jf.showSaveDialog(this);
        if (jf.getSelectedFile() != null) {
            saveTo = jf.getSelectedFile().getPath();
        }
        return saveTo;
    }

    /**
     * gets path of source directory to restore as backup in server PC
     *
     * @returns path of database file
     */
    private String openTargetDirectory() {
        String toOpen = null;
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = jf.showOpenDialog(this);
        jf.setAcceptAllFileFilterUsed(false);
        if (jf.getSelectedFile() != null) {
            toOpen = jf.getSelectedFile().getPath();
            System.out.println(toOpen);
        }
        return toOpen;
    }
}