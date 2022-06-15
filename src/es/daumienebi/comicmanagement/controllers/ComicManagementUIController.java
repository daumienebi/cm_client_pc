package es.daumienebi.comicmanagement.controllers;

import java.util.ArrayList;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.impl.ComicService;

public class ComicManagementUIController {
	private ComicService comicService = new ComicService();
	
	
	public ArrayList<Comic> findAllComics(){
		return comicService.findAllComics();
	}
	
	public Comic getComic(Long id) {
		return comicService.findComicById(id);
	}
	
	public boolean deleteComic(Long id) {
		return comicService.deleteComic(id);
	}
	
	public ArrayList<Comic> filterComic(String name) {
		ArrayList<Comic> filteredComics = new ArrayList<>();
		filteredComics = comicService.fliterComic(name);
		return filteredComics;
	}
	
	public ArrayList<Comic> filterComicByCollection(String name) {
		ArrayList<Comic> filteredComics = new ArrayList<>();
		filteredComics = comicService.fliterComicByCollection(name);
		return filteredComics;
	}
}
