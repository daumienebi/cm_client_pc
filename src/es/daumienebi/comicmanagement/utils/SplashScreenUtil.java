package es.daumienebi.comicmanagement.utils;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.daumienebi.comicmanagement.ui.HomeUI;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class SplashScreenUtil extends JFrame {

	private JPanel contentPane;
	public static JLabel lblLoading;
	public static JProgressBar progressBar;
	private JLabel lblNewLabel;
	public static JLabel lblDetail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreenUtil frame = new SplashScreenUtil();
					frame.setVisible(true);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreenUtil() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SplashScreenUtil.class.getResource("/resources/logo.png")));
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 321);
		//contentPane = new JPanel();
		ImageIcon img2 = new ImageIcon(HomeUI.class.getResource("/resources/back.jpeg"));
		contentPane = new JPanel()
		  {
		     @Override
		     protected void paintComponent(Graphics g)
		     {
		        super.paintComponent(g);
		        g.drawImage(img2.getImage(), 0,0, null);
		     }
		  };
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLoading = new JLabel("10");
		lblLoading.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoading.setBounds(290, 204, 45, 35);
		contentPane.add(lblLoading);
		
		JLabel lblNewLabel_1 = new JLabel("COMIC MANAGEMENT");
		lblNewLabel_1.setBackground(new Color(169, 169, 169));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(123, 11, 380, 65);
		contentPane.add(lblNewLabel_1);
		
		/*
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(10, 11, 77, 65);
		contentPane.add(lblIcon);
		ImageIcon default_icon = new ImageIcon(getClass().getResource("/resources/comic-icon_128.png"));
	
		Image img = default_icon.getImage();
		//Rescale the image
		Image imgNuevo = img.getScaledInstance(70,50,  java.awt.Image.SCALE_SMOOTH );
		default_icon =new ImageIcon(imgNuevo);
		lblIcon.setIcon(default_icon);
		*/
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(135, 206, 235));
		progressBar.setBounds(191, 240, 230, 27);
		contentPane.add(progressBar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(SplashScreenUtil.class.getResource("/resources/loading.gif")));
		lblNewLabel.setBounds(112, 95, 380, 88);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 128, 128));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(191, 275, 230, 27);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblDetail = new JLabel("");
		lblDetail.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblDetail);
		lblDetail.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblDetail.setForeground(new Color(255, 255, 255));
	}
}
