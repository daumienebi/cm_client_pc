package es.daumienebi.comicmanagement.utils;

import es.daumienebi.comicmanagement.utils.Constants.*;

/**
 * Java model for the "app.properties" values and some default configuration values
 * @author Daumienebi Sakpa
 * 
 */
public class Configuration {

	public static String server = "http://localhost:8081";
	public static String language;
	public static String comic_image_server = "http://192.168.56.101/comicmanagement/images/comics/";;
	public static String collection_image_server = "http://192.168.56.101/comicmanagement/images/collections/";
	public static String ftp_server;
	public static String ftp_user;
	public static String ftp_password;
	public static AppLanguage app_language;
	public static boolean debug_mode = true;
}
