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
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.FlowLayout;

public class NewComicUI extends JDialog {

	private JButton btnComicPoster;
	
	public static JLabel NewComicUI_comicName;
	public static JLabel NewComicUI_comicCollection;
	public static JLabel NewComicUI_comicAdquisitionDate;
	public static JLabel NewComicUI_comicState;
	public static JLabel NewComicUI_comicNumber;
	
	private JPanel dataPanel;
	private JComboBox<String> cmbState;
	private JTextField txtName;
	private JTextField txtCollection;
	private JTextField txtDate;
	//private JTextField txtMonth;
	//private JTextField txtYear;
	private JTextField txtNumber;
	

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
		setBounds(100, 100, 900, 600);
		
		btnComicPoster = new JButton("");
		btnComicPoster.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnComicPoster.setBackground(SystemColor.info);
		btnComicPoster.setMargin(new Insets(0, 0, 0, 0));
		btnComicPoster.setBounds(20,20,300,450);
		btnComicPoster.setContentAreaFilled(false);
		getContentPane().add(btnComicPoster, BorderLayout.WEST);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/comic2.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(btnComicPoster.getWidth(),btnComicPoster.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		btnComicPoster.setIcon(icon);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton NewComicUI_btnAddComic = new JButton("A\u00F1adir Comic");
		panel.add(NewComicUI_btnAddComic);
		
		JButton NewComicUI_btnSaveComic = new JButton("Guardar Comic");
		panel.add(NewComicUI_btnSaveComic);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		dataPanel = new JPanel();
		getContentPane().add(dataPanel, BorderLayout.CENTER);
		dataPanel.setLayout(new GridLayout(5, 2));
		
		//inicializeForm();

	}
	
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
		*/
	}

}
