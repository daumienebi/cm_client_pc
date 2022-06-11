package es.daumienebi.comicmanagement.utils;

import java.util.ResourceBundle;

import es.daumienebi.comicmanagement.ui.HomeUI;
import es.daumienebi.comicmanagement.utils.Constants.AppLanguage;

/**
 * Main class that carries out the UI translation
 *  
 * @author Daumienebi Sakpa
 *
 */
public class Translator {

	public static ResourceBundle bundle;
	
	private static void setBundle(AppLanguage language) {
		switch(language) {
		case English:
			bundle = ResourceBundle.getBundle("languages.language_en_GB");
			break;
		case Spanish:
			bundle = ResourceBundle.getBundle("languages.language_es_ES");
			break;
		case Galician:
			bundle = ResourceBundle.getBundle("languages.language_gl_ES");
			break;
			
			default:bundle = ResourceBundle.getBundle("languages.language_en_GB");
		}
	}
	
	public static void translateHomeUI(AppLanguage language) {
		setBundle(language);
		HomeUI.menuConnection.setText(bundle.getString("menuConnection"));
	}
	public static void translateNewComicUI(AppLanguage language) {
		setBundle(language);
		
	}
	public static void translateNewCollectionUI(AppLanguage language) {
		setBundle(language);
		
	}
	public static void translateComicManamentUI(AppLanguage language) {
		setBundle(language);
	}
	
	public static void translateCollectionManamentUI(AppLanguage language) {
		setBundle(language);
	}
}
