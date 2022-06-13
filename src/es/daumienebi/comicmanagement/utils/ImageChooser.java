package es.daumienebi.comicmanagement.utils;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ImageChooser util class
 * @author Daumienebi Sakpa
 *
 */
public class ImageChooser {

	//maybe translate
	
	public File setImagePoster(JButton imgBtn) {
		// imgBtn -- the button where the image will be displayed
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Elegir la imagen");
		String imgRoute = "";
		File imgFile = null;
		
		//set the default location to the desktop
		String dirEsc = System.getProperty("user.home");
		jfc.setCurrentDirectory(new File(dirEsc + "/Desktop"));
		
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Filtro del imagen", "png","jpg","jpeg");
		jfc.setFileFilter(filtro);
		int option = jfc.showOpenDialog(jfc);
		if(option == JFileChooser.APPROVE_OPTION) {
			imgRoute = jfc.getSelectedFile().getAbsolutePath();
			imgFile = jfc.getSelectedFile();
		}		
		//check if the imgRoute is not null before placing the button
		
		if(!imgRoute.isEmpty()) {
			//Obtain the default icon to be used in-case the imgRoute is empty
			ImageIcon icon = new ImageIcon(imgRoute);
			Image img = icon.getImage();
			//re-scale the image
			Image imgNuevo = img.getScaledInstance(imgBtn.getWidth(),imgBtn.getHeight(),java.awt.Image.SCALE_SMOOTH );
			//assign the new resized image to the button
			icon =new ImageIcon(imgNuevo);
			imgBtn.setIcon(icon);
		}
		
		return imgFile;
	}
}
