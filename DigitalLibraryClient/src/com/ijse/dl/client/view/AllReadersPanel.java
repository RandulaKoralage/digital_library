/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import com.ijse.dl.client.controllerfactoryimpl.ControllerFactoryImpl;
import com.ijse.dl.common.dto.Membership;
import com.ijse.dl.common.dto.User;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class AllReadersPanel extends javax.swing.JPanel {
    
    private Icon icon = new ImageIcon(getClass().getResource(
            "/com/ijse/dl/client/view/images/block.png"));

    /**
     * Creates new form AllReadersPanel
     */
    public AllReadersPanel() {
        try {
            initComponents();
            setTable();
        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
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

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblReport = new javax.swing.JLabel();
        lblReportTitle = new javax.swing.JLabel();

        setOpaque(false);

        lblTitle.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Readers Private Details...");

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Full Name", "NIC", "DOB", "Gender", "Telephone", "Email", "User Name", "Registered Date"
            }
        ));
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.setRowMargin(5);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(75);
            table.getColumnModel().getColumn(1).setPreferredWidth(75);
            table.getColumnModel().getColumn(1).setMaxWidth(75);
            table.getColumnModel().getColumn(3).setMinWidth(75);
            table.getColumnModel().getColumn(3).setPreferredWidth(75);
            table.getColumnModel().getColumn(3).setMaxWidth(75);
            table.getColumnModel().getColumn(5).setMinWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        lblReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/report.png"))); // NOI18N
        lblReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportMouseClicked(evt);
            }
        });

        lblReportTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblReportTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportTitle.setText("Print List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblReport))
                    .addComponent(lblReportTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(lblReport)
                .addGap(0, 0, 0)
                .addComponent(lblReportTitle)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseClicked
        try {
            geneteateReport();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_lblReportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblReportTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void setTable() throws IOException, NotBoundException {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        ArrayList<User> userList
                = new ControllerFactoryImpl().getUserController().getAllUsers();
        
        for (User user : userList) {
            
            if (user.getType().equals("User")) {                
                Membership membership
                        = new ControllerFactoryImpl().getMemberController()
                        .searchMembership(user.getId());
                Object[] rows
                        = {user.getName(), user.getNic(),
                            getDOB(user.getNic()), getGender(user.getNic()),
                            user.getTelephone(), user.getEmail(),
                            membership.getUserName(), membership.getRegDate()};
                dtm.addRow(rows);                
            }
            
        }
        
    }
    
    private String getGender(String nic) {
        String gender = null;
        if (nic.length() != 9) {
            
        } else {
            String year = nic.substring(0, 2);
            String days = nic.substring(2, 5);
            
            int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int day = Integer.parseInt(days);
            
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
        }
        return gender;
    }
    
    private String getDOB(String nic) {
        String gender = null;
        
        String year = nic.substring(0, 2);
        String days = nic.substring(2, 5);
        
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Integer.parseInt(days);
        
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
        return ((19 + year) + "-" + (i + 1) + "-" + day);
    }
    
    private void geneteateReport() throws JRException {
        InputStream is
                = getClass().getResourceAsStream("/com/ijse/dl/client"
                        + "/report/UserList.jrxml");
        
        JasperReport jr = JasperCompileManager.compileReport(is);
        JasperPrint jp = JasperFillManager.fillReport(jr,
                null, new JRTableModelDataSource(table.getModel()));
        
        JasperViewer.viewReport(jp, false);
    }
}