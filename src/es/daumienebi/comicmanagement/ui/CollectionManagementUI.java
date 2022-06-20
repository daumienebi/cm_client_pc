package es.daumienebi.comicmanagement.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.daumienebi.comicmanagement.controllers.CollectionManagementUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
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
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CollectionManagementUI extends JFrame {

	private JPanel contentPane;
	private JTable collectionTable;
	private JTextField txtCollection;
	private JButton CollectionManagementUI_btnEdit;
	private JPanel panel;
	private CollectionManagementUIController controller = new CollectionManagementUIController();
	private ArrayList<Collection> collections = new ArrayList<Collection>();
	
	//To be translated
	public static String CollectionManagementUI_searchOptions = "Busqueda Colección";
	public static JLabel CollectionManagementUI_collection;
	public static String CollectionManagementUI_windowTitle = "Gestión de colecciones";
	public static String UIMessages_noItemSelected = "No hay elemento seleccionado";
	public static String UIMessages_recordDeleted = "Registro eliminado correctamente";
	public static String UIMessages_confirmacion = "Seguro que quieres borrar la colleción ? Se borrarán todos los comics relacionados.";
	public static String UIMessages_recordNotFound = "Registro no encontrado";
	public static String UIMessages_errorDeletingRecord = "Error eliminando el registro";
	
	//static values to obtain the selected table item
	private static int row;
	private	static int column;
	
	public CollectionManagementUI() {
		Inicialize();
		translate();
		setBorder();
		setTitle(CollectionManagementUI_windowTitle);
		loadCollections();
	}
	private void setBorder() {
		panel.setBorder(BorderFactory.createTitledBorder(null, CollectionManagementUI_searchOptions,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18)));

	}
	
	void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CollectionManagementUI.class.getResource("/resources/comic-icon_128.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle(CollectionManagementUI_windowTitle);
		panel = new JPanel();
		panel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		setBorder();
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setMinimumSize(new Dimension(100, 100));
		contentPane.add(panel, BorderLayout.NORTH);
		
		CollectionManagementUI_collection = new JLabel("Colección");
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
					.addComponent(txtCollection, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(239))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(CollectionManagementUI_collection, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCollection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		CollectionManagementUI_btnEdit = new JButton("");
		CollectionManagementUI_btnEdit.setIcon(new ImageIcon(CollectionManagementUI.class.getResource("/resources/icons8-edit-24.png")));
		CollectionManagementUI_btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(collectionTable.getSelectedRow() > -1) {
					editCollection();
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessages_noItemSelected,"",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		CollectionManagementUI_btnEdit.setVisible(false);
		panel_1.add(CollectionManagementUI_btnEdit);
		
		JButton CollectionManagementUI_btnDelete = new JButton("");
		CollectionManagementUI_btnDelete.setIcon(new ImageIcon(CollectionManagementUI.class.getResource("/resources/icons8-waste-24.png")));
		CollectionManagementUI_btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(collectionTable.getSelectedRow() > -1) {
					deleteCollection();
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessages_noItemSelected,"",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		CollectionManagementUI_btnDelete.setVisible(false);
		panel_1.add(CollectionManagementUI_btnDelete);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		collectionTable = new JTable();
		scrollPane.setViewportView(collectionTable);
		collectionTable.setRowHeight(100);
		
		
		buttomBtnActions(CollectionManagementUI_btnEdit, CollectionManagementUI_btnDelete);
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
		            	JOptionPane.showMessageDialog(rootPane, UIMessages_recordNotFound,"",JOptionPane.ERROR_MESSAGE);
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
	}
	
	private int getCollectionId() {
		row = collectionTable.getSelectedRow();
		column = 0;
		int collection_id = Integer.parseInt(collectionTable.getModel().getValueAt(row, column).toString());
		return collection_id;
	}
	
	private void buttomBtnActions(JButton btnEdit,JButton btnDelete) {
		collectionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int fila =collectionTable.getSelectedRow();
				if(fila >-1) {
					btnEdit.setVisible(true);
					btnDelete.setVisible(true);
				}else{
					btnEdit.setVisible(false);
					btnDelete.setVisible(false);
				}
			}
		});
	}
	
	private void editCollection() {
		Long collection_id;
		int response;
		collection_id = (long)getCollectionId();
		Collection collection = controller.getCollection(collection_id);
		System.out.println(collection.toString() + "ole");
		if(collection != null) {
			NewCollectionUI ui = new NewCollectionUI(collection);
			ui.setLocationRelativeTo(getContentPane());
			ui.setModal(true);
			ui.setVisible(true);
			ui.setMinimumSize(Constants.editCollectionMinimumSize);
			CollectionManagementUI_btnEdit.setVisible(false);
			loadCollections();
		}else
			JOptionPane.showMessageDialog(getContentPane(), UIMessages_recordNotFound, "Error", JOptionPane.ERROR_MESSAGE);					
		loadCollections();
	}
	
	private void deleteCollection() {
		Long collection_id;
		int response;
		collection_id = (long)getCollectionId();
		
		response = JOptionPane.showConfirmDialog(null, UIMessages_confirmacion, "", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION) {
			boolean deleted = controller.deleteCollection(collection_id);
			if(deleted) {
				JOptionPane.showMessageDialog(getContentPane(), "Colección eliminada correctamente", "Borrar Registro",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/icons8-ok-40.png")));
				loadCollections();
			}else {
				JOptionPane.showMessageDialog(getContentPane(), UIMessages_errorDeletingRecord, 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void loadCollections() {
		collections = controller.findAllCollections();
		CollectionTableModel tableModel = new CollectionTableModel(collections);
		
		tableModel.translateColumns();
		collectionTable.setModel(tableModel);
		collectionTable.getColumnModel().getColumn(0).setMinWidth(80);
		collectionTable.getColumnModel().getColumn(0).setMaxWidth(80);
		collectionTable.getColumnModel().getColumn(2).setMinWidth(150);
		collectionTable.getColumnModel().getColumn(2).setMaxWidth(200);
	}

	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateCollectionManagementUI(Configuration.app_language);
		}
	}
}
