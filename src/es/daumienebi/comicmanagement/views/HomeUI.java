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
	
	private JFrame frame;
	private JLabel imgSlider;
	
	//Image
	Timer tm;
	int imgPos = 0;
	
	String[] imgList = HomeUIController.getImages();
	
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(HomeUI.class.getResource("/resources/logo_book.png")));
		frame.setBounds(100, 100, 1300,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		
		//JPanel mainPanel = new JPanel();
		ImageIcon img = new ImageIcon(HomeUI.class.getResource("/resources/background5.jpg"));
		  JPanel mainPanel = new JPanel()
		  {
		     @Override
		     protected void paintComponent(Graphics g)
		     {
		        super.paintComponent(g);
		        g.drawImage(img.getImage(), 0, 0, null);
		     }
		  };
		mainPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		imgSlider = new JLabel("");
		imgSlider.setHorizontalTextPosition(SwingConstants.CENTER);
		imgSlider.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(imgSlider, BorderLayout.CENTER);
		imgSlider.setBounds(40, 30, 700, 300);
		//setCenterImg();
        //Set a timer to slide through the images
        tm = new Timer(2500,new ActionListener() {
        	//add only
            @Override
            public void actionPerformed(ActionEvent e) {
            	setImageSize(imgPos);
                imgPos += 1;
                if(imgPos >= imgList.length)
                	imgPos = 0; 
            }
        });
		tm.start();
		setImageSize(0);
		
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
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		menuOptionExit = new JMenuItem("Exit");
		mnNewMenu.add(menuOptionExit);
		menuOptionExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Close the window
				int option;
				//JOptionPane.setDefaultLocale(Locale.ENGLISH);
				option =JOptionPane.showConfirmDialog(frame,"Are you sure you want to exit the app ?","Exit",JOptionPane.INFORMATION_MESSAGE);
				
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {}
					//do nothing				
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Connection");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Collections");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Add Collection");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Collection Management");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_8 = new JMenu("Comics");
		mnNewMenu_8.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Comic");
		mnNewMenu_8.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Comic Management");
		mnNewMenu_8.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Autors");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Clients");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_4);
		
		JMenu mnNewMenu_7 = new JMenu("Reports");
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_7);
		
		JMenu mnNewMenu_5 = new JMenu("Settings");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Select Language");
		mnNewMenu_5.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_6 = new JMenu("Help");
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Help Contents");
		mnNewMenu_6.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tecnical Manual");
		mnNewMenu_6.add(mntmNewMenuItem_7);
	}
	public void setImageSize(int index){
		Image img = null;
		Image newImg;
		ImageIcon icon = new ImageIcon(getClass().getResource(imgList[index]));
		img = icon.getImage();
		//newImg = img.getScaledInstance(imgSlider.getWidth(), imgSlider.getHeight(), Image.SCALE_SMOOTH);
		newImg = img.getScaledInstance(400,700, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newImg);
        imgSlider.setIcon(finalImg);
    }
	
	public void setBottomImg(){
		Image img = null;
		Image newImg;
		ImageIcon icon = new ImageIcon(HomeUI.class.getResource("/resources/bottom_banner.jpg"));
		img = icon.getImage();
		//newImg = img.getScaledInstance(imgSlider.getWidth(), imgSlider.getHeight(), Image.SCALE_SMOOTH);
		newImg = img.getScaledInstance(900,200, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newImg);
        //btmLabel.setIcon(finalImg);
    }
	
	public void setCenterImg(){
		Image img = null;
		Image newImg;
		ImageIcon icon = new ImageIcon(HomeUI.class.getResource("/resources/background.jpg"));
		img = icon.getImage();
		newImg = img.getScaledInstance(imgSlider.getWidth(), imgSlider.getHeight(), Image.SCALE_SMOOTH);
		//newImg = img.getScaledInstance(900,200, Image.SCALE_SMOOTH);
        ImageIcon finalImg = new ImageIcon(newImg);
        imgSlider.setIcon(finalImg);
    }
	
	
}
