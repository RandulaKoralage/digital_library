/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.TextArea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.DetectDriver;

/**
 *
 * @author Randula
 */
public class NotePadSof extends javax.swing.JFrame {

    private HTMLEditor editer;
    private Button btnSave;
    private JLabel lblTitle;    //Lable that shows title
    private JPanel panel; //Panel on JFarame
    private final JFXPanel fxPanel;

    /**
     * Creates NotePadSof
     */
    public NotePadSof() {
        initComponents();
        setSize(800, 600);
        setTitle("Maze Free Pad");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fxPanel = new JFXPanel();
        fxPanel.setSize(800, 600);

        panel.add("Center", fxPanel);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }

        });
    }

    /**
     * Initializes components in JFrame
     */
    private void initComponents() {

        panel = new JPanel();
        lblTitle = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.black);

        panel.setBackground(new java.awt.Color(51, 51, 51));
        panel.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36));
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("MAZE | FeePad");
        panel.add(lblTitle, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    /**
     * Initializes FX Scene
     */
    private void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        lblTitle.setVisible(false);
        fxPanel.setScene(scene);
    }

    /**
     * Creates FX Scene with HTML Editor
     *
     * @return the Scene with Component
     */
    private Scene createScene() {
        editer = new HTMLEditor();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(editer);

        borderPane.setStyle("-fx-background-color: Black");

        Image saveButtonImage = new Image(getClass().getResourceAsStream(
                "../notepadimages/Save.png"));
        btnSave = new Button();
        btnSave.setText("Save File");
        btnSave.setGraphic(new ImageView(saveButtonImage));
        btnSave.setStyle("-fx-background-color: Black");

        btnSave.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnSave.setStyle("-fx-background-color: Black");
            btnSave.setStyle("-fx-body-color: Black");
        });
        btnSave.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            btnSave.setStyle("-fx-background-color: Black");
        });
        btnSave.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            //  viewFileChooser();
            boolean isSaved = false;
            isSaved = saveInPen();
            if (isSaved) {
                JOptionPane.showMessageDialog(this,
                        "Saved in your pen drive...", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "We found an error with your pen drive...", "Message",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        borderPane.setBottom(btnSave);
        Scene scene = new Scene(borderPane, 600, 600);
        scene.setFill(Color.BLACK);

        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetY(5.0);
        dropshadow.setOffsetX(5.0);
        dropshadow.setColor(Color.WHITE);

        borderPane.setEffect(dropshadow);
        return scene;
    }

    /**
     * Views fileChooser and gets destination to save file as HTML
     */
    private void viewFileChooser() {
        final TextArea htmlText = new TextArea();

        String stringHtml = editer.getHtmlText();
        //String stripHTMLTags = stripHTMLTags(stringHtml);
        htmlText.setText(stringHtml);

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "HTML files (*.HTML)", "*.HTML");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(null);
        boolean isSaved = false;
        if (file != null) {
            isSaved = saveFile(stringHtml, file);
        }

    }

    /**
     * Saves text as HTML
     *
     * @param stringHtml the text obtain from editor
     * @param file the target destination to save
     */
    private boolean saveFile(String stringHtml, File file) {
        boolean isSaved = false;
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(stringHtml);
            isSaved = file.exists();
            fileWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return isSaved;
    }

    /**
     * Remove HTML tags in text
     *
     * @param htmlText the text obtain from editor
     * @return text without HTML tags
     */
    private String stripHTMLTags(String htmlText) {

        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(htmlText);
        final StringBuffer sb = new StringBuffer(htmlText.length());
        while (matcher.find()) {
            matcher.appendReplacement(sb, " ");
        }
        matcher.appendTail(sb);
        String line = sb.toString();
        return line;
    }

    private boolean saveInPen() {
        boolean isSaved = false;
        final TextArea htmlText = new TextArea();
        String stringHtml = editer.getHtmlText();
        String name
                = JOptionPane.showInputDialog(htmlText,
                        "What is this note about?", "Save Note",
                        JOptionPane.PLAIN_MESSAGE);

        if ((!name.isEmpty()) && (name != null)) {
            if (DetectDriver.detectedPorts.size() > 0) {
                String path = DetectDriver.detectedPorts.get(0);
                File file = new File(path + name + ".HTML");
                if (file != null) {
                    isSaved = saveFile(stringHtml, file);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Please Connect a Pen Drive...", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return isSaved;
    }
}
