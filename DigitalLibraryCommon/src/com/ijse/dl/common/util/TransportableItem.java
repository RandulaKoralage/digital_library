/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Randula
 */
public class TransportableItem {

    public TransportableItem() {
    }

    /**
     * Converts input file to bytes
     *
     * @param file the specific book
     * @return byte[] of given book
     */
    public byte[] createByteArray(File file) {

        byte[] bytesOfBook = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesOfBook);

        } catch (FileNotFoundException e) {
            System.err.println("File Not Found.");
        } catch (IOException e1) {
            System.err.println("Error Reading The File.");
        }
        return bytesOfBook;
    }

    /**
     * Saves given bytes as a file
     *
     * @param file the target destination
     * @param bytesOfBook the byte[] of book
     * @throws IOException
     */
    public void toFile(File file, byte[] bytesOfBook) throws IOException {
        try (FileOutputStream os = new FileOutputStream(file)) {
            os.write(bytesOfBook, 0, bytesOfBook.length);
            os.flush();
        }
    }

}
