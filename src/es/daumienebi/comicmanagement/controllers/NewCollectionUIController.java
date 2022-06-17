package es.daumienebi.comicmanagement.controllers;

import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.ImageChooser;

public class NewCollectionUIController {

	private CollectionService collectionService = new CollectionService();
	private static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;

	private ImageChooser imageChooser = new ImageChooser();

	public File setImagePoster(JLabel lblCollectionImg) {
		// TODO Auto-generated method stub
		return imageChooser.setImagePoster(lblCollectionImg);
	}
	
	public boolean saveCollection(Collection collection) {
		return collectionService.saveCollection(collection);
	}
	
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
	
	public boolean updateCollection(Collection collection) {
		return collectionService.updateCollection(collection);
	}
}
