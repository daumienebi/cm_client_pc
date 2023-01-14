package es.daumienebi.comicmanagement.ui;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import es.daumienebi.comicmanagement.controllers.CollectionDetailsUIController;
import es.daumienebi.comicmanagement.models.Collection;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Translator;

public class CollectionDetailsUI extends JDialog {
	private JTextField txtName;
	private JLabel lblImg;
	private CollectionDetailsUIController controller = new CollectionDetailsUIController();
	public static JLabel CollectionDetailsUI_name;
	
	
	public CollectionDetailsUI(Collection collection) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		Inicialize(collection);
		translate();
	}
	
	void Inicialize(Collection collection) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CollectionDetailsUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 700, 600);
		setTitle(collection.getName());
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(20,20,300,500);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/deadpool_collection.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		panel.setLayout(new BorderLayout(0, 0));
		lblImg.setIcon(icon);
		panel.add(lblImg);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		CollectionDetailsUI_name = new JLabel("Nombre");
		CollectionDetailsUI_name.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addComponent(CollectionDetailsUI_name, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(CollectionDetailsUI_name, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(472, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		setValues(collection);
	}
	
	void setValues(Collection collection) {
		txtName.setText(collection.getName());
		lblImg.setIcon(controller.getCollectionsImage(collection.getImage(),false));
		
	}
	
	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateCollectionDetailsUI(Configuration.app_language);
		}
	}
}
