package es.daumienebi.comicmanagement.controllers;

import java.util.ArrayList;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;

public class CollectionManagementUIController {
	private ICollectionService collectionService = new CollectionService();
	
	public ArrayList<Collection> findAllCollections(){
		return collectionService.findAllCollections();
	}
	
	public Collection getCollection(Long id) {
		return collectionService.findCollectionById(id);
	}
}
