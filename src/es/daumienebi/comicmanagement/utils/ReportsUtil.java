package es.daumienebi.comicmanagement.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class ReportsUtil{
	private static String REPORT_ROUTE = "";
	private static String english_folder = "";
	private static String spanish_folder = "";
	private static String galician_folder = "";
	
	private static void setReportRoute() {
		System.out.println("Debug mode :" + Configuration.debug_mode);
		if(Configuration.debug_mode) {
			spanish_folder = "\\src\\es\\daumienebi\\comicmanagement\\reports\\spanish\\";
			english_folder = "\\src\\es\\daumienebi\\comicmanagement\\reports\\english\\";
			galician_folder = "\\src\\es\\daumienebi\\comicmanagement\\reports\\galician\\";
			switch(Configuration.app_language) {
				case Spanish : REPORT_ROUTE =  System.getProperty("user.dir") + spanish_folder;
				break;
				case English : REPORT_ROUTE =  System.getProperty("user.dir") + english_folder;
				break;
				case Galician : REPORT_ROUTE =  System.getProperty("user.dir") + galician_folder;
				break;
				default : REPORT_ROUTE =  System.getProperty("user.dir") + spanish_folder;
				break;
			}		
		}else {
			spanish_folder  = "spanish/";
			english_folder  = "english/";
			galician_folder = "galician/";
			switch(Configuration.app_language) {
				case Spanish : REPORT_ROUTE =  "./reports/" + spanish_folder;
				break;
				case English : REPORT_ROUTE =  "./reports/" + english_folder;
				break;
				case Galician : REPORT_ROUTE =  "./reports/" + galician_folder;
				break;
				default : REPORT_ROUTE =  "./reports/" + english_folder;
				break;
		}
	}
}	
	/**
	 * 
	 * @param reportName - The name of the report to be loaded -- for example "Damian.jrxml"
	 */
	
	public static void viewReportWithImage(String reportName,String imageServer) {
		Connection con = null;
		setReportRoute();
		try {
			DbConnection.connect();
			con = DbConnection.getConnection();
			//Compile the report
			System.out.println(REPORT_ROUTE);
			JasperReport report = JasperCompileManager.compileReport(REPORT_ROUTE + reportName);
			System.out.println(REPORT_ROUTE + reportName);
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("IMAGE_SERVER", imageServer);
			
			//Fill the report
			JasperPrint viewer = JasperFillManager.fillReport(report,parameters,DbConnection.getConnection());
			
			//View the report
			JasperViewer.viewReport(viewer,false);
				
		}catch (JRException e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error cargando el informe, por favor revise su conexión a la base de datos");
		}finally {
			if(con != null) {
				DbConnection.closeConnection();
			}	
		}
	}

	public static void viewPersonalizedReport1(String reportName,String comic_state,String imageServer) {
		setReportRoute();
		Connection con = null;
		String sql = "SELECT c.name,c.image,c.adquisition_date,c.number,c.state, cc.name AS collection FROM comic c"
				+ " INNER JOIN collection cc"
				+ " ON(c.collection_id = cc.id)"
				+ " WHERE state = ?"
				+ " ORDER BY c.name";
		PreparedStatement preparedSt;
		try {
			DbConnection.connect();
			con = DbConnection.getConnection();
			preparedSt = con.prepareStatement(sql);
			preparedSt.setString(1, comic_state);
			ResultSet rSet = preparedSt.executeQuery();
			
			JRResultSetDataSource ds = new JRResultSetDataSource(rSet);
			
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("IMAGE_SERVER", imageServer);
			parameters.put("COMIC_STATE", comic_state);
			
			//Compile the report
			JasperReport report = JasperCompileManager.compileReport(REPORT_ROUTE + reportName);
			
			//Fill the report
			JasperPrint viewer = JasperFillManager.fillReport(report,parameters,ds);
				
			//View the report
			JasperViewer.viewReport(viewer,false);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error cargando el informe, por favor revise su conexión a la base de datos");
		}catch (JRException e) {
			//JOptionPane.showMessageDialog(null, "Error viewing the report", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public static void viewPersonalizedReport2(String reportName, int comic_count,String imageServer) {
		setReportRoute();
		Connection con = null;
		String sql = "SELECT cc.*, COUNT(*) AS comic_count FROM collection cc INNER JOIN comic c"
				+ " ON c.collection_id = cc.id"
				+ " GROUP BY cc.id"
				+ " HAVING comic_count >= ?"
				+ " ORDER BY comic_count desc";
		PreparedStatement preparedSt;
		try {
			DbConnection.connect();
			con = DbConnection.getConnection();
			preparedSt = con.prepareStatement(sql);
			preparedSt.setInt(1, comic_count);
			ResultSet rSet = preparedSt.executeQuery();
			
			JRResultSetDataSource ds = new JRResultSetDataSource(rSet);
			
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("IMAGE_SERVER", imageServer);
			parameters.put("COMIC_COUNT", comic_count);
			
			//Compile the report
			JasperReport report = JasperCompileManager.compileReport(REPORT_ROUTE + reportName);
			
			//Fill the report
			JasperPrint viewer = JasperFillManager.fillReport(report,parameters,ds);
				
			//View the report
			JasperViewer.viewReport(viewer,false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error cargando el informe, por favor revise su conexión a la base de datos");
		}catch (JRException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error viewing the report", "Error", JOptionPane.ERROR_MESSAGE);

			// TODO: handle exception
		}
	}
 
	public static void viewReportWithParameters(String reportRoute,String query, HashMap<String, Object> parameters) {
		//Generic method to execute any report with parameters
	}
}
