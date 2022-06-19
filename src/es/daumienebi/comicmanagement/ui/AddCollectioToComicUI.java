package es.daumienebi.comicmanagement.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import es.daumienebi.comicmanagement.controllers.CollectionManagementUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.tablemodels.CollectionTableModel;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Constants;
import es.daumienebi.comicmanagement.utils.Translator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AddCollectioToComicUI extends JDialog {

	private JPanel contentPane;
	
	public static String CollectionManagementUI_searchOptions = "Busqueda Colección";
	public static JButton AddCollectioToComicUI_btnAdd;
	
	private JTable collectionTable;
	private JTextField txtCollection;
	
	private CollectionManagementUIController controller = new CollectionManagementUIController();
	private ArrayList<Collection> collections = new ArrayList<Collection>();
	private Collection selectedCollection;
	
	//static values to obtain the selected table item
	private static int row;
	private	static int column;
	
	public AddCollectioToComicUI() {
		setResizable(false);
		Inicialize();
		translate();
		loadCollections();
	}
		
	void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddCollectioToComicUI.class.getResource("/resources/comic-icon_128.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 150, 122));
		panel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panel.setBorder(BorderFactory.createTitledBorder(null, CollectionManagementUI_searchOptions,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18)));
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setMinimumSize(new Dimension(100, 100));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel CollectionManagementUI_collection = new JLabel("Colecci\u00F3n");
		CollectionManagementUI_collection.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtCollection = new JTextField();
		txtCollection.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				CollectionTableModel tableModel = new CollectionTableModel(controller.fliterCollection(txtCollection.getText()));
				collectionTable.setModel(tableModel);
			}
		});
		txtCollection.setMinimumSize(new Dimension(100, 100));
		txtCollection.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(CollectionManagementUI_collection, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(txtCollection, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(CollectionManagementUI_collection, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCollection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		AddCollectioToComicUI_btnAdd = new JButton("");
		AddCollectioToComicUI_btnAdd.setIcon(new ImageIcon(AddCollectioToComicUI.class.getResource("/resources/icons8-checked-checkbox-24.png")));
		AddCollectioToComicUI_btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long collection_id;
				collection_id = (long)getCollectionId();
				selectedCollection = controller.getCollection(collection_id);
				dispose();
			}
			
		});
		AddCollectioToComicUI_btnAdd.setVisible(false);
		panel_1.add(AddCollectioToComicUI_btnAdd);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		collectionTable = new JTable();
		scrollPane.setViewportView(collectionTable);
		collectionTable.setRowHeight(100);
		tableDoubleClick(collectionTable);
	}
	
	private void tableDoubleClick(JTable table) {
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            Long id = Long.valueOf(table.getModel().getValueAt(row, 0).toString());
		            Collection collection = controller.getCollection(id);
		            if(collection == null) {
		            	JOptionPane.showMessageDialog(rootPane, "Collection not found","Record not found",JOptionPane.ERROR_MESSAGE);
		            	loadCollections(); //sikee
		            }else {
		            	CollectionDetailsUI ui = new CollectionDetailsUI(collection);
		            	ui.setLocationRelativeTo(getContentPane());
		            	ui.setMinimumSize(Constants.collectionDetailsUIMinimumSize);
		            	ui.setVisible(true);
		            }
		        }
		    }
		});
		buttomBtnActions(AddCollectioToComicUI_btnAdd);
	}
	
	private int getCollectionId() {
		row = collectionTable.getSelectedRow();
		column = 0;
		int collection_id = Integer.parseInt(collectionTable.getModel().getValueAt(row, column).toString());
		return collection_id;
	}
	
	private void buttomBtnActions(JButton btnAddCollection) {
		collectionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int fila =collectionTable.getSelectedRow();
				if(fila >-1) {
					btnAddCollection.setVisible(true);
				}else{
					btnAddCollection.setVisible(false);
				}
			}
		});
	}
	
	private void loadCollections() {
		collections = controller.findAllCollections();
		CollectionTableModel tableModel = new CollectionTableModel(collections);
		
		tableModel.translateColumns();
		collectionTable.setModel(tableModel);
		collectionTable.getColumnModel().getColumn(2).setMinWidth(150);
		collectionTable.getColumnModel().getColumn(2).setMaxWidth(200);
	}
	
	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateCollectionManagementUI(Configuration.app_language);
		}
	}
	
	public Collection getSelectedCollection(){
		return this.selectedCollection;
}
}
