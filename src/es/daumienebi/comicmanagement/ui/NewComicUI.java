package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JDialog;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;

import es.daumienebi.comicmanagement.controllers.NewComicUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.utils.TextFieldValidatorUtil;
import es.daumienebi.comicmanagement.utils.Constants.ComicState;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class NewComicUI extends JDialog {
	
	public static JLabel NewComicUI_comicName;
	public static JLabel NewComicUI_comicCollection;
	public static JLabel NewComicUI_comicAdquisitionDate;
	public static JLabel NewComicUI_comicState;
	public static JLabel NewComicUI_comicNumber;
	public static String NewComicUI_windowTitle = "Añadir Nuevo Comic";
	public static String NewComicUI_newComic = "Comic Nuevo";
	public static JButton NewComicUI_btnAddComic;
	public static JButton NewComicUI_btnSaveComic;
	public static String UIMessage_plsFillFields;
	
	
	private JButton btnComicPoster;
	private JPanel dataPanel;
	private JTextField txtName;
	private JTextField txtDay;
	private JTextField txtComicNumber;
	private JTextField txtCollection;
	private DatePicker datePicker;
	private LocalDate selectedDate;
	private JComboBox cmbState;
	
	Comic comic;
	Collection selectedCollection;
	private String imageName = "";
	private File imgFile;
	private String comicState = ComicState.Nuevo.toString();
	
	//Controller
	private NewComicUIController controller = new NewComicUIController();
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewComicUI dialog = new NewComicUI();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewComicUI() {
		Inicialize();
	}
	
	public NewComicUI(Comic comic) {
		//New Instance to edit a comic
		this();
		setDefaultCloseOperation(NewComicUI.DISPOSE_ON_CLOSE);
		this.comic = comic;
		imageName = comic.getImage();
		NewComicUI_btnAddComic.setVisible(false);
		NewComicUI_btnSaveComic.setVisible(true);
		setTitle("Editar comic");
		
		txtName.setText(comic.getName());
		txtComicNumber.setText(String.valueOf(comic.getNumber()));
		//The comic state will not me modified
		cmbState.setEnabled(false);
		selectedDate = comic.getAdquisition_date().toLocalDate();
		datePicker.setDate(selectedDate);
		btnComicPoster.setIcon(controller.getComicsImage(comic.getImage()));
		selectedCollection = controller.getCollection(comic);
		txtCollection.setText(selectedCollection.getName());
	}
	
	void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewComicUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 943, 580);
		setTitle(NewComicUI_windowTitle);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		NewComicUI_btnAddComic = new JButton("A\u00F1adir Comic");
		NewComicUI_btnAddComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateComic_Add();
			}
		});
		panel.add(NewComicUI_btnAddComic);
		
		NewComicUI_btnSaveComic = new JButton("Guardar Comic");
		NewComicUI_btnSaveComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateComic_Edit();
			}
		});
		NewComicUI_btnSaveComic.setVisible(false);
		panel.add(NewComicUI_btnSaveComic);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.WEST);
		
		btnComicPoster = new JButton("");
		btnComicPoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgFile = controller.setImagePoster(btnComicPoster);
				imageName = imgFile.getName();
			}
		});
		btnComicPoster.setBorder(null);
		btnComicPoster.setMargin(new Insets(0, 0, 0, 0));
		btnComicPoster.setBounds(20,20,300,500);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/add_image.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(btnComicPoster.getWidth(),btnComicPoster.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		btnComicPoster.setIcon(icon);
		JButton btnAddComicPoster = new JButton("");
		btnAddComicPoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgFile = controller.setImagePoster(btnComicPoster);
				imageName = imgFile.getName();
			}
		});
		btnAddComicPoster.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddComicPoster.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-compact-camera-40.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(1)
					.addComponent(btnComicPoster)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddComicPoster)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(226)
							.addComponent(btnAddComicPoster))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(21)
							.addComponent(btnComicPoster)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		dataPanel = new JPanel();
		getContentPane().add(dataPanel, BorderLayout.CENTER);
		dataPanel.setBorder(BorderFactory.createTitledBorder(null, NewComicUI_newComic,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblCollection = new JLabel("COLECCI\u00D3N");
		lblCollection.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtDay = new JTextField();
		txtDay.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("FECHA ADQUISICI\u00D3N");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		datePicker =new DatePicker();
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDate = datePicker.getDate();
			}
		});
		datePicker.setDateToToday();
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NUMERO");
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtComicNumber = new JTextField();
		txtComicNumber.setColumns(10);
		
		cmbState = new JComboBox();
		cmbState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comicState = cmbState.getSelectedItem().toString();
			}
		});
		cmbState.setModel(new DefaultComboBoxModel(ComicState.values()));
		
		JButton btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("ESTADO");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtCollection = new JTextField();
		txtCollection.setEditable(false);
		txtCollection.setColumns(10);
		
		JButton btnAddCollection = new JButton("");
		btnAddCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCollectioToComicUI ui = new AddCollectioToComicUI();
				ui.setModal(true);
				ui.setLocationRelativeTo(null);
				ui.setVisible(true);
				selectedCollection = ui.getSelectedCollection();
				if(selectedCollection != null) {
					txtCollection.setText(selectedCollection.getName());
				}
				
			}
		});
		btnAddCollection.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-search-24.png")));
		GroupLayout gl_dataPanel = new GroupLayout(dataPanel);
		gl_dataPanel.setHorizontalGroup(
			gl_dataPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dataPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
											.addComponent(lblCollection, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
										.addGap(39))
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(txtCollection, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnAddCollection, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addComponent(cmbState, 0, 312, Short.MAX_VALUE))))
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))))
					.addGap(0))
		);
		gl_dataPanel.setVerticalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtCollection, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAddCollection))
						.addComponent(lblCollection))
					.addGap(43)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_1_1))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_1_1_1))
						.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(35)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		dataPanel.setLayout(gl_dataPanel);
	}

	private void validateComic_Add() {
		String name = txtName.getText().trim();
		int collectionId = 0,number = 0;
		if(selectedDate == null) {
			selectedDate = LocalDate.now();
		}
		//selectedDate = datePicker.getDate();
		boolean uploaded = false;
		
		if(TextFieldValidatorUtil.isNumeric(txtComicNumber.getText().trim())) {
			number = Integer.parseInt(txtComicNumber.getText().trim());
		}
		//add onKeyreleased method for the comic number to be > 0
		if(!name.isBlank() && number > 0 && selectedCollection != null) {
			collectionId = Integer.valueOf(selectedCollection.getId().toString());
			comic = new Comic(name,Date.valueOf(selectedDate),imageName,collectionId,comicState,number);
			if(!imageName.isBlank()) {
				comic.setImage(imageName);
				addComic(comic);
			}else {
				comic.setImage("");
				addComic(comic);
			}
		}else {
			JOptionPane.showMessageDialog(getContentPane(),"Por favor, rellene los campos correctamente","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void addComic(Comic comic) {
		//to be called internally by validateComic_Add()
		boolean added = controller.saveComic(comic);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),"El registro ha sido añadido correctamente",""
					,JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),"Error añadiendo el registro","Error",JOptionPane.ERROR_MESSAGE);

		}
	}
	
	private void validateComic_Edit() {
		String name = txtName.getText().trim();
		int collectionId = 0,number = 0;
		if(selectedDate == null) {
			selectedDate = LocalDate.now();
		}
		//selectedDate = datePicker.getDate();
		boolean uploaded = false;
		
		if(TextFieldValidatorUtil.isNumeric(txtComicNumber.getText().trim())) {
			number = Integer.parseInt(txtComicNumber.getText().trim());
		}
		//add onKeyreleased method for the comic number to be > 0
		if(!name.isBlank() && number > 0 && selectedCollection != null) {
			collectionId = Integer.valueOf(selectedCollection.getId().toString());
			//comic = new Comic(name,Date.valueOf(selectedDate),imageName,collectionId,comicState,number); -lmao
			if(!imageName.isBlank()) {
				comic.setImage(imageName);
				editComic(comic, name, collectionId, number);
			}else {
				comic.setImage("");
				editComic(comic, name, collectionId, number);
			}
		}else {
			JOptionPane.showMessageDialog(getContentPane(),"Por favor, rellene los campos correctamente","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void editComic(Comic comic,String name, int collectionId,int number) {
		//to be called internally by validateComic_Edit()
		comic.setName(name);
		comic.setCollection_id(collectionId);
		comic.setAdquisition_date(Date.valueOf(selectedDate));
		comic.setImage(imageName);
		comic.setNumber(number);
		boolean added = controller.updateComic(comic);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),"El registro ha sido añadido correctamente",""
					,JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),"Error añadiendo el registro","Error",JOptionPane.ERROR_MESSAGE);

		}
		
	}
	
	private void clear() {
		txtName.setText("");
		txtCollection.setText("");
		cmbState.setSelectedItem(ComicState.Nuevo);
		txtComicNumber.setText("");
	}
}
