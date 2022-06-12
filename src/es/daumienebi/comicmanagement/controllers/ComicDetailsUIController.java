package es.daumienebi.comicmanagement.controllers;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;

public class ComicDetailsUIController {

	ICollectionService collectionService = new CollectionService();
	
	public String getCollectionName(Comic comic) {
		
		Long comic_id = (long) comic.getCollection_id();
		Collection collection = collectionService.findCollectionById(comic_id);
		
		
		return collection.getName();
	}
}
