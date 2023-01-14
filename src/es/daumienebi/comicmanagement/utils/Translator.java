package es.daumienebi.comicmanagement.utils;

import java.util.ResourceBundle;

import es.daumienebi.comicmanagement.ui.AddCollectioToComicUI;
import es.daumienebi.comicmanagement.ui.CollectionDetailsUI;
import es.daumienebi.comicmanagement.ui.CollectionManagementUI;
import es.daumienebi.comicmanagement.ui.ComicDetailsUI;
import es.daumienebi.comicmanagement.ui.ComicManagementUI;
import es.daumienebi.comicmanagement.ui.ConfigUI;
import es.daumienebi.comicmanagement.ui.HomeUI;
import es.daumienebi.comicmanagement.ui.NewCollectionUI;
import es.daumienebi.comicmanagement.ui.NewComicUI;
import es.daumienebi.comicmanagement.ui.PersonalizedReportsUI;
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
		HomeUI.UIMessages_confirmationExit = bundle.getString("UIMessages_confirmacionExit");
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
		NewComicUI.UIMessage_plsFillFields = bundle.getString("UIMessage_plsFillFields");		
		NewComicUI.UIMessage_recordAdded = bundle.getString("UIMessage_recordAdded");		
		NewComicUI.UIMessage_recordSaved = bundle.getString("UIMessage_recordSaved");		
		NewComicUI.UIMessage_errorAddingRecord = bundle.getString("UIMessage_errorAddingRecord"); 
	}
	public static void translateNewCollectionUI(AppLanguage language) {
		setBundle(language);
		NewCollectionUI.NewCollectionUI_name.setText(bundle.getString("NewCollectionUI_name"));
		NewCollectionUI.NewCollectionUI_AddCollection.setText(bundle.getString("NewCollectionUI_AddCollection"));
		NewCollectionUI.NewCollectionUI_SaveCollection.setText(bundle.getString("NewCollectionUI_SaveCollection"));
		NewCollectionUI.NewCollectionUI_windowTitleEdit = bundle.getString("NewCollectionUI_windowTitleEdit");		
		NewCollectionUI.UIMessage_plsFillFields = bundle.getString("UIMessage_plsFillFields");		
		NewCollectionUI.UIMessage_recordAdded = bundle.getString("UIMessage_recordAdded");		
		NewCollectionUI.UIMessage_recordSaved = bundle.getString("UIMessage_recordSaved");		
		NewCollectionUI.UIMessage_errorAddingRecord = bundle.getString("UIMessage_errorAddingRecord");		
		NewCollectionUI.NewCollectionUI_windowTitle = bundle.getString("NewCollectionUI_windowTitle");
	}
	public static void translateComicManagementUI(AppLanguage language) {
		setBundle(language);
		ComicManagementUI.ComicManagementUI_searchOptions = bundle.getString("ComicManagementUI_searchOptions");
		ComicManagementUI.ComicManagementUI_windowTitle = bundle.getString("ComicManagementUI_windowTitle");
		ComicManagementUI.ComicManagementUI_name.setText(bundle.getString("ComicManagementUI_name"));
		ComicManagementUI.ComicManagementUI_filter.setText(bundle.getString("ComicManagementUI_filter"));
		ComicManagementUI.UIMessages_noItemSelected = bundle.getString("UIMessages_noItemSelected");
		ComicManagementUI.UIMessages_recordDeleted = bundle.getString("UIMessages_recordDeleted");
		ComicManagementUI.UIMessages_confirmacion = bundle.getString("UIMessages_confirmacion");
		ComicManagementUI.UIMessages_recordNotFound = bundle.getString("UIMessages_recordNotFound");
		ComicManagementUI.UIMessages_errorDeletingRecord = bundle.getString("UIMessages_errorDeletingRecord");
	}
	
	public static void translateCollectionManagementUI(AppLanguage language) {
		setBundle(language);
		CollectionManagementUI.CollectionManagementUI_searchOptions = bundle.getString("CollectionManagementUI_searchOptions");;
		CollectionManagementUI.CollectionManagementUI_collection.setText(bundle.getString("CollectionManagementUI_collection"));;
		CollectionManagementUI.CollectionManagementUI_windowTitle = bundle.getString("CollectionManagementUI_windowTitle");;
		CollectionManagementUI.UIMessages_noItemSelected = bundle.getString("UIMessages_noItemSelected");
		CollectionManagementUI.UIMessages_recordDeleted = bundle.getString("UIMessages_recordDeleted");
		CollectionManagementUI.UIMessages_confirmacion = bundle.getString("UIMessages_confirmacion");
		CollectionManagementUI.UIMessages_recordNotFound = bundle.getString("UIMessages_recordNotFound");
		CollectionManagementUI.UIMessages_errorDeletingRecord = bundle.getString("UIMessages_errorDeletingRecord");
	}
	
	public static void translateCollectionDetailsUI(AppLanguage language) {
		//CollectionDetailsUI.CollectionDetailsUI_count.setText(bundle.getString("CollectionDetailsUI_count"));
		CollectionDetailsUI.CollectionDetailsUI_name.setText(bundle.getString("CollectionDetailsUI_name"));

	}
	
	public static void translatePersonalizedReportsUI(AppLanguage language) {
		setBundle(language);
		PersonalizedReportsUI.header1 = bundle.getString("header1");
		PersonalizedReportsUI.header2 = bundle.getString("header2");
		PersonalizedReportsUI.PersonalizedReportsUI_comicState.setText(bundle.getString("header1"));
		PersonalizedReportsUI.btnLoadReport1.setText(bundle.getString("btnLoadReport1"));
		PersonalizedReportsUI.btnLoadReport3.setText(bundle.getString("btnLoadReport3"));
		PersonalizedReportsUI.PersonalizedReportsUI_comicCount.setText(bundle.getString("PersonalizedReportsUI_comicCount"));
		PersonalizedReportsUI.UIMessages_error = bundle.getString("UIMessages_error");
		PersonalizedReportsUI.UIMessages_incorrectDataType = bundle.getString("UIMessages_incorrectDataType");
		PersonalizedReportsUI.PersonalizedReportsUI_windowTitle = bundle.getString("PersonalizedReportsUI_windowTitle");
	}
	
	public static void translateConfigUI(AppLanguage language) {
		setBundle(language);
		ConfigUI.ConfigUI_Server.setText(bundle.getString("ConfigUI_Server").toUpperCase());
		ConfigUI.ConfigUI_FtpUser.setText(bundle.getString("ConfigUI_FtpUser").toUpperCase());
		ConfigUI.ConfigUI_FtpServer.setText(bundle.getString("ConfigUI_FtpServer").toUpperCase());
		ConfigUI.ConfigUI_FtpServer2.setText(bundle.getString("ConfigUI_FtpServer2").toUpperCase());
		ConfigUI.ConfigUI_PrincipalServer.setText(bundle.getString("ConfigUI_PrincipalServer").toUpperCase());
		ConfigUI.ConfigUI_ComicImgServer.setText(bundle.getString("ConfigUI_ComicImgServer").toUpperCase());
		ConfigUI.ConfigUI_FtpPassword.setText(bundle.getString("ConfigUI_FtpPassword").toUpperCase());
		ConfigUI.ConfigUI_ImageServer.setText(bundle.getString("ConfigUI_ImageServer").toUpperCase());
		ConfigUI.ConfigUI_SaveSettings.setText(bundle.getString("ConfigUI_SaveSettings").toUpperCase());
		ConfigUI.ConfigUI_port.setText(bundle.getString("ConfigUI_port").toUpperCase());
		ConfigUI.ConfigUI_nombre.setText(bundle.getString("ConfigUI_nombre").toUpperCase());
		ConfigUI.ConfigUI_password.setText(bundle.getString("ConfigUI_password").toUpperCase());
		ConfigUI.ConfigUI_ip.setText(bundle.getString("ConfigUI_ip").toUpperCase());
		ConfigUI.ConfigUI_BaseDeDatos.setText(bundle.getString("ConfigUI_BaseDeDatos").toUpperCase());
		ConfigUI.ConfigUI_CollectionImgServer.setText(bundle.getString("ConfigUI_CollectionImgServer").toUpperCase());
		ConfigUI.ConfigUI_user.setText(bundle.getString("ConfigUI_user").toUpperCase());
		ConfigUI.ConfigUI_configValues = bundle.getString("ConfigUI_configValues").toUpperCase();
		ConfigUI.ConfigUI_saveError = bundle.getString("ConfigUI_configValues");
		ConfigUI.ConfigUI_saved = bundle.getString("ConfigUI_saved");
	}

	
	public static void translateAddCollectionToComicUI(AppLanguage language) {
		setBundle(language);
		AddCollectioToComicUI.CollectionManagementUI_searchOptions = bundle.getString("CollectionManagementUI_searchOptions");
		AddCollectioToComicUI.CollectionManagementUI_collection.setText(bundle.getString("CollectionManagementUI_collection"));
		AddCollectioToComicUI.UIMessages_noItemSelected = bundle.getString("UIMessages_noItemSelected");
		
		
	}
}
