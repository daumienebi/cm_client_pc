package es.daumienebi.comicmanagement.controllers;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JLabel;

import es.daumienebi.comicmanagement.utils.ImageChooser;

public class NewCollectionUIController {

	private ImageChooser imageChooser = new ImageChooser();
	
	public File setImagePoster(JButton imgBtn) {
		return imageChooser.setImagePoster(imgBtn);
	}

	public File setImagePoster(JLabel lblCollectionImg) {
		// TODO Auto-generated method stub
		return imageChooser.setImagePoster(lblCollectionImg);
	}
}
