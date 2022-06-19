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
import es.daumienebi.comicmanagement.utils.Constants.ComicState;
import es.daumienebi.comicmanagement.utils.ReportsUtil;

import java.awt.SystemColor;

public class PersonalizedReportsUI extends JDialog {
	private JTextField txtComicCount;
	private JTextField txtFechaAdq;
	private static JComboBox cmbState;
	private String comic_state = ComicState.Nuevo.toString();
	
	private static String COMIC_IMAGE_SERVER = Configuration.comic_image_server;
	private static String COLLECTION_IMAGE_SERVER = Configuration.collection_image_server;
	
	
	//To be translated 
	public static String header1 = "Actors Report";
	public static String header2 = "Movies Report";	
	public static JLabel PersonalizedReportsUI_comicState;
	public static JLabel PersonalizedReportsUI_fechaAdq;
	public static JButton btnLoadReport1;
	public static JButton btnLoadReport2;
	public static JButton btnLoadReport3;
	public static JLabel PersonalizedReportsUI_comicCount;
	public static String UIMessages_error = "Error";
	public static String UIMessages_incorrectDataType = "Incorrect data type, please introduce a correct value";
	
	
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
	}
	
	void Inicialize() {
		setTitle("Personalized Reports");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonalizedReportsUI.class.getResource("/resources/logo.png")));
		setBounds(100, 100, 600, 300);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Informe de colecciones", null, panel, null);
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
		
		JLabel lblNewLabel_1 = new JLabel(">");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		PersonalizedReportsUI_fechaAdq = new JLabel("Fecha Adquisition");
		PersonalizedReportsUI_fechaAdq.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1_1 = new JLabel("=");
		lblNewLabel_1_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtFechaAdq = new JTextField();
		txtFechaAdq.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFechaAdq.setColumns(10);
		
		btnLoadReport2 = new JButton("Cargar Informe");
		btnLoadReport2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnLoadReport2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TextFieldValidatorUtil.isNumeric(txtFechaAdq.getText())) {
					comic_state = cmbState.getSelectedItem().toString();
					try {
						Thread.sleep(2000);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					dispose();
					ReportsUtil.viewPersonalizedReport1("PersonalizedReport1.jrxml", comic_state,COMIC_IMAGE_SERVER);
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Incorrect data type, please introduce a correct value", "Invalid value", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("The report shows the list of movies that have the rating greater than the introduced value");
		btnNewButton.setIcon(new ImageIcon(PersonalizedReportsUI.class.getResource("/resources/info.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Show the list of movies that were premiered in the introduce year");
		btnNewButton_1.setIcon(new ImageIcon(PersonalizedReportsUI.class.getResource("/resources/info.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(PersonalizedReportsUI_comicCount, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(PersonalizedReportsUI_fechaAdq, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtComicCount, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
							.addComponent(btnLoadReport1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtFechaAdq, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(btnLoadReport2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(12))))
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
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGap(5)
								.addComponent(txtComicCount))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGap(6)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(PersonalizedReportsUI_comicCount, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))))
					.addGap(79)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(PersonalizedReportsUI_fechaAdq, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtFechaAdq, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnLoadReport2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Informe de comics", null, panel_1, null);
		
		PersonalizedReportsUI_comicState = new JLabel("Estado :");
		PersonalizedReportsUI_comicState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnLoadReport3 = new JButton("Cargar Informe");
		btnLoadReport3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TextFieldValidatorUtil.isNumeric(txtComicCount.getText())) {
					int movie_count = Integer.valueOf(txtComicCount.getText());
					try {
						Thread.sleep(2000);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					dispose();
					
					//ReportsUtil.viewPersonalizedReport3("PersonalizedReport3.jrxml", movie_count);
					
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Incorrect data type, please introduce a correct value", "Invalid value", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Show the list of actors that have participated in the number \\ greater than the number of movies given");
		btnNewButton_2.setIcon(new ImageIcon(PersonalizedReportsUI.class.getResource("/resources/info.png")));
		
		cmbState = new JComboBox();
		cmbState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comic_state = cmbState.getSelectedItem().toString();
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
					.addGap(129))
		);
		panel_1.setLayout(gl_panel_1);

	}
	
	void translate() {
		if(Translator.bundle != null) {
			Translator.translatePersonalizedReportsUI(Configuration.app_language);
		}
	}
}
