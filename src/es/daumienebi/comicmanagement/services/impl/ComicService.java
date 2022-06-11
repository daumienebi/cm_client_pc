package es.daumienebi.comicmanagement.services.impl;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import es.daumienebi.comicmanagement.models.*;
import es.daumienebi.comicmanagement.services.IComicService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents the implementation of IComicService
 */
public class ComicService implements IComicService {
	private static String SERVER = Configuration.server;
	
	public User getUser() {
		
		
		return new User();
		
	}
	
	public ArrayList<User> getAllUsers(){
		String url = SERVER + "/users";
		ArrayList<User> users = new ArrayList<User>();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();
			int counter = 0;			
			users = mapper.readValue(EntityUtils.toString(entity),new TypeReference<ArrayList<User>>() {
			});
			counter = users.size();
			System.out.println(counter + "users found");		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public ArrayList<Comic> findAllComics() {
		// TODO Auto-generated method stub
		String url = SERVER + "/users";
		ArrayList<Comic> comics = new ArrayList<Comic>();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();
			int counter = 0;			
			comics = mapper.readValue(EntityUtils.toString(entity),new TypeReference<ArrayList<Comic>>() {
			});
			counter = comics.size();
			System.out.println(counter + "users found");		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comics;
	}

	@Override
	public Comic findComicById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comic> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
