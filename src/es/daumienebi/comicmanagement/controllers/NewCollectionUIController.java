package es.daumienebi.comicmanagement.controllers;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;
import es.daumienebi.comicmanagement.utils.ImageChooser;

public class NewCollectionUIController {

	private CollectionService collectionService = new CollectionService();
	
	private ImageChooser imageChooser = new ImageChooser();

	public File setImagePoster(JLabel lblCollectionImg) {
		// TODO Auto-generated method stub
		return imageChooser.setImagePoster(lblCollectionImg);
	}
	
	public boolean saveCollection(Collection collection) {
		return collectionService.saveCollection(collection);
	}
}
