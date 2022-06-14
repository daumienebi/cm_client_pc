package es.daumienebi.comicmanagement.controllers;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;

public class CollectionManagementUIController {
	private CollectionService collectionService = new CollectionService();
	
	public ArrayList<Collection> findAllCollections(){
		return collectionService.findAllCollections();
	}
	
	public Collection getCollection(Long id) {
		return collectionService.findCollectionById(id);
	}
	
	public boolean deleteCollection(Long id) {
		return collectionService.deleteCollection(id);
	}
}
