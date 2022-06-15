package es.daumienebi.comicmanagement.services.impl;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import es.daumienebi.comicmanagement.models.*;
import es.daumienebi.comicmanagement.services.IComicService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents the implementation of IComicService
 */
public class ComicService implements IComicService {
	private static String SERVER = Configuration.server;

	@Override
	public ArrayList<Comic> findAllComics() {
		// TODO Auto-generated method stub
		String url = SERVER + "/comics";
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
			e.printStackTrace();
		}
		return comics;
	}

	@Override
	public Comic findComicById(Long id) {
		String url = SERVER + "/comics/"+id;
		Comic comic = new Comic();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();			
			comic = mapper.readValue(EntityUtils.toString(entity),new TypeReference<Comic>() {
			});	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		String url = SERVER + "/comics";
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringEntity json = new StringEntity(mapper.writeValueAsString(comic),ContentType.APPLICATION_JSON);
			HttpClientUtil.post(json, url);
			System.out.println(json);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteComic(Long id) {
		String url = SERVER + "/comics/"+id;
		System.out.println(url);
		try {
			boolean res = HttpClientUtil.delete(url);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;// TODO: handle exception
	}
	
}