package es.daumienebi.comicmanagement.utils;

import es.daumienebi.comicmanagement.utils.Constants.*;

/**
 * Java class for the "app.properties" values and some default configuration values
 * @author Daumienebi Sakpa
 * 
 */
public class Configuration {
	public static String server = "http://192.168.8.144:8081";
	public static String comic_image_server;
	public static String collection_image_server;
	public static String ftp_server;
	public static String ftp_user;
	public static String ftp_password;
	public static AppLanguage app_language = AppLanguage.English;
	//The [debug_mode] should be set to true to skip the loading screen.
	//It must be set to false after code modification before generating the jars to enable the loading screen.
	public static boolean debug_mode = false;
	public static String db_ip;	
	public static String db_port; //3306
	public static String db_name; //comicdb
	public static String db_user; //root
	public static String db_password;
}
