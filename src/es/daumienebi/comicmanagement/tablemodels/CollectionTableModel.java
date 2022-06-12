package es.daumienebi.comicmanagement.tablemodels;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import es.daumienebi.comicmanagement.models.Collection;

public class CollectionTableModel extends AbstractTableModel {

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
			case 2: return collection.getImage();
			default:return "-";
		}
	}
	
	private ImageIcon getCollectionImage(String imgRoute) {
		URL url = null;
		ImageIcon icon = null;
		ImageIcon default_icon = new ImageIcon(getClass().getResource(""));
		
		//more logic
		
		return null;
	}
	
}
