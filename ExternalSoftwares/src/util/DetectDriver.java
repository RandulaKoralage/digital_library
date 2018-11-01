/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class DetectDriver extends Thread {

    public static ArrayList<String> detectedPorts = new ArrayList<>();

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"};
            File[] drives = new File[letters.length];
            boolean[] isDrive = new boolean[letters.length];

            // init the file objects and the initial drive state
            for (int i = 0; i < letters.length; ++i) {
                drives[i] = new File(letters[i] + ":/");

                isDrive[i] = drives[i].canRead();
            }

            System.out.println("FindDrive: waiting for devices...");

            // loop indefinitely
            while (true) {
                // check each drive 
                for (int i = 0; i < letters.length; ++i) {
                    boolean pluggedIn = drives[i].canRead();

                    // if the state has changed output a message
                    if (pluggedIn != isDrive[i]) {
                        if (pluggedIn) {
                            detectedPorts.add(letters[i] + ":/");
                            System.out.println("Drive " + letters[i] + " has been plugged in");
                            showPopUp("Drive " + letters[i] + " has been plugged in");
                        } else {
                            detectedPorts.remove(letters[i] + ":/");
                            System.out.println("Drive " + letters[i] + " has been unplugged");
                            showPopUp("Drive " + letters[i] + " has been unplugged");
                        }

                        isDrive[i] = pluggedIn;
                    }
                }

                // wait before looping
            }

        }
    }

    private void showPopUp(String message) {
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

}
