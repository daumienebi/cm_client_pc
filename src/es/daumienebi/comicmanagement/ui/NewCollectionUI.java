package es.daumienebi.comicmanagement.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.daumienebi.comicmanagement.controllers.NewCollectionUIController;
import es.daumienebi.comicmanagement.models.Collection;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class NewCollectionUI extends JDialog {

	//To be translated
	public static JLabel NewCollectionUI_name;
	public static JButton NewCollectionUI_AddCollection;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;

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

	
	
	public NewCollectionUI() {
		Inicialize();
	}
	
	void Inicialize() {
		setTitle("A\u00F1adir nueva colecci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewCollectionUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.WEST);
		
		JLabel lblCollectionImg = new JLabel("");
		//lblCollectionImg.setMargin(new Insets(0, 0, 0, 0));
		lblCollectionImg.setBounds(20,20,300,500);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/deadpool_collection.jpg"));
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
					imageName = imgFile.getName();
				}
			});
			btnAddImage.setIcon(new ImageIcon(NewCollectionUI.class.getResource("/resources/icons8-compact-camera-24.png")));
			buttonPane.add(btnAddImage);
			{
				NewCollectionUI_AddCollection = new JButton("A\u00F1adir Collec\u00F3n");
				NewCollectionUI_AddCollection.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						validateCollection_Add();
					}
				});
				NewCollectionUI_AddCollection.setActionCommand("OK");
				buttonPane.add(NewCollectionUI_AddCollection);
				getRootPane().setDefaultButton(NewCollectionUI_AddCollection);
			}
		}
	}
	
	void validateCollection_Add() {
		String name = txtName.getText();
		collection = new Collection(1000L,name,imageName);
		if(!name.isBlank()) {
			if(imageName != null) {
				collection.setImage(imageName);
				addCollection(collection);
			}else {
				collection.setImage("");
				addCollection(collection);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Porfavor,rellene los campos");
		}
	}
	
	void addCollection(Collection collection){
		//Method to be called internally by validateCollection_Add()
		boolean added = controller.saveCollection(collection);
		if(added) {
			JOptionPane.showMessageDialog(getContentPane(),"The record has been added successfully",""
					,JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}else {
			JOptionPane.showMessageDialog(getContentPane(),"There was an error adding the record","Error",JOptionPane.ERROR_MESSAGE);

		}
	}
}
