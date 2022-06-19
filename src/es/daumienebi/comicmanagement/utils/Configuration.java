package es.daumienebi.comicmanagement.utils;

import es.daumienebi.comicmanagement.utils.Constants.*;

/**
 * Java class for the "app.properties" values and some default configuration values
 * @author Daumienebi Sakpa
 * 
 */
public class Configuration {
	public static String server = "http://192.168.56.101:8081";
	public static String comic_image_server = "http://192.168.56.101/comicmanagement/images/comics/";
	public static String collection_image_server = "http://192.168.56.101/comicmanagement/images/collections/";
	public static String ftp_server = "http://192.168.56.101";
	public static String ftp_user = "comicdb";
	public static String ftp_password = "comicdb";
	public static AppLanguage app_language;
	public static boolean debug_mode = true;
	public static String bd_ip = "192.168.56.101";
	public static String bd_port = "3306";
	public static String bd_name = "comicdb";
	public static String bd_user = "root";
	public static String bd_password = "";
	
}
