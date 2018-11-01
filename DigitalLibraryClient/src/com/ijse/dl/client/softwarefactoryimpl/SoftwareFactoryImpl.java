/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.dl.client.softwarefactoryimpl;

import com.ijse.dl.client.softwarefactory.SoftwareFactory;
import imageviewer.ImageViewerSof;
import java.io.IOException;
import mediaplayer.MediaPlayerSof;
import notepad.NotePadSof;
import pdfviewer.PDFViewerSof;

/**
 *
 * @author Randula
 */
public class SoftwareFactoryImpl implements SoftwareFactory {

    @Override
    public MediaPlayerSof getMediaPlayerSof(String path) {
        return new MediaPlayerSof(path);
    }

    @Override
    public NotePadSof getNotePadSof() {
        return new NotePadSof();
    }

    @Override
    public PDFViewerSof getPDFViewerSof(String path) throws IOException {
        return new PDFViewerSof(path);
    }

    @Override
    public ImageViewerSof getImageViewerSof(String folderPath) {
        return new ImageViewerSof(folderPath);
    }

}
