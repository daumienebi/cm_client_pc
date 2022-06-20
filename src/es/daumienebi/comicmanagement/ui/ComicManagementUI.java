package es.daumienebi.comicmanagement.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.daumienebi.comicmanagement.controllers.ComicManagementUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.services.IComicService;
import es.daumienebi.comicmanagement.services.impl.ComicService;
import es.daumienebi.comicmanagement.tablemodels.CollectionTableModel;
import es.daumienebi.comicmanagement.tablemodels.ComicTableModel;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Constants;
import es.daumienebi.comicmanagement.utils.Translator;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import es.daumienebi.comicmanagement.utils.Constants.ComicSearchFilter;

public class ComicManagementUI extends JFrame {

	//To be translated
	public static String ComicManagementUI_searchOptions = "Busqueda Comics";
	public static String ComicManagementUI_windowTitle = "Gestión de comics";
	public static JLabel ComicManagementUI_name;
	public static String UIMessages_error;
	public static String UIMessages_warning;
	public static String UIMessages_info;
	public static JLabel ComicManagementUI_filter;
	public static JPanel searchPanel;
	public static String UIMessages_noItemSelected = "No hay elemento seleccionado";
	public static String UIMessages_recordDeleted = "Registro eliminado correctamente";
	public static String UIMessages_confirmacion = "Seguro que quieres borrar la colleción ? Se borrarán todos los comics relacionados.";
	public static String UIMessages_recordNotFound = "Registro no encontrado";
	public static String UIMessages_errorDeletingRecord = "Error eliminando el registro";
	
	
	private JButton ComicManagementUI_btnEdit;
	private JPanel contentPane;
	private JTextField txtBusqueda;
	private JPanel dataPanel;
	private JTable comicsTable;
	private ArrayList<Comic> comics = new ArrayList<Comic>();
	JComboBox cmbFilter;
	
	ComicSearchFilter filter = ComicSearchFilter.Comic;
	private static int row;
	private	static int column;
	ComicManagementUIController controller = new ComicManagementUIController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComicManagementUI frame = new ComicManagementUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ComicManagementUI() {
		Inicialize();
		translate();
		setBorder();
		setTitle(ComicManagementUI_windowTitle);
		loadComicsTable();
	}
	
	void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComicManagementUI.class.getResource("/resources/comic-icon_128.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(ComicManagementUI_windowTitle);
		setBounds(100, 100, 853, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ComicManagementUI_btnEdit = new JButton("");
		ComicManagementUI_btnEdit.setVisible(false);
		ComicManagementUI_btnEdit.setIcon(new ImageIcon(ComicManagementUI.class.getResource("/resources/icons8-edit-24.png")));
		ComicManagementUI_btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comicsTable.getSelectedRow() > -1) {
					editComic();
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessages_noItemSelected,"",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		panel.add(ComicManagementUI_btnEdit);
		
		JButton ComicManagementUI_btnDelete = new JButton("");
		ComicManagementUI_btnDelete.setVisible(false);
		ComicManagementUI_btnDelete.setIcon(new ImageIcon(ComicManagementUI.class.getResource("/resources/icons8-waste-24.png")));
		ComicManagementUI_btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comicsTable.getSelectedRow() > -1) {
					deleteComic();
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessages_noItemSelected,"",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		panel.add(ComicManagementUI_btnDelete);
		ImageIcon img = new ImageIcon(HomeUI.class.getResource("/resources/sideImg.png"));
		
		dataPanel = new JPanel();
		contentPane.add(dataPanel, BorderLayout.CENTER);
		dataPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		dataPanel.add(scrollPane, BorderLayout.CENTER);
		
		comicsTable = new JTable();
		comicsTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comicsTable.setRowHeight(40);
		scrollPane.setViewportView(comicsTable);
		
		searchPanel = new JPanel();
		searchPanel.setBackground(new Color(205, 92, 92));
		searchPanel.setPreferredSize(new Dimension(0, 120));
		searchPanel.setMinimumSize(new Dimension(100, 100));
		contentPane.add(searchPanel, BorderLayout.NORTH);
		
		ComicManagementUI_name = new JLabel("Nombre");
		ComicManagementUI_name.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtBusqueda = new JTextField();
		txtBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(filter == ComicSearchFilter.Comic) {
					ComicTableModel tableModel = new ComicTableModel(controller.filterComic(txtBusqueda.getText()));
					comicsTable.setModel(tableModel);
				}else {
					//filter by collection name
				}
				
			}
		});
		txtBusqueda.setColumns(10);
		
		cmbFilter = new JComboBox();
		cmbFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter = (ComicSearchFilter)cmbFilter.getSelectedItem();
			}
		});
		cmbFilter.setModel(new DefaultComboBoxModel(ComicSearchFilter.values()));
		
		ComicManagementUI_filter = new JLabel("Filtro");
		ComicManagementUI_filter.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
		gl_searchPanel.setHorizontalGroup(
			gl_searchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPanel.createSequentialGroup()
					.addGap(19)
					.addComponent(ComicManagementUI_name, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(txtBusqueda, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(ComicManagementUI_filter, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(cmbFilter, 0, 104, Short.MAX_VALUE))
		);
		gl_searchPanel.setVerticalGroup(
			gl_searchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ComicManagementUI_name, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBusqueda, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(ComicManagementUI_filter)
						.addComponent(cmbFilter, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		searchPanel.setLayout(gl_searchPanel);
		searchPanel.setBorder(BorderFactory.createTitledBorder(null, ComicManagementUI_searchOptions,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18)));

		buttomBtnActions(ComicManagementUI_btnEdit, ComicManagementUI_btnDelete);
		tableDoubleClick(comicsTable);
	}
	
	private void setBorder() {
		searchPanel.setBorder(BorderFactory.createTitledBorder(null, ComicManagementUI_searchOptions,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18)));

	}
	
	private void loadComicsTable() {
		comics = controller.findAllComics();
		ComicTableModel tableModel = new ComicTableModel(comics);
		tableModel.translateColumns();
		comicsTable.setModel(tableModel);
		//table.removeColumn(table.getColumnModel().getColumn(0));
	}

	private void tableDoubleClick(JTable table) {
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            Long id = Long.valueOf(table.getModel().getValueAt(row, 0).toString());
		            Comic comic = controller.getComic(id);
		            if(comic == null) {
		            	JOptionPane.showMessageDialog(table, UIMessages_recordNotFound,"",JOptionPane.ERROR_MESSAGE);
		            }else {
		            	ComicDetailsUI ui = new ComicDetailsUI(comic);
		            	ui.setLocationRelativeTo(getContentPane());
		            	ui.setMinimumSize(Constants.comicDetailsMinimumSize);
		            	ui.setVisible(true);
		            }
		        }
		    }
		});
	}
	
	private int getComicId() {
		row = comicsTable.getSelectedRow();
		column = 0;
		int comicId = Integer.parseInt(comicsTable.getModel().getValueAt(row, column).toString());
		return comicId;
	}
	
	private void buttomBtnActions(JButton btnEdit,JButton btnDelete) {
		comicsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int fila =comicsTable.getSelectedRow();
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
	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateComicManagementUI(Configuration.app_language);
		}
	}
	
	private void editComic() {
		int comicId = getComicId();
		Comic comic = controller.getComic((long)comicId);
		System.out.println(comic.toString() + "ole");
		if(comic != null) {
			NewComicUI ui = new NewComicUI(comic);
			ui.setLocationRelativeTo(getContentPane());
			ui.setModal(true);
			ui.setVisible(true);
			ui.setMinimumSize(Constants.editComicMinimumSize);
			ComicManagementUI_btnEdit.setVisible(false);
			loadComicsTable();
		}else
			JOptionPane.showMessageDialog(getContentPane(), UIMessages_recordNotFound, "", JOptionPane.ERROR_MESSAGE);					
		loadComicsTable();
	}
	
	private void deleteComic() {
		Long comicId;
		int response;
		comicId = (long)getComicId();
		
		response = JOptionPane.showConfirmDialog(null, UIMessages_confirmacion, "", JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION) {
			boolean deleted = controller.deleteComic(comicId);
			if(deleted) {
				JOptionPane.showMessageDialog(getContentPane(), UIMessages_recordDeleted, "",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/resources/icons8-ok-40.png")));
				loadComicsTable();
			}else {
				JOptionPane.showMessageDialog(getContentPane(), UIMessages_errorDeletingRecord, 
						"", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
