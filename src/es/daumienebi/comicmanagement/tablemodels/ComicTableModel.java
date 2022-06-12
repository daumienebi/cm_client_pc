package es.daumienebi.comicmanagement.tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import es.daumienebi.comicmanagement.models.Comic;

public class ComicTableModel extends AbstractTableModel{

	private ArrayList<Comic> comics;
	private String[] columns = {"ID","NOMBRE","FECHA ADQUISICIÓN","COLECCIÓN","ESTADO","NUMERO"};
	
	public ComicTableModel(ArrayList<Comic> comics) {
		this.comics = comics;
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
			case 3: return comic.getCollection_id();
			case 4: return comic.getState();
			case 5: return comic.getNumber();
			default : return "-";
		}
	}

}
