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
		HomeUI.menuCollections.setText(bundle.getString("menuCollections"));
		HomeUI.menuAddCollection.setText(bundle.getString("menuAddCollection"));
		HomeUI.menuCollectionManagement.setText(bundle.getString("menuCollectionManagement"));
		HomeUI.menuComics.setText(bundle.getString("menuComics"));
		HomeUI.menuAddComic.setText(bundle.getString("menuAddComic"));
		HomeUI.menuComicManagement.setText(bundle.getString("menuComicManagement"));
		HomeUI.menuReports.setText(bundle.getString("menuReports"));
		HomeUI.menuHelpContents.setText(bundle.getString("menuHelpContents"));
		HomeUI.menuConnection.setText(bundle.getString("menuConnection"));
		HomeUI.menuConnection.setText(bundle.getString("menuConnection"));
		HomeUI.menuEnglish.setText(bundle.getString("menuEnglish"));
		HomeUI.menuSpanish.setText(bundle.getString("menuSpanish"));
		HomeUI.menuGalician.setText(bundle.getString("menuGalician"));
		HomeUI.menuSettings.setText(bundle.getString("menuSettings"));
		HomeUI.menuHelp.setText(bundle.getString("menuHelp"));
		HomeUI.menuPersonalizedReports.setText(bundle.getString("menuPersonalizedReports"));
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
	
	public static void translatePersonalizedReportsUI(AppLanguage language) {
		setBundle(language);
	}
}
