package es.daumienebi.comicmanagement.tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import es.daumienebi.comicmanagement.models.*;

public class UserTableModel extends AbstractTableModel{
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}

	private ArrayList<User> users;
	private String[] columns = {"ID","NAME","EMAIL","PHONE NUMBER"};
	
	public UserTableModel(ArrayList<User> users) {
		this.users = users;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.users.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		User user = users.get(rowIndex);
		switch(columnIndex){
			case 0 : return user.getId();
			case 1 : return user.getName();
			case 2 : return user.getEmail();
			case 3 : return user.getTelefono();
			default : return "-";
			
		}		
	}

}
