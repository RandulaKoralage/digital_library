/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.softwarefactory;

import imageviewer.ImageViewerSof;
import java.io.IOException;
import mediaplayer.MediaPlayerSof;
import notepad.NotePadSof;
import pdfviewer.PDFViewerSof;

/**
 *
 * @author Randula
 */
public interface SoftwareFactory {

    public MediaPlayerSof getMediaPlayerSof(String path);

    public NotePadSof getNotePadSof();

    public PDFViewerSof getPDFViewerSof(String path) throws IOException;

    public ImageViewerSof getImageViewerSof(String folderPath);
}
