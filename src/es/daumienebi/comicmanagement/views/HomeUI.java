package es.daumienebi.comicmanagement.views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JPanel;

import es.daumienebi.comicmanagement.controllers.HomeUIController;
import es.daumienebi.comicmanagement.services.impl.ComicService;
import es.daumienebi.comicmanagement.utils.Constants;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.UIManager;
public class HomeUI {

	private JMenuItem menuOptionExit;
	
	public JFrame frame;
	private JLabel imgSlider;
	private JPanel mainPanel;
	
	//Comic Poster stuffs
	Timer tm;
	int imgPos = 0;
	String[] imgList = HomeUIController.getImages();
	
	//To be translated
	public static JMenu menuConnection;
	public static JMenu menuCollections;
	public static JMenuItem menuAddCollection;
	public static JMenuItem menuCollectionManagement;
	public static JMenu menuComics;
	public static JMenuItem menuAddComic;
	public static JMenuItem menuComicManagement;
	public static JMenu menuAutors ;
	public static JMenu menuReports;
	public static JMenu menuClients;
	public static JMenu menuSettings;
	public static JMenu menuHelp;
	public static JMenuItem menuHelpContents;
	public static JMenuItem menuTecnicalManual;
	private JMenu menuBasicReports;
	private JMenuItem menuPersonalizedReports;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu menuSelectLanguage;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	
	ComicService comicService = new ComicService();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI window = new HomeUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(HomeUI.class.getResource("/resources/logo.png")));
		frame.setBounds(100, 100, 1300,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame); //to center the JFrame to the center of the screen
		setBackgroundImage();
		frame.setLocationRelativeTo(frame);
		mainPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		imgSlider = new JLabel("");
		imgSlider.setHorizontalTextPosition(SwingConstants.CENTER);
		imgSlider.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(imgSlider, BorderLayout.CENTER);
		imgSlider.setBounds(40, 30, 700, 300);
		
        //Set a timer to slide through the images
        tm = new Timer(2500,new ActionListener() {
        	//add only
            @Override
            public void actionPerformed(ActionEvent e) {
            	setImageSlider(imgPos);
                imgPos += 1;
                if(imgPos >= imgList.length)
                	imgPos = 0; 
            }
        });
		tm.start();
		setImageSlider(0); // start the slider from 0
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 102));
		mainPanel.add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		mainPanel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 102));
		mainPanel.add(panel_3, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 102));
		mainPanel.add(panel, BorderLayout.SOUTH);
		//setBottomImg();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		mnNewMenu.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		menuOptionExit = new JMenuItem("Salir");
		menuOptionExit.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-close-24.png")));
		mnNewMenu.add(menuOptionExit);
		menuOptionExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Close the window
				int option;
				//JOptionPane.setDefaultLocale(Locale.ENGLISH);
				option =JOptionPane.showConfirmDialog(frame,"Seguro que quiere salir de la applicación ?","Salir",JOptionPane.INFORMATION_MESSAGE);
				
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {}
					//do nothing				
			}
		});
		
		menuConnection = new JMenu("Conexión");
		menuConnection.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuConnection);
		
		mntmNewMenuItem_2 = new JMenuItem("Añadir conexión");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigUI  ui = new ConfigUI();
				ui.setModal(true);
				ui.setLocationRelativeTo(frame);
				ui.setMinimumSize(Constants.configUIMinimunSize);
				ui.setVisible(true);
				comicService.getUser();
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-add-database-24.png")));
		menuConnection.add(mntmNewMenuItem_2);
		
		menuCollections = new JMenu("Colleciones");
		menuCollections.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuCollections);
		
		menuAddCollection = new JMenuItem("Añadir Collección");
		menuAddCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCollectionUI ui = new NewCollectionUI();
				ui.setModal(true);
				ui.setLocationRelativeTo(frame);
				ui.setMinimumSize(Constants.newCollectionMinimumSize);
				ui.setVisible(true);
			}
		});
		menuAddCollection.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-plus-math-24.png")));
		menuCollections.add(menuAddCollection);
		
		menuCollectionManagement = new JMenuItem("Gestionar Colecciones");
		menuCollectionManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollectionManagementUI ui = new CollectionManagementUI();
				ui.setModal(true);
				ui.setLocationRelativeTo(frame);
				ui.setVisible(true);
			}
		});
		menuCollectionManagement.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-view-details-24.png")));
		menuCollections.add(menuCollectionManagement);
		
		menuComics = new JMenu("Comics");
		menuComics.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuComics);
		
		menuAddComic = new JMenuItem("Añadir Comic");
		menuAddComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewComicUI ui = new NewComicUI();
				ui.setModal(true);
				ui.setLocationRelativeTo(frame);
				ui.setMinimumSize(Constants.newComicMinimumSize);
				ui.setVisible(true);
				
			}
		});
		menuAddComic.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-plus-math-24.png")));
		menuComics.add(menuAddComic);
		
		menuComicManagement = new JMenuItem("Gestionar Comics");
		menuComicManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComicManagementUI ui = new ComicManagementUI();
				ui.setLocationRelativeTo(frame);
				ui.setModal(true);
				ui.setVisible(true);
			}
		});
		menuComicManagement.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-view-details-24.png")));
		menuComics.add(menuComicManagement);
		
		menuReports = new JMenu("Informes");
		menuReports.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuReports);
		
		menuBasicReports = new JMenu("Informes Basicos");
		menuBasicReports.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-document-24.png")));
		menuReports.add(menuBasicReports);
		
		menuPersonalizedReports = new JMenuItem("Informes Personalizados");
		menuPersonalizedReports.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-document-24.png")));
		menuReports.add(menuPersonalizedReports);
		
		menuSettings = new JMenu("Ajustes");
		menuSettings.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuSettings);
		
		menuSelectLanguage = new JMenu("Seleccionar Idioma");
		menuSelectLanguage.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-translation-24.png")));
		menuSettings.add(menuSelectLanguage);
		
		mntmNewMenuItem_3 = new JMenuItem("Ingl\u00E9s");
		mntmNewMenuItem_3.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/gb_icon.jpg")));
		menuSelectLanguage.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Espa\u00F1ol");
		mntmNewMenuItem_4.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/esp_icon.jpg")));
		menuSelectLanguage.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Gallego");
		mntmNewMenuItem_5.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/2560px-Flag_of_Galicia.svg (2).png")));
		menuSelectLanguage.add(mntmNewMenuItem_5);
		
		menuHelp = new JMenu("Ayuda");
		menuHelp.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuHelp);
		
		menuHelpContents = new JMenuItem("Contenido de ayuda");
		menuHelpContents.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-help-24.png")));
		menuHelp.add(menuHelpContents);
		
		menuTecnicalManual = new JMenuItem("Manual tecníco");
		menuTecnicalManual.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-help-24.png")));
		menuHelp.add(menuTecnicalManual);
	}
	private void setImageSlider(int index){
		Image img = null;
		Image newImg;
		ImageIcon icon = new ImageIcon(getClass().getResource(imgList[index]));
		img = icon.getImage();
		//newImg = img.getScaledInstance(imgSlider.getWidth(), imgSlider.getHeight(), Image.SCALE_SMOOTH);
		newImg = img.getScaledInstance(400,700, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newImg);
        imgSlider.setIcon(finalImg);
    }
	
	private void setBottomImg(){
		Image img = null;
		Image newImg;
		ImageIcon icon = new ImageIcon(HomeUI.class.getResource("/resources/bottom_banner.jpg"));
		img = icon.getImage();
		//newImg = img.getScaledInstance(imgSlider.getWidth(), imgSlider.getHeight(), Image.SCALE_SMOOTH);
		newImg = img.getScaledInstance(900,200, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newImg);
        //btmLabel.setIcon(finalImg);
    }
	
	private void setCenterImg(){
		Image img = null;
		Image newImg;
		ImageIcon icon = new ImageIcon(HomeUI.class.getResource("/resources/background.jpg"));
		img = icon.getImage();
		newImg = img.getScaledInstance(imgSlider.getWidth(), imgSlider.getHeight(), Image.SCALE_SMOOTH);
		//newImg = img.getScaledInstance(900,200, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newImg);
        imgSlider.setIcon(finalImg);
    }
	
	private void setBackgroundImage() {
		ImageIcon img = new ImageIcon(HomeUI.class.getResource("/resources/backgroundd.jpg"));
		  mainPanel = new JPanel()
		  {
		     @Override
		     protected void paintComponent(Graphics g)
		     {
		        super.paintComponent(g);
		        g.drawImage(img.getImage(), 0,0, null);
		     }
		  };
	}
}
