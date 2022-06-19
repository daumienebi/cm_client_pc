package es.daumienebi.comicmanagement.tablemodels;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

import es.daumienebi.comicmanagement.controllers.CollectionDetailsUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Translator;

public class CollectionTableModel extends AbstractTableModel {

	final static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;
	private ArrayList<Collection> collections;
	private String[] columns = {"ID","NOMBRE","IMAGEN"};
	private CollectionDetailsUIController controller = new CollectionDetailsUIController();
	private ResourceBundle bundle = null;
	
	public CollectionTableModel(ArrayList<Collection> collections) {
		this.collections = collections;
	}
	
	
	public String [] translateColumns() {
		if(Translator.bundle != null) {
			bundle = Translator.bundle;
			columns[0] = bundle.getString("TableHeader_Id").toUpperCase();
			columns[1] = bundle.getString("TableHeader_Name").toUpperCase();
			columns[2] = bundle.getString("TableHeader_Image").toUpperCase();
		}
		return columns;
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
			case 2: return controller.getCollectionsImage(collection.getImage(),true);
			default:return "-";
		}
	}
	
}
