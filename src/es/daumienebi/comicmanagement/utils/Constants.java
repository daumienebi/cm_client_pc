package es.daumienebi.comicmanagement.utils;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import es.daumienebi.comicmanagement.utils.Constants.AppLanguage;

/**
 * @author Daumienebi Sakpa
 * Constant values like screen dimensions,enums,fonts and other stuffs to be used in other classes
 */
public class Constants {

	public static Dimension newComicMinimumSize = new Dimension(1020,750);
	public static Dimension configUIMinimunSize = new Dimension(700,500);
	public static Font mainFont = new Font("Comic Sans Ms",1,13);
	public static Dimension newCollectionMinimumSize = new Dimension(600,550);
	public static Dimension comicManagementMinimumSize = new Dimension(700,500);
	public static Dimension collectionManagementMinimumSize = new Dimension(400,400);
	public static Dimension collectionDetailsUIMinimumSize = new Dimension(600,550);
	
	/**
	 * Defines the current language of the app between [English|Spanish|Galician]
	 * @author Daumienebi Sakpa
	 *
	 */
	public static enum AppLanguage {English,Spanish,Galician}
	
	/**
	 * Defines the posible states of a comic on creation/modification [English|Spanish|Galician].
	 * NOTE :The state "Sin Estado" cannot be used as a parameter when generating reports.
	 * See {@link ReportsUtil} for more info on generating reports.
	 * @author Daumienebi Sakpa
	 *
	 */
	public static enum ComicState {Bueno,Nuevo,Malo,SinEstado}
	public static Dimension comicDetailsMinimumSize = new Dimension(830,600);
	public static Dimension editComicMinimumSize = new Dimension(850,700);
	public static enum ComicSearchFilter {Comic,Coleccion}
	public static Dimension editCollectionMinimumSize = new Dimension(600,500);
	public static Dimension personalizedReportsUICollectionMinimumSize = new Dimension(550,300);

}
