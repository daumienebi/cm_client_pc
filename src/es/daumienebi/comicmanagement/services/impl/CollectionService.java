package es.daumienebi.comicmanagement.services.impl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.HttpClientUtil;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents the implementation of ICollectionService
 */
public class CollectionService implements ICollectionService{
	private static String SERVER = Configuration.server;
	
	@Override
	public ArrayList<Collection> findAllCollections() {
		String url = SERVER + "/collections";
		ArrayList<Collection> collection = new ArrayList<Collection>();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();
			int counter = 0;			
			collection = mapper.readValue(EntityUtils.toString(entity),new TypeReference<ArrayList<Collection>>() {
			});
			counter = collection.size();
			System.out.println(counter + " collections found");		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public Collection findCollectionById(Long id) {
		String url = SERVER + "/collections/"+id;
		Collection collection = new Collection();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();			
			collection = mapper.readValue(EntityUtils.toString(entity),new TypeReference<Collection>() {
			});	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collection;
	}

	@Override
	public ArrayList<Collection> findCollectionByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveCollection(Collection collection) {
		String url = SERVER + "/collections";
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringEntity json = new StringEntity(mapper.writeValueAsString(collection),ContentType.APPLICATION_JSON);
			HttpClientUtil.post(json, url);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCollection(Long id) {
		String url = SERVER + "/collections/"+id;
		System.out.println(url);
		try {
			boolean res = HttpClientUtil.delete(url);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			return false;// TODO: handle exception
		}
		return true;
	}

	public ArrayList<Collection> fliterCollection(String name) {
		ArrayList<Collection> filteredCollections = findAllCollections();
		
		
		return (ArrayList<Collection>) filteredCollections
				.stream()
				.filter(x-> x.getName().contains(name))
				.collect(Collectors.toList());
				
	}
}
