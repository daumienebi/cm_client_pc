package es.daumienebi.comicmanagement.services.impl;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import es.daumienebi.comicmanagement.models.*;
import es.daumienebi.comicmanagement.services.IComicService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.HttpClientUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents the implementation of IComicService
 */
public class ComicService implements IComicService {
	private static String SERVER = Configuration.server;
	private static String connectionError;
	
	private static void setErrorMessage() {
		
		switch(Configuration.app_language) {
			case English : connectionError = "Error performing the request to the server, please check your connection settings and make sure the server is running";
			break;
			case Spanish : connectionError = "Error realizando la petici�n al servidor, por favor revisa los ajustes de conexi�n y asegurese de que el servidor esta corriendo";
			break;
			case Galician : connectionError = "Produciuse un erro ao solicitar o servidor, comprobe a configuraci�n de conexi�n e aseg�rate de que o servidor estea en execuci�n";
			break;
			default: connectionError = "Error realizando la petici�n al servidor, por favor revisa los ajustes de conexi�n y asegurese de que el servidor esta corriendo";
		}
	}
	
	@Override
	public ArrayList<Comic> findAllComics() {
		setErrorMessage();
		String url = SERVER + "/comics";
		System.out.println(url);
		ArrayList<Comic> comics = new ArrayList<Comic>();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();
			//mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			//mapper.registerModule(new JavaTimeModule());
			int counter = 0;			
			comics = mapper.readValue(EntityUtils.toString(entity),new TypeReference<ArrayList<Comic>>() {
			});
			counter = comics.size();
			System.out.println(counter + " comics found");		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,connectionError);
		}
		return comics;
	}

	@Override
	public Comic findComicById(Long id) {
		setErrorMessage();
		String url = SERVER + "/comics/"+id;
		Comic comic = new Comic();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();			
			comic = mapper.readValue(EntityUtils.toString(entity),new TypeReference<Comic>() {
			});	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,connectionError);
		}
		return comic;
	}

	@Override
	public ArrayList<Comic> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveComic(Comic comic) {
		setErrorMessage();
		String url = SERVER + "/comics";
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringEntity json = new StringEntity(mapper.writeValueAsString(comic),ContentType.APPLICATION_JSON);
			HttpClientUtil.post(json, url);
			System.out.println(json);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,connectionError);
			return false;
		}
	}

	@Override
	public boolean deleteComic(Long id) {
		setErrorMessage();
		String url = SERVER + "/comics/"+id;
		System.out.println(url);
		try {
			boolean res = HttpClientUtil.delete(url);
			System.out.println(res);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,connectionError);
			return false;
		}
	}
	
	@Override
	public boolean updateComic(Comic comic) {
		setErrorMessage();
		Long id = comic.getId();
		System.out.println(id);
		String url = SERVER + "/comics/"+id;
		System.out.println(url);
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringEntity json = new StringEntity(mapper.writeValueAsString(comic),ContentType.APPLICATION_JSON);
			boolean res = HttpClientUtil.put(json,url);
			System.out.println(res);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,connectionError);
			return false;
		}
	}
	
	public ArrayList<Comic> fliterComic(String name) {
		ArrayList<Comic> filteredComics = findAllComics();
		return (ArrayList<Comic>) filteredComics
				.stream()
				.filter(x-> x.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());				
	}

	public ArrayList<Comic> fliterComicByCollection(String name) {
		return null;
	}
	
}