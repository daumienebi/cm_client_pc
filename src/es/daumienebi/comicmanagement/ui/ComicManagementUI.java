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
import es.daumienebi.comicmanagement.tablemodels.ComicTableModel;
import es.daumienebi.comicmanagement.utils.Constants;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

public class ComicManagementUI extends JFrame {

	//To be translated
	public static String ComicManagementUI_searchOptions = "Busqueda Comic";
	public static String ComicManagementUI_windowTitle = "Gestión de comics";
	
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCollection;
	private JPanel dataPanel;
	private JTable comicsTable;
	private ArrayList<Comic> comics = new ArrayList<Comic>();
	
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
		
		JButton ComicManagementUI_btnEdit = new JButton("Editar Comic");
		panel.add(ComicManagementUI_btnEdit);
		
		JButton ComicManagementUI_btnDelete = new JButton("Borrar Comic");
		panel.add(ComicManagementUI_btnDelete);
		ImageIcon img = new ImageIcon(HomeUI.class.getResource("/resources/sideImg.png"));
		
		dataPanel = new JPanel();
		contentPane.add(dataPanel, BorderLayout.CENTER);
		dataPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		dataPanel.add(scrollPane, BorderLayout.CENTER);
		
		comicsTable = new JTable();
		comicsTable.setRowHeight(40);
		scrollPane.setViewportView(comicsTable);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(240, 230, 140));
		searchPanel.setPreferredSize(new Dimension(0, 120));
		searchPanel.setMinimumSize(new Dimension(100, 100));
		contentPane.add(searchPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Collecci\u00F3n");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		txtCollection = new JTextField();
		txtCollection.setColumns(10);
		
		JButton ComicManagementUI_btnSearch = new JButton("Buscar");
		GroupLayout gl_searchPanel = new GroupLayout(searchPanel);
		gl_searchPanel.setHorizontalGroup(
			gl_searchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCollection, 355, 355, 355))
					.addPreferredGap(ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
					.addComponent(ComicManagementUI_btnSearch, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		gl_searchPanel.setVerticalGroup(
			gl_searchPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchPanel.createSequentialGroup()
					.addGroup(gl_searchPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchPanel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_searchPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCollection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_searchPanel.createSequentialGroup()
							.addGap(22)
							.addComponent(ComicManagementUI_btnSearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		searchPanel.setLayout(gl_searchPanel);
		searchPanel.setBorder(BorderFactory.createTitledBorder(null, ComicManagementUI_searchOptions,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18)));

		buttomBtnActions(ComicManagementUI_btnEdit, ComicManagementUI_btnDelete);
		tableDoubleClick(comicsTable);
	}
	
	
	private void loadComicsTable() {
		comics = controller.findAllComics();
		ComicTableModel tableModel = new ComicTableModel(comics);
		//tableModel.translateColumns();
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
		            	JOptionPane.showMessageDialog(table, "Comic not found","Data not found",JOptionPane.ERROR_MESSAGE);
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

}
