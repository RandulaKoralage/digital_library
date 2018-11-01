/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author Randula
 */
public class ViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPanel
     */
    public ViewPanel() {
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

        jSeparator1 = new javax.swing.JSeparator();
        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAllReaders = new javax.swing.JLabel();
        lblAllBooks = new javax.swing.JLabel();
        lblAllSubjects = new javax.swing.JLabel();
        lblReadersLogs = new javax.swing.JLabel();

        setOpaque(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

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
                .addGap(0, 148, Short.MAX_VALUE))
        );

        lblAllReaders.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblAllReaders.setForeground(new java.awt.Color(255, 255, 255));
        lblAllReaders.setText("All Readers");
        lblAllReaders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAllReadersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAllReadersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAllReadersMouseExited(evt);
            }
        });

        lblAllBooks.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblAllBooks.setForeground(new java.awt.Color(255, 255, 255));
        lblAllBooks.setText("All Books");
        lblAllBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAllBooksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAllBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAllBooksMouseExited(evt);
            }
        });

        lblAllSubjects.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblAllSubjects.setForeground(new java.awt.Color(255, 255, 255));
        lblAllSubjects.setText("All Subjects");
        lblAllSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAllSubjectsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAllSubjectsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAllSubjectsMouseExited(evt);
            }
        });

        lblReadersLogs.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lblReadersLogs.setForeground(new java.awt.Color(255, 255, 255));
        lblReadersLogs.setText("Readers' Logs");
        lblReadersLogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReadersLogsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReadersLogsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReadersLogsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAllBooks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAllReaders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAllSubjects, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReadersLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
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
                .addComponent(lblAllReaders, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAllBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAllSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblReadersLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAllReadersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllReadersMouseClicked
        setAllReadersPanel();
    }//GEN-LAST:event_lblAllReadersMouseClicked

    private void lblAllReadersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllReadersMouseEntered
        underlineLabelText(lblAllReaders);
    }//GEN-LAST:event_lblAllReadersMouseEntered

    private void lblAllReadersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllReadersMouseExited
        removeUnderlineLabelText(lblAllReaders);
    }//GEN-LAST:event_lblAllReadersMouseExited

    private void lblAllBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllBooksMouseEntered
        underlineLabelText(lblAllBooks);
    }//GEN-LAST:event_lblAllBooksMouseEntered

    private void lblAllBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllBooksMouseExited
        removeUnderlineLabelText(lblAllBooks);
    }//GEN-LAST:event_lblAllBooksMouseExited

    private void lblAllSubjectsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllSubjectsMouseEntered
        underlineLabelText(lblAllSubjects);
    }//GEN-LAST:event_lblAllSubjectsMouseEntered

    private void lblAllSubjectsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllSubjectsMouseExited
        removeUnderlineLabelText(lblAllSubjects);
    }//GEN-LAST:event_lblAllSubjectsMouseExited

    private void lblReadersLogsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadersLogsMouseEntered
        underlineLabelText(lblReadersLogs);
    }//GEN-LAST:event_lblReadersLogsMouseEntered

    private void lblReadersLogsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadersLogsMouseExited
        removeUnderlineLabelText(lblReadersLogs);
    }//GEN-LAST:event_lblReadersLogsMouseExited

    private void lblAllBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllBooksMouseClicked
       setAllBooksPanel();
    }//GEN-LAST:event_lblAllBooksMouseClicked

    private void lblAllSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAllSubjectsMouseClicked
       setAllSubjectPanel();
    }//GEN-LAST:event_lblAllSubjectsMouseClicked

    private void lblReadersLogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReadersLogsMouseClicked
        setReadersLogsPanelPanel();
    }//GEN-LAST:event_lblReadersLogsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAllBooks;
    private javax.swing.JLabel lblAllReaders;
    private javax.swing.JLabel lblAllSubjects;
    private javax.swing.JLabel lblReadersLogs;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
     private void underlineLabelText(JLabel label) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        label.setFont(font.deriveFont(attributes));
    }

    private void removeUnderlineLabelText(JLabel label) {
        label.setFont(new java.awt.Font("Verdana", 0, 16));
    }

    private void setAllReadersPanel() {
       AllReadersPanel allReadersPanel = new AllReadersPanel();
        sidePanel.removeAll();
        allReadersPanel.setSize(sidePanel.getSize());
        Component add = sidePanel.add(allReadersPanel);
        sidePanel.repaint();
        sidePanel.revalidate();
        
        lblAllReaders.setForeground(new java.awt.Color(102,255,204));
        lblAllBooks.setForeground(new java.awt.Color(225, 225, 225));
        lblAllSubjects.setForeground(new java.awt.Color(225, 225, 225));
        lblReadersLogs.setForeground(new java.awt.Color(225, 225, 225));
        
    }

    private void setAllBooksPanel() {
        AllBooksPanel allBooksPanel = new AllBooksPanel();
        sidePanel.removeAll();
        allBooksPanel.setSize(sidePanel.getSize());
        Component add = sidePanel.add(allBooksPanel);
        sidePanel.repaint();
        sidePanel.revalidate();
        
        lblAllBooks.setForeground(new java.awt.Color(102,255,204));
        lblAllReaders.setForeground(new java.awt.Color(225, 225, 225));
        lblAllSubjects.setForeground(new java.awt.Color(225, 225, 225));
        lblReadersLogs.setForeground(new java.awt.Color(225, 225, 225));
       
    }
    
    private void setAllSubjectPanel() {
       AllSubjectsPanel allSubjectsPanel = new AllSubjectsPanel();
        sidePanel.removeAll();
        allSubjectsPanel.setSize(sidePanel.getSize());
        Component add = sidePanel.add(allSubjectsPanel);
        sidePanel.repaint();
        sidePanel.revalidate();
        
        lblAllSubjects.setForeground(new java.awt.Color(102,255,204));
        lblAllBooks.setForeground(new java.awt.Color(225, 225, 225));
        lblAllReaders.setForeground(new java.awt.Color(225, 225, 225));
        lblReadersLogs.setForeground(new java.awt.Color(225, 225, 225));
       
    }
    private void setReadersLogsPanelPanel() {
       ReadersLogsPanel readersLogsPanel = new ReadersLogsPanel();
        sidePanel.removeAll();
        readersLogsPanel.setSize(sidePanel.getSize());
        Component add = sidePanel.add(readersLogsPanel);
        sidePanel.repaint();
        sidePanel.revalidate();
        
        lblReadersLogs.setForeground(new java.awt.Color(102,255,204));
        lblAllBooks.setForeground(new java.awt.Color(225, 225, 225));
        lblAllSubjects.setForeground(new java.awt.Color(225, 225, 225));
        lblAllReaders.setForeground(new java.awt.Color(225, 225, 225));
       
    }
}