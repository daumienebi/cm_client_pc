package es.daumienebi.comicmanagement.controllers;

import java.io.File;
import javax.swing.JButton;

import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.impl.ComicService;
import es.daumienebi.comicmanagement.utils.ImageChooser;

public class NewComicUIController {
	private ImageChooser imageChooser = new ImageChooser();
	ComicService comicService = new ComicService();
	
	public File setImagePoster(JButton imgBtn) {
		return imageChooser.setImagePoster(imgBtn);
	}
	
	public boolean saveComic(Comic comic) {
		return comicService.saveComic(comic);
	}
}
