package es.daumienebi.comicmanagement.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Translator;
import java.net.URL;

/**
 * 
 * @author Daumienebi Sakpa
 *
 */
public class ConfigUIController {
	private static String PROPERTIES_PATH = "./app.properties";
	
	private void setPropertyRoute() {
		if(Configuration.debug_mode) {
			//makes no sense now but it will later on :)
			PROPERTIES_PATH = "./app.properties";
		}else {
			PROPERTIES_PATH = "./app.properties";
		}
	}
	
	public void saveConfig() {
		setPropertyRoute();
		
		Properties prop = null;
		//get the props
		try(InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("app.properties")){
			prop = new Properties();
			if(Configuration.debug_mode) {
				prop.load(inputStream);
			}else {
				FileInputStream file;
				file = new FileInputStream(PROPERTIES_PATH);
				prop.load(file);
			}
			//PROD 
			//file = new FileInputStream(PROPERTIES_PATH);
			//prop.load(file);
			
			//DEV
			//prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
		URL resourseUrl = this.getClass().getClassLoader().getResource("app.properties");
		File output_file;
		try{
			if(Configuration.debug_mode) {
				output_file = new File(resourseUrl.toURI());
			}else {
				output_file = new File(PROPERTIES_PATH);
			}
			
			try(OutputStream outputStream = new FileOutputStream(output_file);){
				prop.setProperty("server",Configuration.server);
				prop.setProperty("db_ip",Configuration.db_ip);
				prop.setProperty("db_port",Configuration.db_port);
				prop.setProperty("db_user",Configuration.db_user);
				prop.setProperty("db_password",Configuration.db_password);
				prop.setProperty("db_name",Configuration.db_name);
				prop.setProperty("ftp_server",Configuration.ftp_server);
				prop.setProperty("comic_image_server",Configuration.comic_image_server);
				prop.setProperty("movie_image_server",Configuration.collection_image_server);
				prop.setProperty("ftp_password",Configuration.ftp_password);
				prop.setProperty("ftp_user",Configuration.ftp_user);
				prop.store(outputStream, null);
				//store it with the Configuration object			
		}catch (IOException e) {
			e.printStackTrace();		
		} 
		}catch (Exception e) {
			e.printStackTrace();
		}				
}
	
	public void loadConfig() {
		//Load the configurations and save it in the Configuration.java file
		ResourceBundle.clearCache();
		//ResourceBundle.clearCache(this.getClass().getClassLoader());
		ResourceBundle bundle = ResourceBundle.getBundle("app");
		if(bundle != null) {
			Configuration.server = bundle.getString("server");
			Configuration.db_ip = bundle.getString("db_ip");
			Configuration.db_name = bundle.getString("db_name");
			Configuration.db_user = bundle.getString("db_user");
			Configuration.db_password = bundle.getString("db_password");
			Configuration.comic_image_server = bundle.getString("comic_image_server");
			Configuration.collection_image_server = bundle.getString("collection_image_server");
			Configuration.ftp_password = bundle.getString("ftp_password");
			Configuration.ftp_server = bundle.getString("ftp_server");
			Configuration.ftp_user = bundle.getString("ftp_user");
			Configuration.db_port = bundle.getString("db_port");
		}		
	}
	
	public void translate() {
		if(Translator.bundle != null) {
			Translator.translateConfigUI(Configuration.app_language);
		}
	}
}
