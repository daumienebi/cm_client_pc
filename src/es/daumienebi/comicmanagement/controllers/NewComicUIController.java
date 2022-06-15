package es.daumienebi.comicmanagement.controllers;

import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.impl.ComicService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.ImageChooser;

public class NewComicUIController {
	private ImageChooser imageChooser = new ImageChooser();
	ComicService comicService = new ComicService();
	private String COMIC_IMAGE_SERVER =  Configuration.comic_image_server;
	
	public File setImagePoster(JButton imgBtn) {
		return imageChooser.setImagePoster(imgBtn);
	}
	
	public boolean saveComic(Comic comic) {
		return comicService.saveComic(comic);
	}
	
	public ImageIcon getComicsImage(String imgRoute) {
		
		URL url = null;
		ImageIcon icon = null;
		ImageIcon default_icon = new ImageIcon(getClass().getResource("/resources/no_image.jpg"));
		try {
			url = new URL(COMIC_IMAGE_SERVER + imgRoute);
			icon = new ImageIcon(url);
			if(icon.getImageLoadStatus() == MediaTracker.ERRORED) {
				//?
			}
			if(icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
				icon = default_icon;
			}
			Image img = icon.getImage();
			//Re-scale the image
			Image imgNuevo = img.getScaledInstance(300,500,  java.awt.Image.SCALE_SMOOTH );
			icon =new ImageIcon(imgNuevo);
			return icon;
		} catch (Exception e) {
		}
		return null;
	}
}
