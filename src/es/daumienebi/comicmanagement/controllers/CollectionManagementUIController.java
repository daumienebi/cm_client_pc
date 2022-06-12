package es.daumienebi.comicmanagement.controllers;

import java.util.ArrayList;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;

public class CollectionManagementUIController {
	ICollectionService collectionService = new CollectionService();
	
	public ArrayList<Collection> findAllCollections(){
		return collectionService.findAllCollections();
	}
}
