package es.daumienebi.comicmanagement.tablemodels;

import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.utils.Configuration;

public class CollectionTableModel extends AbstractTableModel {

	final static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;
	private ArrayList<Collection> collections;
	private String[] columns = {"ID","NOMBRE","IMAGEN"};
	
	public CollectionTableModel(ArrayList<Collection> collections) {
		this.collections = collections;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return collections.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 2: return Icon.class; //indicates that an image is going to be displayed on the third column
		default : return Collection.class; //the rest columns will be values of the Collection class
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Collection collection = collections.get(rowIndex);
		switch (columnIndex) {
			case 0: return collection.getId();
			case 1: return collection.getName();
			case 2: return getCollectionsImage(collection.getImage());
			default:return "-";
		}
	}
	
	private ImageIcon getCollectionsImage(String imgRoute) {
		URL url = null;
		ImageIcon icon = null;
		ImageIcon default_icon = new ImageIcon(getClass().getResource("/resources/no_image.jpg"));
		try {
			url = new URL(COLLECTION_IMAGE_SERVER + imgRoute);
			icon = new ImageIcon(url);
			if(icon.getImageLoadStatus() == MediaTracker.ERRORED) {
				//
			}
			if(icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
				icon = default_icon;
			}
			Image img = icon.getImage();
			//Rescale the image
			Image imgNuevo = img.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
			icon =new ImageIcon(imgNuevo);
			return icon;
		} catch (Exception e) {
		}
		return null;
	}
	
}
