/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controllerfactoryimpl.ControllerFactoryImpl;
import com.ijse.dl.client.observerimpl.SubjectObserverImpl;
import com.ijse.dl.common.service.SubjectService;
import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.SubjectObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Randula
 */
public class AllSubjectsPanel extends javax.swing.JPanel {

    private Icon icon = new ImageIcon(getClass().getResource(
            "/com/ijse/dl/client/view/images/block.png"));
    public static SubjectObserver subjectObserver;

    /**
     * Creates new form AllSubjectsPanel
     */
    public AllSubjectsPanel() {
        try {
            initComponents();
            getAllSubjects();
            new ControllerFactoryImpl().getSubjectController()
                    .addSubjectObserver(subjectObserver);
            subjectObserver = new SubjectObserverImpl(this);

        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
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

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setOpaque(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Subjects We Support...");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Scode", "Subject", "Description"
            }
        ));
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.setRowMargin(5);
        jScrollPane1.setViewportView(table);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        try {
            new ControllerFactoryImpl().getSubjectController()
                    .removeSubjectObserver(subjectObserver);
        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
  
    /**
     * Views all Subjects in table
     */
    private void getAllSubjects() {
        try {
            SubjectService subjectController = ServerConnector.
                    getServerConnector().getSubjectService();

            ArrayList<Subject> allSubjects = subjectController.getAll();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);

            for (Subject subject : allSubjects) {
                Object[] rows = {subject.getSubjectId(),
                    subject.getSubjectName(), subject.getDescription()};
                dtm.addRow(rows);
            }

            setTableSoter();
        } catch (NotBoundException | MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    private void setTableSoter() {
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys
                = new ArrayList<>(table.getRowCount());

        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }

    public void setNewSubjectList(List<Subject> subjectList) {
        ArrayList<Subject> allSubjects = (ArrayList<Subject>) subjectList;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);

        for (Subject subject : allSubjects) {
            Object[] rows = {subject.getSubjectId(),
                subject.getSubjectName(), subject.getDescription()};
            dtm.addRow(rows);
        }

        setTableSoter();
    }
}