/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.view.util;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Randula
 */
public class TranspotableImage {
    
    /**
     * Converts input image to bytes
     *
     * @param bufferedImage the converted Image
     * @return bytes of image
     * @throws IOException
     */
    public byte[] createByteArray(BufferedImage bufferedImage)
            throws IOException {

        byte[] imageBytes = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        JPEGImageEncoder jpg = JPEGCodec.createJPEGEncoder(bos);
        jpg.encode(bufferedImage);
        bos.flush();
        imageBytes = bos.toByteArray();
        bos.close();
        return imageBytes;
    }

    /**
     * Saves given bytes as a file
     *
     * @param imageBytes the bytes of image
     * @return reconstructed image
     * @throws IOException
     */
    public BufferedImage createBufferedImage(byte[] imageBytes)
            throws IOException {

        InputStream is = new ByteArrayInputStream(imageBytes);
        JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(is);
        BufferedImage image = decoder.decodeAsBufferedImage();
        is.close();
        return image;
    }

    /**
     *
     * @param file the path to save image
     * @param imageBytes bytes of image
     * @throws IOException
     */
    public void toFile(File file, byte[] imageBytes)
            throws IOException {

        FileOutputStream os = new FileOutputStream(file);
        os.write(imageBytes, 0, imageBytes.length);
        os.flush();
        os.close();
    }
}
