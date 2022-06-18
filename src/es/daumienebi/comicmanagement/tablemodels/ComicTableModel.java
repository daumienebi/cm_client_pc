package es.daumienebi.comicmanagement.tablemodels;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.ICollectionService;
import es.daumienebi.comicmanagement.services.impl.CollectionService;
import es.daumienebi.comicmanagement.utils.Translator;

public class ComicTableModel extends AbstractTableModel{

	private ArrayList<Comic> comics;
	private String[] columns = {"ID","NOMBRE","FECHA ADQUISICIÓN","COLECCIÓN","ESTADO","NUMERO"};
	private ICollectionService collectionService = new CollectionService();
	private ResourceBundle bundle = null;
	
	public ComicTableModel(ArrayList<Comic> comics) {
		this.comics = comics;
	}

	public String [] translateColumns() {
		if(Translator.bundle != null) {
			bundle = Translator.bundle;
			columns[0] = bundle.getString("TableHeader_Id").toUpperCase();
			columns[1] = bundle.getString("TableHeader_Name").toUpperCase();
			columns[2] = bundle.getString("TableHeader_AdquisitionDate").toUpperCase();
			columns[3] = bundle.getString("TableHeader_Collection").toUpperCase();
			columns[4] = bundle.getString("TableHeader_State").toUpperCase();
			columns[5] = bundle.getString("TableHeader_Number").toUpperCase();
		}
		return columns;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getRowCount() {
		return comics.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Comic comic = comics.get(rowIndex);
		switch(columnIndex) {
			case 0: return comic.getId();
			case 1: return comic.getName();
			case 2: return comic.getAdquisition_date();
			case 3: 
				Long id = (long)comic.getCollection_id();
				Collection collection = collectionService.findCollectionById(id);
				return collection.getName();
			case 4: return comic.getState();
			case 5: return comic.getNumber();
			default : return "-";
		}
	}

}
