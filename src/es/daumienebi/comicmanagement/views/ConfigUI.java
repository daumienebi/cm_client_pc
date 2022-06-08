package es.daumienebi.comicmanagement.views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;

public class ConfigUI extends JDialog {
	private JTextField txtApiServer;
	private JTextField txtFtpServer;
	private JTextField txtFtpUser;
	private JTextField txtFtpPass;
	private JTextField txtComicImgServer;

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
		setBounds(100, 100, 462,581);
		
		JLabel api_icon = new JLabel("");
		api_icon.setBounds(10, 11, 100, 100);
		ImageIcon icon = new ImageIcon(ConfigUI.class.getResource("/resources/api_icon.png"));
		Image img = icon.getImage();			
		//scale the image
		Image imgNuevo = img.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		api_icon.setIcon(icon);
		JLabel lblNewLabel_1 = new JLabel("SERVIDOR");
		lblNewLabel_1.setBounds(10, 137, 54, 14);
		getContentPane().setLayout(null);
		getContentPane().add(api_icon);
		getContentPane().add(lblNewLabel_1);
		
		txtApiServer = new JTextField();
		txtApiServer.setBounds(119, 134, 312, 20);
		getContentPane().add(txtApiServer);
		txtApiServer.setColumns(10);
		
		JLabel ftpIcon = new JLabel("");
		ftpIcon.setBounds(10, 162, 100, 100);
		getContentPane().add(ftpIcon);
		ImageIcon icon2 = new ImageIcon(ConfigUI.class.getResource("/resources/ftp_server_icon.png"));
		Image img2 = icon2.getImage();			
		//scale the image
		Image imgNuevo2 = img2.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon2 =new ImageIcon(imgNuevo2);
		
		ftpIcon.setIcon(icon2);
		
		JLabel lblNewLabel_1_1 = new JLabel("SERVIDOR FTP");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(10, 274, 100, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		txtFtpServer = new JTextField();
		txtFtpServer.setColumns(10);
		txtFtpServer.setBounds(119, 271, 312, 20);
		getContentPane().add(txtFtpServer);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("USUARIO FTP");
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(10, 311, 100, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtFtpUser = new JTextField();
		txtFtpUser.setColumns(10);
		txtFtpUser.setBounds(119, 308, 312, 20);
		getContentPane().add(txtFtpUser);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_1_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNewLabel_1_1_1_1.setBounds(10, 348, 100, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtFtpPass = new JTextField();
		txtFtpPass.setColumns(10);
		txtFtpPass.setBounds(119, 345, 312, 20);
		getContentPane().add(txtFtpPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 122, 426, 9);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 171, 426, 9);
		getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 389, 426, 9);
		getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel = new JLabel("SERVIDOR FTP");
		lblNewLabel.setBounds(112, 230, 121, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApiServer = new JLabel("SERVIDOR PRINCIPAL");
		lblApiServer.setBounds(120, 97, 113, 14);
		getContentPane().add(lblApiServer);
		
		JLabel lblComicImageServer = new JLabel("SERVIDOR IMAGENES");
		lblComicImageServer.setBounds(112, 403, 140, 14);
		getContentPane().add(lblComicImageServer);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("SERVER");
		lblNewLabel_1_1_1_1_1.setBounds(10, 441, 71, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		txtComicImgServer = new JTextField();
		txtComicImgServer.setColumns(10);
		txtComicImgServer.setBounds(119, 438, 312, 20);
		getContentPane().add(txtComicImgServer);
		
		JButton ConfigUI_SaveSettings = new JButton("Guardar");
		ConfigUI_SaveSettings.setBounds(342, 508, 89, 23);
		getContentPane().add(ConfigUI_SaveSettings);
		
		JCheckBox chkDefault = new JCheckBox("Usar valores por defecto");
		chkDefault.setBounds(6, 508, 171, 23);
		getContentPane().add(chkDefault);
	}
}
