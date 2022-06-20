package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.daumienebi.comicmanagement.utils.TextFieldValidatorUtil;
import es.daumienebi.comicmanagement.utils.Translator;
import es.daumienebi.comicmanagement.utils.Configuration;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import es.daumienebi.comicmanagement.utils.Constants.AppLanguage;
import es.daumienebi.comicmanagement.utils.Constants.ComicState;
import es.daumienebi.comicmanagement.utils.ReportsUtil;

import java.awt.SystemColor;

public class PersonalizedReportsUI extends JDialog {
	private JTextField txtComicCount;
	private static JComboBox cmbState;
	private String comic_state = ComicState.Nuevo.toString();
	
	private static String COMIC_IMAGE_SERVER = Configuration.comic_image_server;
	private static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;
	
	
	//To be translated 
	public static String header1 = "Informe de comics";
	public static String header2 = "Informe de colecciones";	
	public static JLabel PersonalizedReportsUI_comicState;
	public static JButton btnLoadReport1;
	public static JButton btnLoadReport3;
	public static JLabel PersonalizedReportsUI_comicCount;
	public static String UIMessages_error = "Error";
	public static String UIMessages_incorrectDataType = "Valor introducido incorrecto, por favor introduce un valor correcto";
	public static String PersonalizedReportsUI_windowTitle = "Informes Personalizados";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalizedReportsUI dialog = new PersonalizedReportsUI();
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
	
	public PersonalizedReportsUI() {
		Inicialize();
		translate();
		setTitle(PersonalizedReportsUI_windowTitle);
		
	}
	
	void Inicialize() {
		setTitle(PersonalizedReportsUI_windowTitle);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonalizedReportsUI.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 600, 300);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab(header2, null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		
		PersonalizedReportsUI_comicCount = new JLabel("Numero de comics");
		PersonalizedReportsUI_comicCount.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		txtComicCount = new JTextField();
		txtComicCount.setColumns(10);
		
		btnLoadReport1 = new JButton("Cargar Informe");
		btnLoadReport1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnLoadReport1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TextFieldValidatorUtil.isNumeric(txtComicCount.getText())) {
					int comic_count =Integer.valueOf(txtComicCount.getText());
					try {
						Thread.sleep(2000);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					dispose();
					ReportsUtil.viewPersonalizedReport2("PersonalizedReport2.jrxml", comic_count,COLLECTION_IMAGE_SERVER);
				}else {
					JOptionPane.showMessageDialog(getContentPane(), UIMessages_incorrectDataType, UIMessages_error, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel(">=");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnNewButton = new JButton("");
		String tooltip1 = "";
		if(Configuration.app_language == AppLanguage.English) {
			tooltip1 = "Shows the collections that have the total number of comics greater than or equal to the given number";
		}
		if(Configuration.app_language == AppLanguage.Galician) {
			tooltip1 = "Mostra as coleccions que teñen o numero de comics maior ou igual co numero dado";
		}
		if(Configuration.app_language == AppLanguage.Spanish) {
			tooltip1 = "Muestra las colecciónes que tengan el numero de comics mayor o igual que el numero dado";
		}
		btnNewButton.setToolTipText(tooltip1);
		btnNewButton.setIcon(new ImageIcon(PersonalizedReportsUI.class.getResource("/resources/info.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(PersonalizedReportsUI_comicCount, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(txtComicCount, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(btnLoadReport1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLoadReport1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(txtComicCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(PersonalizedReportsUI_comicCount, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addGap(119))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		if(Configuration.app_language == AppLanguage.English) {
			header1 = "Comic Reports";
			header2 = "Collection Reports";
		}
		tabbedPane.addTab(header1, null, panel_1, null);
		
		PersonalizedReportsUI_comicState = new JLabel("Estado :");
		PersonalizedReportsUI_comicState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnLoadReport3 = new JButton("Cargar Informe");
		btnLoadReport3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comic_state != null) {
					comic_state = cmbState.getSelectedItem().toString();
					try {
						Thread.sleep(2000);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					dispose();
					ReportsUtil.viewPersonalizedReport1("PersonalizedReport1.jrxml", comic_state,COMIC_IMAGE_SERVER);
				}else {
					JOptionPane.showMessageDialog(getContentPane(), UIMessages_incorrectDataType, UIMessages_error, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		String tooltip2 = "";
		if(Configuration.app_language == AppLanguage.English) {
			tooltip2 = "Shows the comics that are in the given state";
		}
		if(Configuration.app_language == AppLanguage.Galician) {
			tooltip2 = "Mostra os comics que teñen o estado elexido";
		}
		if(Configuration.app_language == AppLanguage.Spanish) {
			tooltip2 = "Muestra los comics que se encuentran en el estado elegido";
		}
		
		btnNewButton_2.setToolTipText(tooltip2);
		btnNewButton_2.setIcon(new ImageIcon(PersonalizedReportsUI.class.getResource("/resources/info.png")));
		
		cmbState = new JComboBox();
		cmbState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((ComicState)cmbState.getSelectedItem() == ComicState.SinEstado) {
					JOptionPane.showMessageDialog(getContentPane(), "Parametro invalido", "Error", JOptionPane.ERROR_MESSAGE);
					comic_state = ComicState.Nuevo.toString();
					cmbState.setSelectedItem(ComicState.Nuevo);
				}else {
					comic_state = cmbState.getSelectedItem().toString();
				}
			}
		});
		cmbState.setModel(new DefaultComboBoxModel(ComicState.values()));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(PersonalizedReportsUI_comicState, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
					.addComponent(btnLoadReport3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(66)
							.addComponent(PersonalizedReportsUI_comicState, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoadReport3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
					.addGap(129)));
		
		panel_1.setLayout(gl_panel_1);

	}
	
	void translate() {
		if(Translator.bundle != null) {
			Translator.translatePersonalizedReportsUI(Configuration.app_language);
		}
	}
}
