/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view.util;

import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Randula
 */
public class StarRatings {

    public void setGold(JLabel label, URL path) {
        label.setIcon(new ImageIcon(path));
    }

    public int colorStars(ArrayList<JLabel> labelList, JLabel label, URL path) {
        int count = 0;
        if (label.equals(labelList.get(0))) {
            setGold(labelList.get(0), path);
            count = 1;
        } else if (label.equals(labelList.get(1))) {
            setGold(labelList.get(0), path);
            setGold(labelList.get(1), path);
            count = 2;
        } else if (label.equals(labelList.get(2))) {
            setGold(labelList.get(0), path);
            setGold(labelList.get(1), path);
            setGold(labelList.get(2), path);
            count = 3;
        } else if (label.equals(labelList.get(3))) {
            setGold(labelList.get(0), path);
            setGold(labelList.get(1), path);
            setGold(labelList.get(2), path);
            setGold(labelList.get(3), path);
            count = 4;
        } else if (label.equals(labelList.get(4))) {
            setGold(labelList.get(0), path);
            setGold(labelList.get(1), path);
            setGold(labelList.get(2), path);
            setGold(labelList.get(3), path);
            setGold(labelList.get(4), path);
            count = 5;
        }
        return count;
    }

    public String getFeedBack(int starCount) {
        String feedBack = null;
        switch (starCount) {
            case 1:
                feedBack = "Hated It";
                break;
            case 2:
                feedBack = "Disliked It";
                break;
            case 3:
                feedBack = "Ok on It";
                break;
            case 4:
                feedBack = "Liked It";
                break;
            case 5:
                feedBack = "Loved It";
                break;
            default:
                feedBack = "Ask Later";
        }
        return feedBack;
    }

    public void setAllStarsEmpty(ArrayList<JLabel> labelList, URL path) {

        for (JLabel label : labelList) {
            label.setIcon(
                    new ImageIcon(path));
        }
    }

    public void setStaticStars(
            ArrayList<JLabel> labelList, URL pathOfFullStar,
            URL pathOfHalfStar, double rate) {

        int fullCount = (int) Math.floor(rate);
        System.out.println(fullCount);
        System.out.println(labelList.size());

        for (int i = 0; i < fullCount; i++) {
            JLabel label = labelList.get(i);
            setGold(label, pathOfFullStar);
        }
        if (rate % 1 > 0) {
            setGold(labelList.get(fullCount), pathOfHalfStar);
        }

    }
}
