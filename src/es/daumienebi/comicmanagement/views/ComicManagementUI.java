package es.daumienebi.comicmanagement.views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import es.daumienebi.comicmanagement.models.*;
import es.daumienebi.comicmanagement.services.impl.ComicService;

import java.util.ArrayList;

import es.daumienebi.comicmanagement.tablemodels.UserTableModel;

public class ComicManagementUI extends JDialog {
	private JTable tableComics;
	ArrayList<User> users = new ArrayList<User>();
	ComicService comicService = new ComicService();

	/**
	 * Create the dialog.
	 */
	public ComicManagementUI() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tableComics = new JTable();
		scrollPane.setViewportView(tableComics);
		users = comicService.getAllUsers();
		UserTableModel tableModel = new UserTableModel(users);
		tableComics.setModel(tableModel);
	}

}
