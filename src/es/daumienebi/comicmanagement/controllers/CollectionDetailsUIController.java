package es.daumienebi.comicmanagement.controllers;

import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

import javax.swing.ImageIcon;

import es.daumienebi.comicmanagement.utils.Configuration;

public class CollectionDetailsUIController {
	private static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;
	
	/**
	 * 
	 * @param imgRoute - name or route of the image to be set
	 * @param isTableImage - boolean value to indicate if the image is to be set to the collection table or the
	 * collection detail page [to resize the image correctly] 
	 * @return Returns the image icon to be set
	 */
	public ImageIcon getCollectionsImage(String imgRoute,boolean isTableImage) {
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
			//Re-scale the image
			Image imgNuevo;
			if(isTableImage) {
				imgNuevo = img.getScaledInstance(120,100,  java.awt.Image.SCALE_SMOOTH );
			}else{
				imgNuevo = img.getScaledInstance(300,500,  java.awt.Image.SCALE_SMOOTH );
			}
			icon =new ImageIcon(imgNuevo);
			return icon;
		} catch (Exception e) {
		}
		return null;
	}

}
