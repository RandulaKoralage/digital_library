/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.server.util;

/**
 *
 * @author Randula
 */
public class Encryption {

    /**
     * Class constructor.
     */
    public Encryption() {

    }

    /**
     * @param line the lime to encrypt
     * @return encrypted line
     */
    public String encrypt(String line) {
        StringBuilder str = new StringBuilder();

        char[] toCharArray = line.toCharArray();
        String newLine = "";
        for (char u : toCharArray) {
            char reverseBytes = Character.reverseBytes(u);
            newLine += reverseBytes;
        }

        byte[] bytes = line.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            str.append(String.format("%x", bytes[i]));
        }

        return str.toString();

    }

    /**
     * @param line the lime to de-encrypt
     * @return de-encrypted line
     */
    public String deEncrypt(String line) {
        if (line != null) {
            char[] toCharArray = line.toCharArray();
            String newLine = "";
            for (char u : toCharArray) {
                char reverseBytes = Character.reverseBytes(u);
                newLine += reverseBytes;
            }

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < line.length(); i += 2) {
                str.append((char) Integer.parseInt(line.substring(i, i + 2), 16));
            }

            return str.toString();
        } else {
            return null;
        }
    }
}
