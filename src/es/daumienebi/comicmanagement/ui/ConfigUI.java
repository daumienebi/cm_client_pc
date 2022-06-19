package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class ConfigUI extends JDialog {
	private JTextField txtApiServer;
	private JTextField txtFtpServer;
	private JTextField txtFtpUser;
	private JTextField txtFtpPass;
	private JTextField txtComicImgServer;

	public static String ConfigUI_configValues = "Config Values";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigUI dialog = new ConfigUI();
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
	public ConfigUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 500,900);
		
		JLabel api_icon = new JLabel("");
		ImageIcon icon = new ImageIcon(ConfigUI.class.getResource("/resources/api_icon.png"));
		Image img = icon.getImage();			
		//scale the image
		Image imgNuevo = img.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		api_icon.setIcon(icon);
		((JComponent) getContentPane()).setBorder(BorderFactory.createTitledBorder(null, ConfigUI_configValues,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 

		JLabel lblNewLabel_1 = new JLabel("SERVIDOR");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtApiServer = new JTextField();
		txtApiServer.setColumns(10);
		
		JLabel ftpIcon = new JLabel("");
		ImageIcon icon2 = new ImageIcon(ConfigUI.class.getResource("/resources/ftp_server_icon.png"));
		Image img2 = icon2.getImage();			
		//scale the image
		Image imgNuevo2 = img2.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon2 =new ImageIcon(imgNuevo2);
		
		ftpIcon.setIcon(icon2);
		
		JLabel lblNewLabel_1_1 = new JLabel("SERVIDOR FTP");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtFtpServer = new JTextField();
		txtFtpServer.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("USUARIO FTP");
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtFtpUser = new JTextField();
		txtFtpUser.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_1_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtFtpPass = new JTextField();
		txtFtpPass.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("SERVIDOR FTP");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblApiServer = new JLabel("SERVIDOR PRINCIPAL");
		lblApiServer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblComicImageServer = new JLabel("SERVIDOR IMAGENES");
		lblComicImageServer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("COMICS");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtComicImgServer = new JTextField();
		txtComicImgServer.setColumns(10);
		
		JButton ConfigUI_SaveSettings = new JButton("Guardar");
		
		JCheckBox chkDefault = new JCheckBox("Usar valores por defecto");
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("COLECCIONES");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblBaseDeDatos = new JLabel("BASE DE DATOS (INFORMES)");
		lblBaseDeDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("IP");
		
		JLabel lblNewLabel_3 = new JLabel("USER");
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD");
		
		JLabel lblNewLabel_5 = new JLabel("NOMBRE");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("PORT");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(38)
					.addGap(10)
					.addComponent(api_icon)
					.addGap(10)
					.addComponent(lblApiServer, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtApiServer, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ftpIcon)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_1_1, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chkDefault, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(307, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
									.addGap(53)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
											.addGap(2))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
											.addGap(2))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
											.addGap(2))
										.addComponent(lblBaseDeDatos, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(ConfigUI_SaveSettings, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
											.addGap(2))
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
								.addComponent(separator_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblComicImageServer, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtComicImgServer, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))))
					.addGap(40))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtFtpServer))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtFtpUser))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtFtpPass, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(api_icon)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(lblApiServer)))
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txtApiServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ftpIcon)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(txtFtpServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(txtFtpUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(txtFtpPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(24)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblComicImageServer)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1_1_1))
						.addComponent(txtComicImgServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBaseDeDatos, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5_1)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkDefault)
						.addComponent(ConfigUI_SaveSettings))
					.addGap(16))
		);
		getContentPane().setLayout(groupLayout);
	}
}
