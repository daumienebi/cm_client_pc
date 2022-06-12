package es.daumienebi.comicmanagement.services;

import java.util.ArrayList;

import es.daumienebi.comicmanagement.models.Comic;

public interface IComicService {

	public ArrayList<Comic> findAllComics();
	
	public Comic findComicById(Long id);
	
	public ArrayList<Comic> findByName(String name);
	
}
