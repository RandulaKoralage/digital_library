/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import com.ijse.dl.client.connector.ServerConnector;
import com.ijse.dl.client.controller.BookController;
import com.ijse.dl.client.controllerfactoryimpl.ControllerFactoryImpl;
import com.ijse.dl.client.observerimpl.BookObserverImpl;
import com.ijse.dl.client.view.util.Pop;
import com.ijse.dl.client.view.util.Validation;
import com.ijse.dl.common.dto.Book;
import com.ijse.dl.common.dto.Subject;
import com.ijse.dl.common.observer.BookObserver;
import com.ijse.dl.common.service.SubjectService;
import com.ijse.dl.common.util.TransportableImage;
import com.ijse.dl.common.util.TransportableItem;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Randula
 */
public class ManageBooksPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageBooksPanel
     */
    private ArrayList<Book> bookList;
    public static BookObserver bookObserver;
    public static String lockId = "";
    private Icon icon = new ImageIcon(getClass().getResource(
            "/com/ijse/dl/client/view/images/block.png"));

    public ManageBooksPanel() {
        try {
            initComponents();
            this.bookList
                    = new ControllerFactoryImpl().getBookController().getAll();
            bookObserver = new BookObserverImpl(this);
            new ControllerFactoryImpl().getBookController()
                    .addBookObserver(bookObserver);
            setInList(bookList);
            getAllSubjects();
            repaint();
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
        lblName1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblDescription1 = new javax.swing.JLabel();
        lblCoverPath = new javax.swing.JLabel();
        lblLanguage = new javax.swing.JLabel();
        txtBookPath = new javax.swing.JTextField();
        lblMediaType = new javax.swing.JLabel();
        lblSubject = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        cmbSubject = new javax.swing.JComboBox();
        cmbLanguage = new javax.swing.JComboBox();
        lblAuthorT = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        txtCoverPath = new javax.swing.JTextField();
        lblAuthor3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        boxDownloadable = new javax.swing.JCheckBox();
        lblUploadBook = new javax.swing.JLabel();
        lblUploadCoverImage = new javax.swing.JLabel();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTitle = new javax.swing.JList();
        lblMCode = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setForeground(new java.awt.Color(0, 51, 204));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(697, 450));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Library Books...");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 224, 26));

        lblName1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblName1.setForeground(new java.awt.Color(255, 255, 255));
        lblName1.setText("Name");
        add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 90, 30));

        txtName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
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
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 330, 30));

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(0, 51, 204));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescription);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 330, 50));
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setOpaque(false);

        lblDescription1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDescription1.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription1.setText("Description");
        add(lblDescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 90, 35));

        lblCoverPath.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCoverPath.setForeground(new java.awt.Color(255, 255, 255));
        lblCoverPath.setText("File Path");
        add(lblCoverPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 90, 32));

        lblLanguage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblLanguage.setForeground(new java.awt.Color(255, 255, 255));
        lblLanguage.setText("Language");
        add(lblLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 90, 30));

        txtBookPath.setEditable(false);
        txtBookPath.setBackground(new java.awt.Color(204, 204, 255));
        txtBookPath.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtBookPath.setForeground(new java.awt.Color(0, 51, 204));
        txtBookPath.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtBookPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 300, 30));

        lblMediaType.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblMediaType.setForeground(new java.awt.Color(255, 255, 255));
        lblMediaType.setText("Media Type");
        add(lblMediaType, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 90, 30));

        lblSubject.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(255, 255, 255));
        lblSubject.setText("Subject");
        add(lblSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 90, 30));

        cmbType.setForeground(new java.awt.Color(0, 51, 204));
        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Audio", "Video", "PDF", "Image" }));
        cmbType.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });
        add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 330, 30));

        cmbSubject.setForeground(new java.awt.Color(0, 51, 204));
        cmbSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Information Technology", "English", "Database" }));
        cmbSubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        cmbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubjectActionPerformed(evt);
            }
        });
        add(cmbSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 330, 30));

        cmbLanguage.setForeground(new java.awt.Color(0, 51, 204));
        cmbLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sinhala", "English", "Tamil", "Hindi", "Chinees", "Arabian", "Korean", "French", "Other" }));
        cmbLanguage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        cmbLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLanguageActionPerformed(evt);
            }
        });
        add(cmbLanguage, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 330, 30));

        lblAuthorT.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAuthorT.setForeground(new java.awt.Color(255, 255, 255));
        lblAuthorT.setText("Author");
        add(lblAuthorT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 90, 30));

        txtAuthor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAuthor.setForeground(new java.awt.Color(0, 51, 204));
        txtAuthor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });
        txtAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAuthorKeyReleased(evt);
            }
        });
        add(txtAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 330, 30));

        txtCoverPath.setEditable(false);
        txtCoverPath.setBackground(new java.awt.Color(204, 204, 255));
        txtCoverPath.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCoverPath.setForeground(new java.awt.Color(0, 51, 204));
        txtCoverPath.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        add(txtCoverPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 300, 30));

        lblAuthor3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblAuthor3.setForeground(new java.awt.Color(255, 255, 255));
        lblAuthor3.setText("Cover Path");
        add(lblAuthor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 90, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/save1.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setContentAreaFilled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
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
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 110, 90));

        boxDownloadable.setForeground(new java.awt.Color(0, 51, 204));
        boxDownloadable.setText("Downloadable");
        boxDownloadable.setOpaque(false);
        add(boxDownloadable, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 140, -1));

        lblUploadBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/upload.png"))); // NOI18N
        lblUploadBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUploadBookMouseClicked(evt);
            }
        });
        add(lblUploadBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        lblUploadCoverImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/upload.png"))); // NOI18N
        lblUploadCoverImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUploadCoverImageMouseClicked(evt);
            }
        });
        lblUploadCoverImage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblUploadCoverImageKeyPressed(evt);
            }
        });
        add(lblUploadCoverImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, 30));

        jXTitledPanel1.setTitle("Book Titles");
        jXTitledPanel1.getContentContainer().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listTitle.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "English" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listTitleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listTitle);

        jXTitledPanel1.getContentContainer().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 300));

        add(jXTitledPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 340));

        lblMCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMCode.setText("1");
        add(lblMCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 50, 30));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/dl/client/view/images/delete1.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setContentAreaFilled(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 110, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        if (btnSave.isEnabled()) {
            btnSave.setIcon(new ImageIcon(getClass().getResource(
                    "/com/ijse/dl/client/view/images/save2.png")));
        }
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        if (btnSave.isEnabled()) {
            btnSave.setIcon(new ImageIcon(getClass().getResource(
                    "/com/ijse/dl/client/view/images/save1.png")));
        }
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (btnSave.isEnabled()) {

            try {
                String name = txtName.getText();
                String description = txtDescription.getText();
                String author = txtAuthor.getText();
                String coverPath = txtCoverPath.getText();
                String filePath = txtBookPath.getText();
                String subject = (String) cmbSubject.getSelectedItem();
                String type = (String) cmbType.getSelectedItem();
                String language = (String) cmbLanguage.getSelectedItem();
                String downloadable = null;

                if (boxDownloadable.isSelected()) {
                    downloadable = "Y";
                } else {
                    downloadable = "N";
                }

                BufferedImage image = createBufferedImage(coverPath);
                byte[] imageAsChar
                        = new TransportableImage().createByteArray(image);

                byte[] fileChar = null;

                if ("Image".equalsIgnoreCase(type)) {
                    BufferedImage imageBook = createBufferedImage(filePath);
                    fileChar
                            = new TransportableImage()
                            .createByteArray(imageBook);
                } else {
                    fileChar
                            = new TransportableItem().
                            createByteArray(new File(filePath));
                }

                Book book = new Book("0", name, description,
                        author, imageAsChar, fileChar,
                        subject, type, language, downloadable, "0");
                boolean isAdded
                        = new ControllerFactoryImpl().
                        getBookController().newBook(book);

                if (isAdded) {
                    JOptionPane.showMessageDialog(this,
                            "Successfully Saved...", "Message", 1);

                    txtName.setText(null);
                    txtDescription.setText(null);
                    txtAuthor.setText(null);
                    txtBookPath.setText(null);
                    txtCoverPath.setText(null);
                    cmbLanguage.setSelectedIndex(0);
                    cmbSubject.setSelectedIndex(0);
                    cmbType.setSelectedIndex(0);
                    boxDownloadable.setSelected(false);

                } else {
                    JOptionPane.showMessageDialog(this,
                            "Unable to Save...", "Message", 1);
                }
            } catch (IOException | NotBoundException ex) {
                JOptionPane.showMessageDialog(null, "Server Disconnected",
                        "Oops!",
                        JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void lblUploadBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUploadBookMouseClicked
        if (lblUploadBook.isEnabled()) {
            selectBook();
            String type = (String) cmbType.getSelectedItem();
            String bp = txtBookPath.getText();
            if (bp.endsWith(".jpg")) {
                cmbType.setSelectedIndex(3);
            } else if (bp.endsWith(".mp3")) {
                cmbType.setSelectedIndex(0);
            } else if (bp.endsWith(".mp4")) {
                cmbType.setSelectedIndex(1);
            } else if (bp.endsWith(".pdf")) {
                cmbType.setSelectedIndex(2);
            }
        }

    }//GEN-LAST:event_lblUploadBookMouseClicked

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        cmbLanguage.requestFocusInWindow();
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void lblUploadCoverImageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblUploadCoverImageKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblUploadCoverImageKeyPressed

    private void lblUploadCoverImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUploadCoverImageMouseClicked
        if (lblUploadCoverImage.isEnabled()) {
            selectImage();
            String cp = txtCoverPath.getText();
            if (!(cp.endsWith(".jpg") || cp.endsWith(".JPG")
                    || cp.endsWith(".JPEG"))) {
                JOptionPane.showMessageDialog(this,
                        "Please Upload .JPG Image ...",
                        "Message", JOptionPane.WARNING_MESSAGE);
                txtCoverPath.setText(null);
            }
        }
    }//GEN-LAST:event_lblUploadCoverImageMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtDescription.requestFocusInWindow();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAuthor.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        cmbSubject.requestFocusInWindow();
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void cmbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubjectActionPerformed
        cmbType.requestFocusInWindow();
    }//GEN-LAST:event_cmbSubjectActionPerformed

    private void cmbLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLanguageActionPerformed

    private void listTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTitleMouseClicked
        btnSave.setEnabled(false);
        try {
            fillTextFields();
        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_listTitleMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        btnDelete.setIcon(new ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/delete2.png")));
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        btnDelete.setIcon(new ImageIcon(getClass().getResource(
                "/com/ijse/dl/client/view/images/delete1.png")));
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!btnSave.isEnabled()) {
            try {
                String mCode = lblMCode.getText();
                boolean isDeleted = deleteBook(mCode);
                if (isDeleted) {
                    JOptionPane.showMessageDialog(this,
                            "Book Deleted...", "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    txtName.setText(null);
                    txtDescription.setText(null);
                    txtAuthor.setText(null);
                    txtBookPath.setText(null);
                    txtCoverPath.setText(null);
                    cmbLanguage.setSelectedIndex(0);
                    cmbSubject.setSelectedIndex(0);
                    cmbType.setSelectedIndex(0);
                    boxDownloadable.setSelected(false);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Unable to delete...", "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException | NotBoundException ex) {
                JOptionPane.showMessageDialog(null, "Server Disconnected",
                        "Oops!",
                        JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        Validation.removeSemiColen(txtName, evt);
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtAuthorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAuthorKeyReleased
        Validation.name(txtAuthor);
    }//GEN-LAST:event_txtAuthorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxDownloadable;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbLanguage;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JLabel lblAuthor3;
    private javax.swing.JLabel lblAuthorT;
    private javax.swing.JLabel lblCoverPath;
    private javax.swing.JLabel lblDescription1;
    private javax.swing.JLabel lblLanguage;
    private javax.swing.JLabel lblMCode;
    private javax.swing.JLabel lblMediaType;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUploadBook;
    private javax.swing.JLabel lblUploadCoverImage;
    private javax.swing.JList listTitle;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookPath;
    private javax.swing.JTextField txtCoverPath;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    /**
     * Fills List from subject names
     */
    private void getAllSubjects() {
        try {
            SubjectService subjectController = ServerConnector.
                    getServerConnector().getSubjectService();
            ArrayList<Subject> allSubject = subjectController.getAll();
            ArrayList<String> nameList = new ArrayList<>();

            cmbSubject.removeAllItems();
            for (Subject subject : allSubject) {
                nameList.add(subject.getSubjectName());
            }
            Collections.sort(nameList);
            for (String names : nameList) {
                cmbSubject.addItem(names);
            }
        } catch (IOException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "Server Disconnected", "Oops!",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }

    }

    private void selectImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        File file = fileChooser.getSelectedFile();

        if (file != null) {
            if (!file.getName().isEmpty()) {
                String str;

                if (txtCoverPath.getText().length() > 30) {
                    String t = file.getPath();
                    str = t.substring(0, 20) + " [...] "
                            + t.substring(t.length() - 20, t.length());
                } else {
                    str = file.getPath();
                }
                txtCoverPath.setText(str);
            }
        }
    }

    private void selectBook() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        File file = fileChooser.getSelectedFile();

        if (file != null) {
            if (!file.getName().isEmpty()) {
                String str;

                if (txtBookPath.getText().length() > 30) {
                    String t = file.getPath();
                    str = t.substring(0, 20) + " [...] "
                            + t.substring(t.length() - 20, t.length());
                } else {
                    str = file.getPath();
                }
                txtBookPath.setText(str);
            }
        }
    }

    private BufferedImage createBufferedImage(String path) {
        int width = 240;
        int height = 320;
        BufferedImage image = null;
        File f = null;
        try {

            f = new File(path);
            image = new BufferedImage(
                    width, height, BufferedImage.TYPE_INT_ARGB);

            image = ImageIO.read(f);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return image;
    }

    private void setInList(ArrayList<Book> bookList) {
        ArrayList<String> nameList = new ArrayList<>();

        listTitle.removeAll();
        for (Book book : bookList) {
            nameList.add(book.getName());
        }
        listTitle.setListData(nameList.toArray());
    }

    private void fillTextFields()
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {

        BookController bookController
                = new ControllerFactoryImpl().getBookController();
        String name = (String) listTitle.getSelectedValue();
        String mCode = null;

        for (Book book : bookList) {
            if (book.getName().equals(name)) {
                mCode = book.getmCode();
                break;
            }
        }
        Book book = bookController.searchBook(mCode);
        if (lockId != mCode) {
            boolean releaseSubject = bookController.releaseBook(lockId);
            System.out.println(lockId + " : isRelesed : " + releaseSubject);
            lockId = mCode;
        }
        lockId = mCode;
        if (book != null) {
            if (bookController.reserveBook(mCode)) {
                lblMCode.setText(book.getmCode());
                txtName.setText(book.getName());
                txtDescription.setText(book.getDescription());
                txtAuthor.setText(book.getAuthor());
                cmbSubject.setSelectedItem(book.getSubject());
                cmbType.setSelectedItem(book.getType());
                cmbLanguage.setSelectedItem(book.getLanguage());
                String download = null;
                lblUploadBook.setEnabled(false);
                lblUploadCoverImage.setEnabled(false);
                if (book.getDownloadable().equalsIgnoreCase("N")) {
                    boxDownloadable.setSelected(false);
                } else {
                    boxDownloadable.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, mCode
                        + " is Currently in Process");
            }
        }
    }

    private boolean deleteBook(String mCode)
            throws IOException, RemoteException,
            MalformedURLException, NotBoundException {
        boolean isDeleted = new ControllerFactoryImpl()
                .getBookController().deleteBook(mCode);
        return isDeleted;
    }

    public void setMessage(String message) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Pop p = new Pop(message);
                    Thread.sleep(5000);
                    p.dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        ;
    }

    .start();
    }

    public void updateBookList(List<Book> list) {
        ArrayList<String> nameList = new ArrayList<>();
        bookList = (ArrayList<Book>) list;
        listTitle.removeAll();
        for (Book book : list) {
            nameList.add(book.getName());
        }
        listTitle.setListData(nameList.toArray());
    }
}