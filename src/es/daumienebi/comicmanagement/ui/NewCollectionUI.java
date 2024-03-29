package es.daumienebi.comicmanagement.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.daumienebi.comicmanagement.controllers.NewCollectionUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Translator;
import es.daumienebi.comicmanagement.utils.UploadImageUtil;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class NewCollectionUI extends JDialog {

	//To be translated
	public static JLabel NewCollectionUI_name;
	public static JButton NewCollectionUI_AddCollection;
	public static JButton NewCollectionUI_SaveCollection;
	public static String NewCollectionUI_windowTitle = "A�adir una nueva colecci�n";
	public static String NewCollectionUI_windowTitleEdit = "Editar la colecci�n";
	public static String UIMessage_plsFillFields = "Por favor, rellene los campos correctamente";
	public static String UIMessage_recordAdded = "Registro a�adido correctamente";
	public static String UIMessage_recordSaved= "Registro guardado correctamente";
	public static String UIMessage_errorAddingRecord= "Error guardando el registro";
	public static String UIMessage_errorSubirImagen = "Error subiendo la imagen al servidor";
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JLabel lblCollectionImg;
	Collection collection;
	private String imageName = "";
	private File imgFile;
	
	private NewCollectionUIController controller = new NewCollectionUIController();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewCollectionUI dialog = new NewCollectionUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public NewCollectionUI(Collection collection) {
		//New Instance to edit a collection
		this();
		setDefaultCloseOperation(NewComicUI.DISPOSE_ON_CLOSE);
		this.collection = collection;
		imageName = collection.getImage();
		NewCollectionUI_AddCollection.setVisible(false);
		NewCollectionUI_SaveCollection.setVisible(true);
		setTitle(NewCollectionUI_windowTitleEdit);
		txtName.setText(collection.getName());
		lblCollectionImg.setIcon(controller.getCollectionsImage(collection.getImage(),false));
	}
	
	public NewCollectionUI() {
		Inicialize();
		translate();
		setTitle(NewCollectionUI_windowTitle);
	}
	
	private void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewCollectionUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setTitle(NewCollectionUI_windowTitle);
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.WEST);
		
		lblCollectionImg = new JLabel("");
		//lblCollectionImg.setMargin(new Insets(0, 0, 0, 0));
		lblCollectionImg.setBounds(20,20,300,500);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/add_image.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(lblCollectionImg.getWidth(),lblCollectionImg.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		panel.setLayout(new BorderLayout(0, 0));
		lblCollectionImg.setIcon(icon);
		panel.add(lblCollectionImg);
		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1, BorderLayout.CENTER);
		
		NewCollectionUI_name = new JLabel("Nombre");
		NewCollectionUI_name.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(NewCollectionUI_name)
					.addGap(28)
					.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(NewCollectionUI_name, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(279, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnAddImage = new JButton("");
			btnAddImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					imgFile = controller.setImagePoster(lblCollectionImg);
					if(imgFile != null) {
						imageName = imgFile.getName();
					}
				}
			});
			btnAddImage.setIcon(new ImageIcon(NewCollectionUI.class.getResource("/resources/icons8-compact-camera-24.png")));
			buttonPane.add(btnAddImage);
			{
				NewCollectionUI_AddCollection = new JButton("A\u00F1adir Collec\u00F3n");
				NewCollectionUI_AddCollection.setIcon(new ImageIcon(NewCollectionUI.class.getResource("/resources/icons8-plus-math-24.png")));
				NewCollectionUI_AddCollection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						validateCollection_Add();
					}
				});
				NewCollectionUI_AddCollection.setActionCommand("OK");
				buttonPane.add(NewCollectionUI_AddCollection);
				getRootPane().setDefaultButton(NewCollectionUI_AddCollection);
			}
			
			NewCollectionUI_SaveCollection = new JButton("Guardar Colecci\u00F3n");
			NewCollectionUI_SaveCollection.setIcon(new ImageIcon(NewCollectionUI.class.getResource("/resources/icons8-save-24.png")));
			NewCollectionUI_SaveCollection.setVisible(false);
			NewCollectionUI_SaveCollection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validateCollection_Edit();
				}
			});
			buttonPane.add(NewCollectionUI_SaveCollection);
		}
	}
	
	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateNewCollectionUI(Configuration.app_language);
		}
	}
	
	private void validateCollection_Add() {
		String name = txtName.getText();
		collection = new Collection(name,imageName);
		//upload the image to the server
		Object [] uploadResult = new Object[2];
		if(!name.isEmpty()) {
			if(imgFile != null) {
				uploadResult = UploadImageUtil.uploadCollectionImage(imgFile);
				boolean uploaded = Boolean.parseBoolean(uploadResult[0].toString());
				imageName = uploadResult[1].toString();
				if(uploaded) {
					collection.setImage(imageName);
					addCollection(collection);
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorSubirImagen,"Error",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				collection.setImage("");
				addCollection(collection);
			}
		}else {
			JOptionPane.showMessageDialog(null, UIMessage_plsFillFields);
		}
	}
	
	private void addCollection(Collection collection){
		//Method to be called internally by validateCollection_Add()
		boolean added = controller.saveCollection(collection);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_recordSaved,""
					,JOptionPane.INFORMATION_MESSAGE,new ImageIcon(NewComicUI.class.getResource("/resources/icons8-ok-40.png")));
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorAddingRecord,"Error",JOptionPane.ERROR_MESSAGE);

		}
	}
	
	private void validateCollection_Edit() {
		String name = txtName.getText();
		boolean uploaded = false;
		if(!name.isEmpty()) {
			if(imgFile!= null) {
				Object [] uploadResult = new Object[2];
				uploadResult = UploadImageUtil.uploadCollectionImage(imgFile);
				uploaded = Boolean.parseBoolean(uploadResult[0].toString());
				imageName = uploadResult[1].toString();
				if(uploaded) {
					editCollection(collection,name);
				}else {
					JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorSubirImagen,"Error",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				imageName = collection.getImage();
				editCollection(collection,name);
				System.out.println(collection.toString());
			}
		}else {
			JOptionPane.showMessageDialog(null, UIMessage_plsFillFields);
		}
	}
	
	private void editCollection(Collection collection,String name) {
		collection.setName(name);
		collection.setImage(imageName);
		boolean added = controller.updateCollection(collection);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_recordSaved,""
					,JOptionPane.INFORMATION_MESSAGE,new ImageIcon(NewComicUI.class.getResource("/resources/icons8-ok-40.png")));
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),UIMessage_errorAddingRecord,"Error",JOptionPane.ERROR_MESSAGE);

		}
	}

	
}
