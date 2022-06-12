package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Timer;

import javax.swing.JPanel;

import es.daumienebi.comicmanagement.controllers.HomeUIController;
import es.daumienebi.comicmanagement.services.impl.ComicService;
import es.daumienebi.comicmanagement.utils.Constants;
import es.daumienebi.comicmanagement.utils.Translator;

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
import javax.swing.JToggleButton;
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
	public static JMenu menuBasicReports;
	public static JMenuItem menuPersonalizedReports;
	public static JMenuItem menuAddConnection;
	public static JMenu menuSelectLanguage;
	public static JMenuItem menuEnglish;
	public static JMenuItem menuSpanish;
	public static JMenuItem menuGalician;
	public static JMenuItem menuPersonalizedR_collection;
	public static JMenuItem menuPersonalizedR_comic;
	
	
	private boolean canOpenComicMng = true;
	private boolean canOpenCollectionMng = true;
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
		//Translator.bundle = null;
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
		
		menuAddConnection = new JMenuItem("Añadir conexión");
		menuAddConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigUI ui = new ConfigUI();
				ui.setModal(true);
				ui.setLocationRelativeTo(frame);
				ui.setVisible(true);
			}
		});
		menuAddConnection.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-add-database-24.png")));
		menuConnection.add(menuAddConnection);
		
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
				if(canOpenCollectionMng) {
					CollectionManagementUI ui = new CollectionManagementUI();
					ui.setLocationRelativeTo(frame);
					ui.setMinimumSize(Constants.collectionManagementMinimumSize);
					ui.setVisible(true);
					canOpenCollectionMng = false;
					//Add a window listener to the opened ui to know when it is closed
					ui.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent windowEvent) {
			            	canOpenCollectionMng = true;
			              ui.setEnabled(false);
			            }
			          });
				}else {
					JOptionPane.showMessageDialog(null, "La ventana de gestión de colecciones ya se encuentra abierta","Pestaña abierta", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
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
				
				if(canOpenComicMng) {
					ComicManagementUI ui = new ComicManagementUI();
					ui.setLocationRelativeTo(frame);
					ui.setMinimumSize(Constants.comicManagementMinimumSize);
					ui.setVisible(true);
					canOpenComicMng = false;
					//Add a window listener to the opened ui to know when it is closed
					ui.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent windowEvent) {
			            	canOpenComicMng = true;
			              ui.setEnabled(false);
			            }
			          });
				}else {
					JOptionPane.showMessageDialog(null, "La ventana de gestión de comics ya se encuentra abierta","Pestaña abierta", JOptionPane.INFORMATION_MESSAGE);
				}
				//canOpenComigMng = false;
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
		
		menuPersonalizedR_collection = new JMenuItem("Colecci\u00F3nes");
		menuBasicReports.add(menuPersonalizedR_collection);
		
		menuPersonalizedR_comic = new JMenuItem("Comics");
		menuBasicReports.add(menuPersonalizedR_comic);
		
		menuPersonalizedReports = new JMenuItem("Informes Personalizados");
		menuPersonalizedReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalizedReportsUI ui = new PersonalizedReportsUI();
				ui.setLocationRelativeTo(frame);
				ui.setMinimumSize(Constants.comicManagementMinimumSize);
				ui.setVisible(true);
			}
		});
		menuPersonalizedReports.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-document-24.png")));
		menuReports.add(menuPersonalizedReports);
		
		menuSettings = new JMenu("Ajustes");
		menuSettings.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		menuBar.add(menuSettings);
		
		menuSelectLanguage = new JMenu("Seleccionar Idioma");
		menuSelectLanguage.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/icons8-translation-24.png")));
		menuSettings.add(menuSelectLanguage);
		
		menuEnglish = new JMenuItem("Ingl\u00E9s");
		menuEnglish.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/gb_icon.jpg")));
		menuSelectLanguage.add(menuEnglish);
		
		menuSpanish = new JMenuItem("Espa\u00F1ol");
		menuSpanish.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/esp_icon.jpg")));
		menuSelectLanguage.add(menuSpanish);
		
		menuGalician = new JMenuItem("Gallego");
		menuGalician.setIcon(new ImageIcon(HomeUI.class.getResource("/resources/2560px-Flag_of_Galicia.svg (2).png")));
		menuSelectLanguage.add(menuGalician);
		
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
	
	/*
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
	*/
	/*
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
	*/
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
