package es.daumienebi.comicmanagement.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import org.jfree.util.DefaultConfiguration;

import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.controllers.ConfigUIController;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfigUI extends JDialog {
	private JTextField txtApiServer;
	private JTextField txtFtpServer;
	private JTextField txtFtpUser;
	private JTextField txtComicImgServer;

	//To be translated
	public static JLabel ConfigUI_Server;
	public static JLabel ConfigUI_FtpUser;
	public static JLabel ConfigUI_FtpServer;
	public static JLabel ConfigUI_FtpServer2;
	public static JLabel ConfigUI_PrincipalServer;
	public static JLabel ConfigUI_ComicImgServer;
	public static JLabel ConfigUI_FtpPassword;
	public static JLabel ConfigUI_ImageServer;
	public static JButton ConfigUI_SaveSettings;
	public static JLabel ConfigUI_port;
	public static JLabel ConfigUI_nombre;
	public static JLabel ConfigUI_password;
	public static JLabel ConfigUI_ip;
	public static JLabel ConfigUI_BaseDeDatos;
	public static JLabel ConfigUI_CollectionImgServer;
	public static JLabel ConfigUI_user;
	public static String ConfigUI_configValues = "Valores de conexión";
	public static String ConfigUI_saveError = "Es obligatorio indicar el Servidor principal";
	
	private JTextField txtCollectionImgServer;
	private JTextField txtIp;
	private JTextField txtDbUser;
	private JTextField txtDbName;
	private JTextField txtDbPort;
	private JPasswordField txtFtpPassword;
	private JPasswordField txtDbPassword;
	ConfigUIController controller = new ConfigUIController();
	
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
		Inicialize();
		fillConfigValues();
		controller.translate();
	}
	
	void Inicialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 700,900);
		
		JLabel api_icon = new JLabel("");
		ImageIcon icon = new ImageIcon(ConfigUI.class.getResource("/resources/api_icon.png"));
		Image img = icon.getImage();			
		//scale the image
		Image imgNuevo = img.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		api_icon.setIcon(icon);
		((JComponent) getContentPane()).setBorder(BorderFactory.createTitledBorder(null, ConfigUI_configValues,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 

		ConfigUI_Server = new JLabel("SERVIDOR");
		ConfigUI_Server.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtApiServer = new JTextField();
		txtApiServer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtApiServer.getText().length() < 0) {
					txtApiServer.setBackground(Color.red);
				}else {
					txtApiServer.setBackground(Color.white);
				}
			}
		});
		txtApiServer.setColumns(10);
		
		JLabel ftpIcon = new JLabel("");
		ImageIcon icon2 = new ImageIcon(ConfigUI.class.getResource("/resources/ftp_server_icon.png"));
		Image img2 = icon2.getImage();			
		//scale the image
		Image imgNuevo2 = img2.getScaledInstance(100,100,  java.awt.Image.SCALE_SMOOTH );
		icon2 =new ImageIcon(imgNuevo2);
		
		ftpIcon.setIcon(icon2);
		
		ConfigUI_FtpServer2 = new JLabel("SERVIDOR FTP");
		ConfigUI_FtpServer2.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtFtpServer = new JTextField();
		txtFtpServer.setColumns(10);
		
		ConfigUI_FtpUser = new JLabel("USUARIO FTP");
		ConfigUI_FtpUser.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtFtpUser = new JTextField();
		txtFtpUser.setColumns(10);
		
		ConfigUI_FtpPassword = new JLabel("CONTRASE\u00D1A");
		ConfigUI_FtpPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_1_1 = new JSeparator();
		
		ConfigUI_FtpServer = new JLabel("SERVIDOR FTP");
		ConfigUI_FtpServer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		ConfigUI_PrincipalServer = new JLabel("SERVIDOR PRINCIPAL");
		ConfigUI_PrincipalServer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		ConfigUI_ImageServer = new JLabel("SERVIDOR IMAGENES");
		ConfigUI_ImageServer.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		ConfigUI_ComicImgServer = new JLabel("COMICS");
		ConfigUI_ComicImgServer.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtComicImgServer = new JTextField();
		txtComicImgServer.setColumns(10);
		
		ConfigUI_SaveSettings = new JButton("Guardar");
		ConfigUI_SaveSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtApiServer.getText().isBlank()) {
							Configuration.server = txtApiServer.getText().trim();
							Configuration.db_ip = txtIp.getText().trim();
							Configuration.db_port = txtDbPort.getText().trim();
							Configuration.db_name = txtDbName.getText().trim();
							Configuration.db_user = txtDbUser.getText().trim();
							String bd_pass = new String(txtDbPassword.getPassword());
							Configuration.db_password = bd_pass;
							bd_pass = "";
							Configuration.ftp_user = txtFtpUser.getText().trim();
							String ftp_pass = new String(txtFtpPassword.getPassword());
							Configuration.ftp_password = ftp_pass;
							ftp_pass = "";
							Configuration.ftp_server = txtFtpServer.getText().trim();
							Configuration.comic_image_server = txtComicImgServer.getText().trim();
							Configuration.collection_image_server = txtCollectionImgServer.getText().trim();
							controller.saveConfig();
			}else {
				JOptionPane.showMessageDialog(null, ConfigUI_saveError);
			}
				
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		
		ConfigUI_CollectionImgServer = new JLabel("COLECCIONES");
		ConfigUI_CollectionImgServer.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtCollectionImgServer = new JTextField();
		txtCollectionImgServer.setColumns(10);
		
		ConfigUI_BaseDeDatos = new JLabel("BASE DE DATOS (INFORMES)");
		ConfigUI_BaseDeDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		ConfigUI_ip = new JLabel("IP");
		ConfigUI_ip.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		ConfigUI_user = new JLabel("USUARIO");
		ConfigUI_user.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		ConfigUI_password = new JLabel("PASSWORD");
		ConfigUI_password.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		ConfigUI_nombre = new JLabel("NOMBRE");
		ConfigUI_nombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtIp = new JTextField();
		txtIp.setColumns(10);
		
		txtDbUser = new JTextField();
		txtDbUser.setColumns(10);
		
		txtDbName = new JTextField();
		txtDbName.setColumns(10);
		
		ConfigUI_port = new JLabel("PUERTO");
		ConfigUI_port.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		
		txtDbPort = new JTextField();
		txtDbPort.setColumns(10);
		
		txtFtpPassword = new JPasswordField();
		
		txtDbPassword = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(api_icon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ConfigUI_PrincipalServer, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(387))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(ConfigUI_Server, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtApiServer, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
					.addGap(40))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ftpIcon)
							.addGap(18)
							.addComponent(ConfigUI_FtpServer, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(separator_1_1, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ConfigUI_FtpServer2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtFtpServer, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ConfigUI_FtpUser, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtFtpUser, 527, 527, 527))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ConfigUI_FtpPassword, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFtpPassword, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)))
					.addGap(38))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(ConfigUI_CollectionImgServer, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCollectionImgServer, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(ConfigUI_ip)
								.addComponent(ConfigUI_user)
								.addComponent(ConfigUI_password)
								.addComponent(ConfigUI_nombre)
								.addComponent(ConfigUI_port, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtDbName, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(ConfigUI_SaveSettings, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDbPort, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
									.addGap(2))
								.addComponent(txtIp, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtDbPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
										.addComponent(txtDbUser, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
									.addGap(2))
								.addComponent(ConfigUI_BaseDeDatos, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(ConfigUI_ComicImgServer, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(ConfigUI_ImageServer, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtComicImgServer, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))))
					.addGap(40))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(api_icon)
						.addComponent(ConfigUI_PrincipalServer))
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(ConfigUI_Server))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txtApiServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ftpIcon)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(ConfigUI_FtpServer)
							.addGap(9)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(ConfigUI_FtpServer2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(txtFtpServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(ConfigUI_FtpUser, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(txtFtpUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfigUI_FtpPassword, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFtpPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ConfigUI_ImageServer)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(ConfigUI_ComicImgServer))
						.addComponent(txtComicImgServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfigUI_CollectionImgServer, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCollectionImgServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(ConfigUI_BaseDeDatos, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConfigUI_ip))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfigUI_user)
						.addComponent(txtDbUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfigUI_password)
						.addComponent(txtDbPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfigUI_nombre)
						.addComponent(txtDbName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConfigUI_port)
						.addComponent(txtDbPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(ConfigUI_SaveSettings)
					.addGap(16))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	void disableTxtBoxes() {
		txtDbPassword.setEnabled(false);
		txtDbUser.setEnabled(false);
		txtDbPort.setEnabled(false);
		txtIp.setEnabled(false);
		txtDbName.setEnabled(false);
		txtFtpPassword.setEnabled(false);
		txtFtpServer.setEnabled(false);
		txtFtpUser.setEnabled(false);
		txtComicImgServer.setEnabled(false);
		txtCollectionImgServer.setEnabled(false);
	}
	
	void enableTxtBoxes() {
		txtDbPassword.setEnabled(true);
		txtDbUser.setEnabled(true);
		txtDbPort.setEnabled(true);
		txtIp.setEnabled(true);
		txtDbName.setEnabled(true);
		txtFtpPassword.setEnabled(true);
		txtFtpServer.setEnabled(true);
		txtFtpUser.setEnabled(true);
		txtComicImgServer.setEnabled(true);
		txtCollectionImgServer.setEnabled(true);
	}
	
	
	/*
	void fillDefaultValues() {
		txtIp.setText("192.168.56.101");
		txtDbPort.setText("3306");
		txtDbUser.setText("root");
		txtDbPassword.setText("");
		txtDbName.setText("comicdb");
		
		/*
		txtFtpServer.setText(DefaultConfiguration.ftp_server);
		txtFtpUser.setText(DefaultConfiguration.ftp_user);
		txtActorImgServer.setText(DefaultConfiguration.actor_image_server);
		txtMovieImgServer.setText(DefaultConfiguration.movie_image_server);
		txtFtpPass.setText(DefaultConfiguration.ftp_password);
		
	}
	*/
	void fillConfigValues() {
		txtApiServer.setText(Configuration.server);
		txtIp.setText(Configuration.db_ip);
		txtDbPort.setText(Configuration.db_port);
		txtDbUser.setText(Configuration.db_user);
		txtDbPassword.setText(Configuration.db_password);
		txtDbName.setText(Configuration.db_name);
		txtFtpPassword.setText(Configuration.ftp_password);
		txtFtpServer.setText(Configuration.ftp_server);
		txtFtpUser.setText(Configuration.ftp_user);
		txtComicImgServer.setText(Configuration.comic_image_server);
		txtCollectionImgServer.setText(Configuration.collection_image_server);
	}
	
	void hideDefaultValues() {
		txtIp.setText("");
		txtDbPort.setText("");
		txtDbUser.setText("");
		txtDbPassword.setText("");
		txtDbName.setText("");
	}
}
