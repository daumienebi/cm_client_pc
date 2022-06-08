package es.daumienebi.comicmanagement.views;

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

public class NewComicUI extends JDialog {
	
	public static JLabel NewComicUI_comicName;
	public static JLabel NewComicUI_comicCollection;
	public static JLabel NewComicUI_comicAdquisitionDate;
	public static JLabel NewComicUI_comicState;
	public static JLabel NewComicUI_comicNumber;
	public static String NewComicUI_windowTitle = "Add New Comic";
	public static String NewComicUI_newComic = "New Comic";
	
	private JButton btnComicPoster;
	private JTextField txtNumber;
	private JPanel dataPanel;
	private JTextField txtName;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;
	private JTextField txtComicNumber;
	

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

	/**
	 * Create the dialog.
	 */
	public NewComicUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewComicUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 943, 580);
		setTitle(NewComicUI_windowTitle);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton NewComicUI_btnAddComic = new JButton("A\u00F1adir Comic");
		panel.add(NewComicUI_btnAddComic);
		
		JButton NewComicUI_btnSaveComic = new JButton("Guardar Comic");
		panel.add(NewComicUI_btnSaveComic);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.WEST);
		
		btnComicPoster = new JButton("");
		btnComicPoster.setMargin(new Insets(0, 0, 0, 0));
		btnComicPoster.setBounds(20,20,300,450);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/deadpool_collection.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(btnComicPoster.getWidth(),btnComicPoster.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		btnComicPoster.setIcon(icon);
		JButton btnAddComicPoster = new JButton("");
		btnAddComicPoster.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddComicPoster.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-compact-camera-40.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(btnComicPoster)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddComicPoster)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(btnComicPoster)
					.addGap(58))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(226)
					.addComponent(btnAddComicPoster)
					.addContainerGap(259, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.EAST);
		
		dataPanel = new JPanel();
		getContentPane().add(dataPanel, BorderLayout.CENTER);
		dataPanel.setBorder(BorderFactory.createTitledBorder(null, NewComicUI_newComic,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblCollection = new JLabel("COLLECTION");
		lblCollection.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtDay = new JTextField();
		txtDay.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("ADQUISITION DATE");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtMonth = new JTextField();
		txtMonth.setColumns(10);
		
		txtYear = new JTextField();
		txtYear.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NUMBER");
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtComicNumber = new JTextField();
		txtComicNumber.setColumns(10);
		
		JComboBox cmbState = new JComboBox();
		GroupLayout gl_dataPanel = new GroupLayout(dataPanel);
		gl_dataPanel.setHorizontalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCollection, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addGap(39))
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtComicNumber, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtDay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
							.addGap(28)
							.addComponent(txtMonth, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(txtYear, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
						.addComponent(cmbState, 0, 303, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_dataPanel.setVerticalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCollection))
					.addGap(43)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(txtMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
					.addContainerGap(181, Short.MAX_VALUE))
		);
		dataPanel.setLayout(gl_dataPanel);
		
		//inicializeForm();

	}
	
	/*
	private void inicializeForm() {
		NewComicUI_comicName = new JLabel("Nombre");
		txtName = new JTextField();
		NewComicUI_comicName = new JLabel("Fecha Adquisición");
		txtDate = new JTextField();
		//txtMonth = new JTextField();
		//txtYear = new JTextField();
		NewComicUI_comicName = new JLabel("Collección");
		txtCollection = new JTextField();
		NewComicUI_comicName = new JLabel("Estado");
		NewComicUI_comicName = new JLabel("Numero");
		txtNumber = new JTextField();
		
		dataPanel.add(NewComicUI_comicName);
		dataPanel.add(txtName);
		dataPanel.add(NewComicUI_comicAdquisitionDate);
		dataPanel.add(txtDate);
		dataPanel.add(NewComicUI_comicCollection);
		dataPanel.add(txtCollection);
		dataPanel.add(NewComicUI_comicState);
		//dataPanel.add(txtState);
		dataPanel.add(NewComicUI_comicNumber);
		dataPanel.add(txtNumber);
		
		/*
		JPanel j = new JPanel();
		
		j.setLayout(new BorderLayout());
		j.add(dataPanel,BorderLayout.NORTH);
		add(j);
		
	}
*/
}
