package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;

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
import java.lang.ModuleLayer.Controller;

import javax.swing.SwingConstants;

import es.daumienebi.comicmanagement.controllers.CollectionDetailsUIController;
import es.daumienebi.comicmanagement.models.Collection;

public class CollectionDetailsUI extends JDialog {
	private JTextField txtName;
	private JTextField txtComicCount;
	private JLabel lblImg;
	private CollectionDetailsUIController controller = new CollectionDetailsUIController();
	/**
	 * Launch the application.
	 */

	public CollectionDetailsUI(Collection collection) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		Inicialize(collection);
	}
	
	void Inicialize(Collection collection) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CollectionDetailsUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 700, 600);
		
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
		
		JLabel CollectionDetailsUI_name = new JLabel("Nombre");
		CollectionDetailsUI_name.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		JLabel CollectionDetailsUI_count = new JLabel("Numero de comics");
		CollectionDetailsUI_count.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		
		txtComicCount = new JTextField();
		txtComicCount.setEditable(false);
		txtComicCount.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(CollectionDetailsUI_count, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addComponent(CollectionDetailsUI_name, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
							.addGap(21))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(txtComicCount, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtComicCount, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(CollectionDetailsUI_name, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(CollectionDetailsUI_count, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(186, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		setValues(collection);
	}
	
	void setValues(Collection collection) {
		txtName.setText(collection.getName());
		txtComicCount.setText("5");
		lblImg.setIcon(controller.getCollectionsImage(collection.getImage(),false));
		
	}
}
