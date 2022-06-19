package es.daumienebi.comicmanagement.ui;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.JDialog;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;

import es.daumienebi.comicmanagement.controllers.ComicDetailsUIController;
import es.daumienebi.comicmanagement.models.Comic;
import es.daumienebi.comicmanagement.utils.Configuration;
import es.daumienebi.comicmanagement.utils.Translator;
import es.daumienebi.comicmanagement.utils.Constants.ComicState;

import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;

public class ComicDetailsUI extends JDialog {
	
	public static JLabel NewComicUI_comicName;
	public static JLabel NewComicUI_comicCollection;
	public static JLabel NewComicUI_comicAdquisitionDate;
	public static JLabel NewComicUI_comicState;
	public static JLabel NewComicUI_comicNumber;
	public static String NewComicUI_newComic = "Detalles Comic";
	
	private JButton btnComicPoster;
	private JPanel dataPanel;
	private JTextField txtName;
	private JTextField txtDay;
	private JTextField txtComicNumber;
	private JTextField txtColeccion;
	private DatePicker datePicker;
	private LocalDate selectedDate;
	JComboBox<ComicState> cmbState;
	
	ComicDetailsUIController controller = new ComicDetailsUIController();
	
	public ComicDetailsUI(Comic comic) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		Inicialize(comic);
		translate();
	}
	
	void Inicialize(Comic comic) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewComicUI.class.getResource("/resources/comic-icon_128.png")));
		setBounds(100, 100, 943, 580);
		setTitle(comic.getName());
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.WEST);
		
		btnComicPoster = new JButton("");
		btnComicPoster.setMargin(new Insets(0, 0, 0, 0));
		btnComicPoster.setBounds(20,20,350,470);
		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/deadpool_collection.jpg"));
		Image img = icon.getImage();
		Image imgNuevo = img.getScaledInstance(btnComicPoster.getWidth(),btnComicPoster.getHeight(),  java.awt.Image.SCALE_SMOOTH );
		icon =new ImageIcon(imgNuevo);
		btnComicPoster.setIcon(icon);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(1)
					.addComponent(btnComicPoster)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addComponent(btnComicPoster)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		dataPanel = new JPanel();
		getContentPane().add(dataPanel, BorderLayout.CENTER);
		dataPanel.setBorder(BorderFactory.createTitledBorder(null, NewComicUI_newComic,TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 18))); 
		
		NewComicUI_comicName = new JLabel("NOMBRE");
		NewComicUI_comicName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		
		NewComicUI_comicCollection = new JLabel("COLECCI\u00D3N");
		NewComicUI_comicCollection.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtDay = new JTextField();
		txtDay.setColumns(10);
		
		NewComicUI_comicAdquisitionDate = new JLabel("FECHA ADQUISICI\u00D3N");
		NewComicUI_comicAdquisitionDate.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		datePicker =new DatePicker();
		datePicker.getComponentToggleCalendarButton().setEnabled(false);
		datePicker.getComponentDateTextField().setEditable(false);
		datePicker.setDateToToday();
		datePicker.setEnabled(false);
		NewComicUI_comicNumber = new JLabel("NUMERO");
		NewComicUI_comicNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtComicNumber = new JTextField();
		txtComicNumber.setEditable(false);
		txtComicNumber.setColumns(10);
		
		cmbState = new JComboBox();
		cmbState.setEnabled(false);
		cmbState.setModel(new DefaultComboBoxModel(ComicState.values()));
		
		NewComicUI_comicState = new JLabel("ESTADO");
		NewComicUI_comicState.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		
		txtColeccion = new JTextField();
		txtColeccion.setEditable(false);
		txtColeccion.setColumns(10);
		GroupLayout gl_dataPanel = new GroupLayout(dataPanel);
		gl_dataPanel.setHorizontalGroup(
			gl_dataPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addComponent(NewComicUI_comicState)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_dataPanel.createSequentialGroup()
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(NewComicUI_comicName)
									.addComponent(NewComicUI_comicAdquisitionDate, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addComponent(NewComicUI_comicCollection, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
								.addGap(39))
							.addGroup(gl_dataPanel.createSequentialGroup()
								.addComponent(NewComicUI_comicNumber, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))))
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
							.addComponent(txtColeccion, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
							.addGroup(gl_dataPanel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_dataPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(cmbState, 0, 312, Short.MAX_VALUE)
									.addGroup(gl_dataPanel.createSequentialGroup()
										.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 271, Short.MAX_VALUE)))))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addGap(0))
		);
		gl_dataPanel.setVerticalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(9)
							.addComponent(NewComicUI_comicName))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(NewComicUI_comicCollection)
						.addComponent(txtColeccion, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(11)
							.addComponent(NewComicUI_comicAdquisitionDate))
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.BASELINE, false)
						.addGroup(gl_dataPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(NewComicUI_comicNumber))
						.addComponent(txtComicNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbState, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(NewComicUI_comicState))
					.addGap(104))
		);
		dataPanel.setLayout(gl_dataPanel);
		setValues(comic);
	}
	
	private void setValues(Comic comic) {
		txtName.setText(comic.getName());
		txtComicNumber.setText(String.valueOf(comic.getNumber()));
		txtColeccion.setText(controller.getCollectionName(comic));
		datePicker.setDate(comic.getAdquisition_date().toLocalDate());
		switch(comic.getState()) {
			case "Bueno": cmbState.setSelectedItem(ComicState.Bueno);
			break;
			case "Malo" : cmbState.setSelectedItem(ComicState.Malo);
			break;
			case "Nuevo": cmbState.setSelectedItem(ComicState.Nuevo);
			break;
			//the breaks are necessary to correctly view the values
			default : cmbState.setSelectedItem(ComicState.SinEstado);
		}
		btnComicPoster.setIcon(controller.getComicsImage(comic.getImage()));
		
	}
	
	private void translate() {
		if(Translator.bundle != null) {
			Translator.translateComicDetailsUI(Configuration.app_language);
		}
	}
}
