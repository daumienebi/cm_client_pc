package es.daumienebi.comicmanagement.utils;

import java.net.MalformedURLException;
import java.net.URL;

import es.daumienebi.comicmanagement.utils.Constants.AppLanguage;

/**
 * Java Help Util class to easily select the correct help documents depending on the app launch mode [DEBUG|NORMAL]
 * and the AppLanguage
 * @author Daumienebi Sakpa
 *
 */
public class JavaHelpUtil {

	/**
	 * 
	 * @return The URL to view the Java Help depending on in the app is in DEBUG or PRODUCTION MODE.
	 * It also takes the Current  {@link AppLanguage} into consideration
	 * @throws MalformedURLException 
	 */
	public static URL getHelpURL() throws MalformedURLException {
		URL helpURL = null;
		if(Configuration.debug_mode) {
			helpURL = JavaHelpUtil.class.getResource("../help/help.hs");
		}else {
			helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/help.hs");
		}
		/*
		if(Configuration.debug_mode) {
			
			switch(Configuration.app_language) {
				case Spanish : 	helpURL = JavaHelpUtil.class.getResource("../help/spanish/help.hs");
				break;
				case English : 	helpURL = JavaHelpUtil.class.getResource("../help/spanish/help.hs"); //no English helo yet
				break;
				case Galician :	helpURL = JavaHelpUtil.class.getResource("../help/galician/help.hs");
				break;
				default : 		helpURL =  JavaHelpUtil.class.getResource("../help/spanish/help.hs");
				break;
			}
		}else {
			switch(Configuration.app_language) {
			case Spanish : 	helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/spanish/help.hs");
			break;
			case English : 	helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/spanish/help.hs"); //no English helo yet
			break;
			case Galician :	helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/galician/help.hs");
			break;
			default : 		helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/spanish/help.hs");
			break;
		}
			//helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/spanish/help.hs");
		}
		*/
		return helpURL;
	}
}
