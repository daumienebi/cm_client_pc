package es.daumienebi.comicmanagement.views;

import java.sql.Connection;

import es.daumienebi.comicmanagement.utils.SplashScreenUtil;

public class SplashScreenUI {

	public static void main(String [] args) {
		SplashScreenUtil splash = new SplashScreenUtil();
		splash.setLocationRelativeTo(splash);
		splash.setVisible(true);
		
		try {		
			for(int i = 0; i <= 100; i++) {
				Thread.sleep(50);
				SplashScreenUtil.lblLoading.setText(""+i+"%");
				SplashScreenUtil.progressBar.setValue(i);
				if(i == 10) {
					SplashScreenUtil.lblDetail.setText("Starting app...");
				}
				
				if(i == 50) {
					SplashScreenUtil.lblDetail.setText("Loading app properties...");
				}
				
				if(i == 80) {
					SplashScreenUtil.lblDetail.setText("Checking database connection...");
				} 
				
				if(i ==100) {
					
					SplashScreenUtil.lblDetail.setText("Connecting to database...");
					HomeUI mainScreen = new HomeUI();
					//mainScreen.disableMenus();
					mainScreen.frame.setLocationRelativeTo(mainScreen.frame);					
					splash.dispose();
					mainScreen.frame.setVisible(true);
					
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}