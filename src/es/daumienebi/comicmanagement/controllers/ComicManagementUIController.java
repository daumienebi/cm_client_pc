package es.daumienebi.comicmanagement.controllers;

import java.util.ArrayList;

import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.IComicService;
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
}
