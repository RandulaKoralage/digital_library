/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Randula
 */
public class BookCatogoryChart extends JFrame {

    private PieChart chart = null;
    private ObservableList<PieChart.Data> pieChartData;
    private JFXPanel fxPanel;

    public BookCatogoryChart(ObservableList<PieChart.Data> pieChartData) {
       
        setTitle("Books According to Subjects");   
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        initAndShowGUI(pieChartData);
      
        setVisible(true);
    }

    public void initAndShowGUI(ObservableList<PieChart.Data> pieChartData) {

        this.pieChartData = pieChartData;
        //    frame = new JPanel();
        fxPanel = new JFXPanel();
        fxPanel.setSize(100, 100);
        this.add(fxPanel);

        Platform.runLater(() -> {
            initFX(fxPanel);
        });
    }

    private void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        Text text = new Text();
        chart = new PieChart(pieChartData);

        ((Group) scene.getRoot()).getChildren().add(chart);
        root.getChildren().add(text);

        return (scene);
    }

    public JFrame getChart() {
        return this;
    }
}
