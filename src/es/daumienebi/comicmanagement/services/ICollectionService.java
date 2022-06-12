package es.daumienebi.comicmanagement.services;

import java.util.ArrayList;

import es.daumienebi.comicmanagement.models.Collection;

public interface ICollectionService {

	public ArrayList<Collection> findAllCollections();
	
	public Collection findCollectionById(Long id);
	
	public ArrayList<Collection> findCollectionByName(String name);
}
