package es.daumienebi.comicmanagement.utils;

import java.util.ResourceBundle;

import es.daumienebi.comicmanagement.ui.CollectionDetailsUI;
import es.daumienebi.comicmanagement.ui.CollectionManagementUI;
import es.daumienebi.comicmanagement.ui.ComicDetailsUI;
import es.daumienebi.comicmanagement.ui.ComicManagementUI;
import es.daumienebi.comicmanagement.ui.HomeUI;
import es.daumienebi.comicmanagement.ui.NewCollectionUI;
import es.daumienebi.comicmanagement.ui.NewComicUI;
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
		HomeUI.menuAddConnection.setText(bundle.getString("menuAddConnection"));
		HomeUI.menuCollections.setText(bundle.getString("menuCollections"));
		HomeUI.menuAddCollection.setText(bundle.getString("menuAddCollection"));
		HomeUI.menuCollectionManagement.setText(bundle.getString("menuCollectionManagement"));
		HomeUI.menuComics.setText(bundle.getString("menuComics"));
		HomeUI.menuAddComic.setText(bundle.getString("menuAddComic"));
		HomeUI.menuComicManagement.setText(bundle.getString("menuComicManagement"));
		HomeUI.menuReports.setText(bundle.getString("menuReports"));
		HomeUI.menuHelpContents.setText(bundle.getString("menuHelpContents"));
		HomeUI.menuConnection.setText(bundle.getString("menuConnection"));
		HomeUI.menuEnglish.setText(bundle.getString("menuEnglish"));
		HomeUI.menuSpanish.setText(bundle.getString("menuSpanish"));
		HomeUI.menuGalician.setText(bundle.getString("menuGalician"));
		HomeUI.menuSettings.setText(bundle.getString("menuSettings"));
		HomeUI.menuHelp.setText(bundle.getString("menuHelp"));
		HomeUI.menuPersonalizedReports.setText(bundle.getString("menuPersonalizedReports"));
		HomeUI.menuOptionExit.setText(bundle.getString("menuOptionExit"));
		HomeUI.menuHome.setText(bundle.getString("menuHome"));
		HomeUI.menuReports.setText(bundle.getString("menuReports"));
		HomeUI.menuBasicReports.setText(bundle.getString("menuBasicReports"));
		HomeUI.menuPersonalizedR_collection.setText(bundle.getString("menuPersonalizedR_collection"));
		HomeUI.menuPersonalizedR_comic.setText(bundle.getString("menuPersonalizedR_comic"));
		HomeUI.menuOptionRestart.setText(bundle.getString("menuOptionRestart"));
	}
	
	public static void translateComicDetailsUI(AppLanguage language) {
		setBundle(language);
		ComicDetailsUI.NewComicUI_comicName.setText(bundle.getString("NewComicUI_comicName"));
		ComicDetailsUI.NewComicUI_comicCollection.setText(bundle.getString("NewComicUI_comicName"));
		ComicDetailsUI.NewComicUI_comicAdquisitionDate.setText(bundle.getString("NewComicUI_comicAdquisitionDate"));
		ComicDetailsUI.NewComicUI_comicState.setText(bundle.getString("NewComicUI_comicState"));
		ComicDetailsUI.NewComicUI_comicNumber.setText(bundle.getString("NewComicUI_comicNumber"));
		ComicDetailsUI.NewComicUI_newComic = bundle.getString("NewComicUI_newComic");
	}
	
	public static void translateNewComicUI(AppLanguage language) {
		setBundle(language);
		NewComicUI.NewComicUI_comicName.setText(bundle.getString("NewComicUI_comicName"));
		NewComicUI.NewComicUI_comicCollection.setText(bundle.getString("NewComicUI_comicCollection"));
		NewComicUI.NewComicUI_comicAdquisitionDate.setText(bundle.getString("NewComicUI_comicAdquisitionDate"));
		NewComicUI.NewComicUI_comicState.setText(bundle.getString("NewComicUI_comicState"));
		NewComicUI.NewComicUI_comicNumber.setText(bundle.getString("NewComicUI_comicNumber"));
		NewComicUI.NewComicUI_windowTitle = bundle.getString("NewComicUI_windowTitle");
		NewComicUI.NewComicUI_newComic =  bundle.getString("NewComicUI_newComic");
		NewComicUI.NewComicUI_btnAddComic.setText(bundle.getString("NewComicUI_btnAddComic"));
		NewComicUI.NewComicUI_btnSaveComic.setText(bundle.getString("NewComicUI_btnSaveComic"));
		//NewComicUI.UIMessage_plsFillFields = 
	}
	public static void translateNewCollectionUI(AppLanguage language) {
		setBundle(language);
		NewCollectionUI.NewCollectionUI_name.setText(bundle.getString("NewCollectionUI_name"));
		NewCollectionUI.NewCollectionUI_AddCollection.setText(bundle.getString("NewCollectionUI_AddCollection"));
		NewCollectionUI.NewCollectionUI_SaveCollection.setText(bundle.getString("NewCollectionUI_SaveCollection"));
		NewCollectionUI.NewCollectionUI_windowTitleEdit = bundle.getString("NewCollectionUI_windowTitleEdit");		
	}
	public static void translateComicManagementUI(AppLanguage language) {
		setBundle(language);
		ComicManagementUI.ComicManagementUI_searchOptions = bundle.getString("ComicManagementUI_searchOptions");
		ComicManagementUI.ComicManagementUI_windowTitle = bundle.getString("ComicManagementUI_windowTitle");
		ComicManagementUI.ComicManagementUI_name.setText(bundle.getString("ComicManagementUI_name"));
		ComicManagementUI.ComicManagementUI_filter.setText(bundle.getString("ComicManagementUI_filter"));
	}
	
	public static void translateCollectionManagementUI(AppLanguage language) {
		setBundle(language);
		CollectionManagementUI.CollectionManagementUI_searchOptions = bundle.getString("CollectionManagementUI_searchOptions");;
		CollectionManagementUI.CollectionManagementUI_collection.setText(bundle.getString("CollectionManagementUI_collection"));;
		CollectionManagementUI.CollectionManagementUI_windowTitle = bundle.getString("CollectionManagementUI_windowTitle");;
	}
	
	public static void translateCollectionDetailsUI(AppLanguage language) {
		CollectionDetailsUI.CollectionDetailsUI_count.setText(bundle.getString("CollectionDetailsUI_count"));
		CollectionDetailsUI.CollectionDetailsUI_name.setText(bundle.getString("CollectionDetailsUI_name"));

	}
	
	public static void translatePersonalizedReportsUI(AppLanguage language) {
		setBundle(language);
	}
}
