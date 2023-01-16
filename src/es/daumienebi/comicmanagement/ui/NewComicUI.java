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
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.TextFieldValidatorUtil;
import es.daumienebi.comicmanagement.utils.Translator;
import es.daumienebi.comicmanagement.utils.Constants.ComicState;
import es.daumienebi.comicmanagement.utils.UploadImageUtil;


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
	public static String NewComicUI_newComic = "Comic";
	public static JButton NewComicUI_btnAddComic;
	public static JButton NewComicUI_btnSaveComic;
	public static String UIMessage_plsFillFields = "Por favor, rellene los campos correctamente";
	public static String UIMessage_recordAdded = "Registro añadido correctamente";
	public static String UIMessage_recordSaved= "Registro guardado correctamente";
	public static String UIMessage_errorAddingRecord= "Error guardando el registro";
	public static String UIMessage_errorSubirImagen = "Error subiendo la imagen al servidor";
	
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

	public NewComicUI() {
		Inicialize();
		translate();
		setTitle(NewComicUI_windowTitle);
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
		datePicker.getComponentToggleCalendarButton().setEnabled(true);
	}
	
	void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewComicUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 943, 580);
		setTitle(NewComicUI_windowTitle);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		NewComicUI_btnAddComic = new JButton("A\u00F1adir Comic");
		NewComicUI_btnAddComic.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-plus-math-24.png")));
		NewComicUI_btnAddComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateComic_Add();
			}
		});
		panel.add(NewComicUI_btnAddComic);
		
		NewComicUI_btnSaveComic = new JButton("Guardar Comic");
		NewComicUI_btnSaveComic.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-save-24.png")));
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
				if(imgFile != null) {
					imageName = imgFile.getName();
				}
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
				if(imgFile != null) {
					imageName = imgFile.getName();
				}
				
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
		
		NewComicUI_comicName = new JLabel("NOMBRE");
		NewComicUI_comicName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(10);
		
		NewComicUI_comicCollection = new JLabel("COLECCI\u00D3N");
		NewComicUI_comicCollection.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtDay = new JTextField();
		txtDay.setColumns(10);
		
		NewComicUI_comicAdquisitionDate = new JLabel("FECHA ADQUISICI\u00D3N");
		NewComicUI_comicAdquisitionDate.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		datePicker =new DatePicker();
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDate = datePicker.getDate();
			}
		});
		datePicker.setDateToToday();
		
		NewComicUI_comicNumber = new JLabel("NUMERO");
		NewComicUI_comicNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtComicNumber = new JTextField();
		txtComicNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtComicNumber.setColumns(10);
		
		cmbState = new JComboBox();
		cmbState.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comicState = cmbState.getSelectedItem().toString();
			}
		});
		cmbState.setModel(new DefaultComboBoxModel(ComicState.values()));
		
		JButton btnClear = new JButton("Limpiar");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		NewComicUI_comicState = new JLabel("ESTADO");
		NewComicUI_comicState.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
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
				if(ui.getSelectedCollection() != null) {
					selectedCollection = ui.getSelectedCollection();
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
									.addComponent(NewComicUI_comicState)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(NewComicUI_comicName)
											.addComponent(NewComicUI_comicAdquisitionDate, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
											.addComponent(NewComicUI_comicCollection, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
										.addGap(39))
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(NewComicUI_comicNumber, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(txtCollection, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnAddCollection, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
									.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cmbState, 0, 315, Short.MAX_VALUE)))
								.addGroup(gl_dataPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))))
					.addGap(0))
		);
		gl_dataPanel.setVerticalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(NewComicUI_comicName))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtCollection, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAddCollection))
						.addComponent(NewComicUI_comicCollection))
					.addGap(43)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(11)
							.addComponent(NewComicUI_comicAdquisitionDate))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(NewComicUI_comicNumber))
						.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(NewComicUI_comicState)
						.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		dataPanel.setLayout(gl_dataPanel);
	}

	private void validateComic_Add() {
		String name = txtName.getText().trim();
		int collectionId = 0,number = 0;
		if(selectedDate == null) {
			selectedDate = LocalDate.now();
		}
		if(TextFieldValidatorUtil.isNumeric(txtComicNumber.getText().trim())) {
			number = Integer.parseInt(txtComicNumber.getText().trim());
		}
		//add onKeyreleased method for the comic number to be > 0
		if(!name.isEmpty() && number > 0 && selectedCollection != null) {
			collectionId = Integer.valueOf(selectedCollection.getId().toString());
			comic = new Comic(name,Date.valueOf(selectedDate),imageName,collectionId,comicState,number);
			//upload the image to the server
			Object [] uploadResult = new Object[2];
			if(imgFile != null) {
				uploadResult = UploadImageUtil.uploadComicImage(imgFile);
				boolean uploaded = Boolean.parseBoolean(uploadResult[0].toString());
				imageName = uploadResult[1].toString();
				if(uploaded) {
					comic.setImage(imageName);
					addComic(comic);
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorSubirImagen,"Error",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				comic.setImage("");
				addComic(comic);
			}
		}else {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_plsFillFields,"",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void addComic(Comic comic) {
		//to be called internally by validateComic_Add()
		boolean added = controller.saveComic(comic);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_recordSaved,""
					,JOptionPane.INFORMATION_MESSAGE,new ImageIcon(NewComicUI.class.getResource("/resources/icons8-ok-40.png")));
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorAddingRecord,"Error",JOptionPane.ERROR_MESSAGE);

		}
	}
	
	private void validateComic_Edit() {
		boolean uploaded = false;
		String name = txtName.getText().trim();
		int collectionId = 0,number = 0;
		//if(selectedDate == null) {
			//selectedDate = LocalDate.now();
		//}
		//selectedDate = datePicker.getDate();
		Date date = Date.valueOf(datePicker.getDateStringOrEmptyString());
		
		if(TextFieldValidatorUtil.isNumeric(txtComicNumber.getText().trim())) {
			number = Integer.parseInt(txtComicNumber.getText().trim());
		}
		//add onKeyreleased method for the comic number to be > 0
		if(!name.isEmpty() && number > 0 && selectedCollection != null && date != null) {
			collectionId = Integer.valueOf(selectedCollection.getId().toString());
			//comic = new Comic(name,Date.valueOf(selectedDate),imageName,collectionId,comicState,number); -lmao
			if(imgFile != null) {
				Object [] uploadResult = new Object[2];
				uploadResult = UploadImageUtil.uploadComicImage(imgFile);
				uploaded = Boolean.parseBoolean(uploadResult[0].toString());
				imageName = uploadResult[1].toString();
				if(uploaded) {
					editComic(comic, name, collectionId, number,date);
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorSubirImagen,"Error",JOptionPane.ERROR_MESSAGE);
				}	
			}else {
				imageName = comic.getImage();
				editComic(comic, name, collectionId, number,date);
			}
		}else {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_plsFillFields,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void editComic(Comic comic,String name, int collectionId,int number,Date date) {
		//to be called internally by validateComic_Edit()
		comic.setName(name);
		comic.setCollection_id(collectionId);
		comic.setAdquisition_date(date);
		//comic.setAdquisition_date(Date.valueOf(datePicker.getText()));
		comic.setImage(imageName);
		comic.setNumber(number);
		boolean added = controller.updateComic(comic);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_recordSaved,""
					,JOptionPane.INFORMATION_MESSAGE,new ImageIcon(NewComicUI.class.getResource("/resources/icons8-ok-40.png")));
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorAddingRecord,"Error",JOptionPane.ERROR_MESSAGE);

		}
		
	}
	
	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateNewComicUI(Configuration.app_language);
		}
	}
	
	private void clear() {
		txtName.setText("");
		txtCollection.setText("");
		cmbState.setSelectedItem(ComicState.Nuevo);
		txtComicNumber.setText("");
		datePicker.setDate(LocalDate.now());
		System.out.println("Width =" + this.WIDTH + "Height= " + this.HEIGHT);
	}
}
