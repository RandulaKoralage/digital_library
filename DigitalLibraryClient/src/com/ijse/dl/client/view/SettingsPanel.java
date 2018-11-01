/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author Randula
 */
public class SettingsPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingsPanel
     */
    public SettingsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblManageSubjects = new javax.swing.JLabel();
        lblManageBooks = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setOpaque(false);

        sidePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        sidePanel.setOpaque(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/logoNew.png"))); // NOI18N

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 139, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblManageSubjects.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblManageSubjects.setForeground(new java.awt.Color(255, 255, 255));
        lblManageSubjects.setText("Subjects");
        lblManageSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageSubjectsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManageSubjectsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManageSubjectsMouseExited(evt);
            }
        });

        lblManageBooks.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblManageBooks.setForeground(new java.awt.Color(255, 255, 255));
        lblManageBooks.setText("Books");
        lblManageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManageBooksMouseExited(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblManageBooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManageSubjects, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lblManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblManageSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblManageSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageSubjectsMouseClicked
        setManageSubjectPanel();
    }//GEN-LAST:event_lblManageSubjectsMouseClicked

    private void lblManageSubjectsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageSubjectsMouseEntered
        underlineLabelText(lblManageSubjects);
    }//GEN-LAST:event_lblManageSubjectsMouseEntered

    private void lblManageSubjectsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageSubjectsMouseExited
        removeUnderlineLabelText(lblManageSubjects);
    }//GEN-LAST:event_lblManageSubjectsMouseExited

    private void lblManageBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageBooksMouseClicked
        setManageBookPanel();
    }//GEN-LAST:event_lblManageBooksMouseClicked

    private void lblManageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageBooksMouseEntered
        underlineLabelText(lblManageBooks);
    }//GEN-LAST:event_lblManageBooksMouseEntered

    private void lblManageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageBooksMouseExited
        removeUnderlineLabelText(lblManageBooks);
    }//GEN-LAST:event_lblManageBooksMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblManageBooks;
    private javax.swing.JLabel lblManageSubjects;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
        private void underlineLabelText(JLabel label) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }

    private void removeUnderlineLabelText(JLabel label) {
        label.setFont(new Font("Verdana", 0, 16));
    }    
    
    private void setManageSubjectPanel() {
       ManageSubjectPanel manageSubjectPanel = new ManageSubjectPanel();
        sidePanel.removeAll();
        manageSubjectPanel.setSize(sidePanel.getSize());
        Component add = sidePanel.add(manageSubjectPanel);
        sidePanel.repaint();
        sidePanel.revalidate();
        
        lblManageSubjects.setForeground(new Color(102,255,204));
        lblManageBooks.setForeground(new Color(225, 225, 225));     
        
    }
     private void setManageBookPanel() {
       ManageBooksPanel manageBookPanel = new ManageBooksPanel();
        sidePanel.removeAll();
        manageBookPanel.setSize(sidePanel.getSize());
        Component add = sidePanel.add(manageBookPanel);
        sidePanel.repaint();
        sidePanel.revalidate();
        
        lblManageBooks.setForeground(new Color(102,255,204));
        lblManageSubjects.setForeground(new Color(225, 225, 225));     
        
    }
}