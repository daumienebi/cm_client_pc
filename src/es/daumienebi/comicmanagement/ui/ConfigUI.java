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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 470,589);
		
		JLabel api_icon = new JLabel("");
		ImageIcon icon = new ImageIcon(ConfigUI.class.getResource("/resources/api_icon.png"));
		Image img = icon.getImage();			
		//scale the image
		Image imgNuevo = img.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		api_icon.setIcon(icon);
		((JComponent) getContentPane()).setBorder(BorderFactory.createTitledBorder(null, ConfigUI_configValues,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 

		JLabel lblNewLabel_1 = new JLabel("SERVIDOR");
		
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
		
		JLabel lblApiServer = new JLabel("SERVIDOR PRINCIPAL");
		
		JLabel lblComicImageServer = new JLabel("SERVIDOR IMAGENES");
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("SERVER");
		
		txtComicImgServer = new JTextField();
		txtComicImgServer.setColumns(10);
		
		JButton ConfigUI_SaveSettings = new JButton("Guardar");
		
		JCheckBox chkDefault = new JCheckBox("Usar valores por defecto");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(api_icon)
					.addGap(10)
					.addComponent(lblApiServer, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtApiServer, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ftpIcon)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtFtpServer, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtFtpUser, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtFtpPass, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_1_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(lblComicImageServer, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(txtComicImgServer, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(chkDefault, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
					.addComponent(ConfigUI_SaveSettings, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtApiServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ftpIcon)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtFtpServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtFtpUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtFtpPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblComicImageServer)
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1_1_1))
						.addComponent(txtComicImgServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(chkDefault)
						.addComponent(ConfigUI_SaveSettings))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);
	}
}
