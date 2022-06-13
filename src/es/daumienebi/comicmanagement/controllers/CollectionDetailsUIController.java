package es.daumienebi.comicmanagement.controllers;

import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

import javax.swing.ImageIcon;

import es.daumienebi.comicmanagement.utils.Configuration;

public class CollectionDetailsUIController {
	private static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;
	
	public ImageIcon getCollectionsImage(String imgRoute) {
		URL url = null;
		ImageIcon icon = null;
		ImageIcon default_icon = new ImageIcon(getClass().getResource("/resources/no_image.jpg"));
		try {
			url = new URL(COLLECTION_IMAGE_SERVER + imgRoute);
			icon = new ImageIcon(url);
			if(icon.getImageLoadStatus() == MediaTracker.ERRORED) {
				//
			}
			if(icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
				icon = default_icon;
			}
			Image img = icon.getImage();
			//Rescale the image
			Image imgNuevo = img.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
			icon =new ImageIcon(imgNuevo);
			return icon;
		} catch (Exception e) {
		}
		return null;
	}

}
