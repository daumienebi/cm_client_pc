package es.daumienebi.comicmanagement.controllers;

import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

import javax.swing.ImageIcon;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;
import es.daumienebi.comicmanagement.utils.Configuration;

public class ComicDetailsUIController {

	ICollectionService collectionService = new CollectionService();
	private String COMIC_IMAGE_SERVER =  Configuration.comic_image_server;
	
	public String getCollectionName(Comic comic) {
		
		Long comic_id = (long) comic.getCollection_id();
		Collection collection = collectionService.findCollectionById(comic_id);
		
		
		return collection.getName();
	}
	
	public ImageIcon getComicsImage(String imgRoute) {
		
		URL url = null;
		ImageIcon icon = null;
		ImageIcon default_icon = new ImageIcon(getClass().getResource("/resources/no_image.jpg"));
		try {
			url = new URL(COMIC_IMAGE_SERVER + imgRoute);
			icon = new ImageIcon(url);
			if(icon.getImageLoadStatus() == MediaTracker.ERRORED) {
				//
			}
			if(icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
				icon = default_icon;
			}
			Image img = icon.getImage();
			//Rescale the image
			Image imgNuevo = img.getScaledInstance(300,350,  java.awt.Image.SCALE_SMOOTH );
			icon =new ImageIcon(imgNuevo);
			return icon;
		} catch (Exception e) {
		}
		return null;
	}
}
