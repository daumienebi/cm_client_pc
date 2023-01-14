package es.daumienebi.comicmanagement.services.impl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Constants.AppLanguage;
import es.daumienebi.comicmanagement.utils.HttpClientUtil;

/**
 * 
 * @author Daumienebi Sakpa
 * A Java class that represents the implementation of ICollectionService
 */
public class CollectionService implements ICollectionService{
	private static String SERVER = Configuration.server;
	private static String connectionError;
	
	private static void setErrorMessage() {
		
		switch(Configuration.app_language) {
			case English : connectionError = "Error performing the request to the server, please check your connection settings and make sure the server is running";
			break;
			case Spanish : connectionError = "Error realizando la petición al servidor, por favor revisa los ajustes de conexión y asegurese de que el servidor esta corriendo";
			break;
			case Galician : connectionError = "Produciuse un erro ao solicitar o servidor, comprobe a configuración de conexión e asegúrate de que o servidor estea en execución";
			break;
			default: connectionError = "Error realizando la petición al servidor, por favor revisa los ajustes de conexión y asegurese de que el servidor esta corriendo";
		}
	}
	
	@Override
	public ArrayList<Collection> findAllCollections() {
		setErrorMessage();
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
			JOptionPane.showMessageDialog(null,connectionError);
		}
		return collection;
	}

	@Override
	public Collection findCollectionById(Long id) {
		setErrorMessage();
		String url = SERVER + "/collections/"+id;
		Collection collection = new Collection();
		try {
			HttpEntity entity = HttpClientUtil.get(url);
			ObjectMapper mapper = new ObjectMapper();			
			collection = mapper.readValue(EntityUtils.toString(entity),new TypeReference<Collection>() {
			});	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,connectionError);
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
		setErrorMessage();
		String url = SERVER + "/collections";
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringEntity json = new StringEntity(mapper.writeValueAsString(collection),ContentType.APPLICATION_JSON);
			HttpClientUtil.post(json, url);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,connectionError);
		}
		return false;
	}

	@Override
	public boolean deleteCollection(Long id) {
		setErrorMessage();
		String url = SERVER + "/collections/"+id;
		System.out.println(url);
		try {
			boolean res = HttpClientUtil.delete(url);
			System.out.println(res);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,connectionError);
			return false;// TODO: handle exception
		}
		return true;
	}

	public ArrayList<Collection> fliterCollection(String name) {
		ArrayList<Collection> filteredCollections = findAllCollections();
		
		
		return (ArrayList<Collection>) filteredCollections
				.stream()
				.filter(x-> x.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
				
	}

	@Override
	public boolean updateCollection(Collection collection) {
		setErrorMessage();
		Long id = collection.getId();
		System.out.println(id);
		String url = SERVER + "/collections/"+id;
		System.out.println(url);
		try {
			ObjectMapper mapper = new ObjectMapper();
			StringEntity json = new StringEntity(mapper.writeValueAsString(collection),ContentType.APPLICATION_JSON);
			boolean res = HttpClientUtil.put(json,url);
			System.out.println(res);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,connectionError);
			return false;
		}
	}
}
