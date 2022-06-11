package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class ComicDetailsUI extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComicDetailsUI dialog = new ComicDetailsUI();
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
	public ComicDetailsUI() {
		setBounds(100, 100, 450, 300);

	}

}
