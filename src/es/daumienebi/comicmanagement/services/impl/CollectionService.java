package es.daumienebi.comicmanagement.services.impl;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
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
	public Collection findCollectionById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Collection> findCollectionByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
