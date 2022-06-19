package es.daumienebi.comicmanagement.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class JavaHelpUtil {

	/**
	 * 
	 * @return The URL to view the Java Help depending on in the app is in DEBUG or PRODUCTION MODE
	 * @throws MalformedURLException 
	 */
	public static URL getHelpURL() throws MalformedURLException {
		URL helpURL = null;
		
		if(Configuration.debug_mode) {
			helpURL = JavaHelpUtil.class.getResource("../help/help.hs");
		}else {
			helpURL = new URL("jar:file:ComicManagement.jar!/es/daumienebi/comicmanagement/help/help.hs");
		}
		
		return helpURL;
	}
}
