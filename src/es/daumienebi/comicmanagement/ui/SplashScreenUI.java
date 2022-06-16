package es.daumienebi.comicmanagement.ui;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.SplashScreenUtil;

public class SplashScreenUI {
	private static boolean DEBUG_MODE = Configuration.debug_mode;
	
	public static void main(String [] args) {
		if(DEBUG_MODE) {
			HomeUI mainScreen = new HomeUI();
			mainScreen.frame.setLocationRelativeTo(mainScreen.frame);					
			mainScreen.frame.setVisible(true);	
		}else {
			try {
				SplashScreenUtil splash = new SplashScreenUtil();
				splash.setLocationRelativeTo(splash);
				splash.setVisible(true);
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
	
}
