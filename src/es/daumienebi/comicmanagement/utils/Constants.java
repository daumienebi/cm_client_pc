package es.daumienebi.comicmanagement.utils;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

/**
 * @author Daumienebi Sakpa
 * Constant values like screen dimensions,enums,fonts and other stuffs to be used in other classes
 */
public class Constants {

	public static Dimension newComicMinimumSize = new Dimension(850,700);
	public static Dimension configUIMinimunSize = new Dimension(500,900);
	public static Font mainFont = new Font("Comic Sans Ms",1,13);
	public static Dimension newCollectionMinimumSize = new Dimension(600,550);
	public static Dimension comicManagementMinimumSize = new Dimension(700,500);
	public static Dimension collectionManagementMinimumSize = new Dimension(400,400);
	public static Dimension collectionDetailsUIMinimumSize = new Dimension(600,550);
	public static enum AppLanguage {English,Spanish,Galician}
	public static enum ComicState {Bueno,Nuevo,Malo,SinEstado}
	public static Dimension comicDetailsMinimumSize = new Dimension(830,550);
	public static Dimension editComicMinimumSize = new Dimension(850,700);
	public static enum ComicSearchFilter {Comic,Coleccion}
	public static Dimension editCollectionMinimumSize = new Dimension(600,500);
	public static Dimension personalizedReportsUICollectionMinimumSize = new Dimension(550,300);

}
