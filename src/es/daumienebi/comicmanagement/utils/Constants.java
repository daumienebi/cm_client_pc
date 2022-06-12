package es.daumienebi.comicmanagement.utils;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

/**
 * @author Daumienebi Sakpa
 * Constant values to be used in other classes
 */
public class Constants {

	public static Dimension newComicMinimumSize = new Dimension(830,550);
	public static Dimension configUIMinimunSize = new Dimension(470,580);
	public static Font mainFont = new Font("Comic Sans Ms",1,13);
	public static Dimension newCollectionMinimumSize = new Dimension(450,400);
	public static Dimension comicManagementMinimumSize = new Dimension(700,500);
	public static Dimension collectionManagementMinimumSize = new Dimension(400,400);
	public static enum AppLanguage {English,Spanish,Galician}
	public static enum ComicState {Bueno,Nuevo,Malo}
}
