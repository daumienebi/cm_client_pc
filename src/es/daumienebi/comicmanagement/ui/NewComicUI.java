package es.daumienebi.comicmanagement.ui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JDialog;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;

import es.daumienebi.comicmanagement.controllers.NewComicUIController;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.utils.Constants.ComicState;

import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class NewComicUI extends JDialog {
	
	public static JLabel NewComicUI_comicName;
	public static JLabel NewComicUI_comicCollection;
	public static JLabel NewComicUI_comicAdquisitionDate;
	public static JLabel NewComicUI_comicState;
	public static JLabel NewComicUI_comicNumber;
	public static String NewComicUI_windowTitle = "Añadir Nuevo Comic";
	public static String NewComicUI_newComic = "Comic Nuevo";
	
	private JButton btnComicPoster;
	private JPanel dataPanel;
	private JTextField txtName;
	private JTextField txtDay;
	private JTextField txtComicNumber;
	private JTextField textField;
	private DatePicker datePicker;
	private LocalDate selectedDate;
	
	Comic comic;
	private String imageName = "";
	private File imgFile;
	
	//Controller
	private NewComicUIController controller = new NewComicUIController();
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewComicUI dialog = new NewComicUI();
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
	public NewComicUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewComicUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 943, 580);
		setTitle(NewComicUI_windowTitle);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton NewComicUI_btnAddComic = new JButton("A\u00F1adir Comic");
		NewComicUI_btnAddComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDate = datePicker.getDate();
			}
		});
		panel.add(NewComicUI_btnAddComic);
		
		JButton NewComicUI_btnSaveComic = new JButton("Guardar Comic");
		panel.add(NewComicUI_btnSaveComic);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.WEST);
		
		btnComicPoster = new JButton("");
		btnComicPoster.setBorder(null);
		btnComicPoster.setMargin(new Insets(0, 0, 0, 0));
		btnComicPoster.setBounds(20,20,300,500);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/add_image.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(btnComicPoster.getWidth(),btnComicPoster.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		btnComicPoster.setIcon(icon);
		JButton btnAddComicPoster = new JButton("");
		btnAddComicPoster.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddComicPoster.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-compact-camera-40.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(1)
					.addComponent(btnComicPoster)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddComicPoster)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(226)
							.addComponent(btnAddComicPoster))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(21)
							.addComponent(btnComicPoster)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		dataPanel = new JPanel();
		getContentPane().add(dataPanel, BorderLayout.CENTER);
		dataPanel.setBorder(BorderFactory.createTitledBorder(null, NewComicUI_newComic,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblCollection = new JLabel("COLECCI\u00D3N");
		lblCollection.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtDay = new JTextField();
		txtDay.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("FECHA ADQUISICI\u00D3N");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		datePicker =new DatePicker();
		datePicker.setDateToToday();
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NUMERO");
		lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtComicNumber = new JTextField();
		txtComicNumber.setColumns(10);
		
		JComboBox cmbState = new JComboBox();
		cmbState.setModel(new DefaultComboBoxModel(ComicState.values()));
		
		JButton btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("ESTADO");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(NewComicUI.class.getResource("/resources/icons8-search-24.png")));
		GroupLayout gl_dataPanel = new GroupLayout(dataPanel);
		gl_dataPanel.setHorizontalGroup(
			gl_dataPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dataPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
											.addComponent(lblCollection, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
										.addGap(39))
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))
							.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addComponent(cmbState, 0, 312, Short.MAX_VALUE))))
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))))
					.addGap(0))
		);
		gl_dataPanel.setVerticalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1))
						.addComponent(lblCollection))
					.addGap(43)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_1_1))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_1_1_1))
						.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(35)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		dataPanel.setLayout(gl_dataPanel);
	}
}
