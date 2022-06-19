package es.daumienebi.comicmanagement.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportsUtil{
	private static String REPORT_ROUTE = "";
	
	private static void getReportRoute() {
		if(Configuration.debug_mode) {
			REPORT_ROUTE =  System.getProperty("user.dir") + "\\src\\es\\daumienebi\\comicmanagement\\reports\\";		
		}else
			REPORT_ROUTE =  "./reports/";
	}
	
	/**
	 * 
	 * @param rutaInforme - The route where the report is stored
	 */
	public static void viewReport(String reportName) {
		getReportRoute();
		try {
			//Compile the report
			JasperReport report = JasperCompileManager.compileReport(REPORT_ROUTE+reportName);
			
			//Fill the report
			JasperPrint viewer = JasperFillManager.fillReport(report,null,DbConnection.getConnection());
				
			//View the report
			JasperViewer.viewReport(viewer,false);
				
		}catch (JRException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void viewPersonalizedReport1(String reportName,int year) {
		getReportRoute();
		Connection con = null;
		String sql = "";
		PreparedStatement preparedSt;
		try {
			con = DbConnection.getConnection();
			preparedSt = con.prepareStatement(sql);
			preparedSt.setDouble(1, year);
			ResultSet rSet = preparedSt.executeQuery();
			
			JRResultSetDataSource ds = new JRResultSetDataSource(rSet);
			
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("RATING", year);
			
			//Compile the report
			JasperReport report = JasperCompileManager.compileReport(REPORT_ROUTE+reportName);
			
			//Fill the report
			JasperPrint viewer = JasperFillManager.fillReport(report,parameters,ds);
				
			//View the report
			JasperViewer.viewReport(viewer,false);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JRException e) {
			//JOptionPane.showMessageDialog(null, "Error viewing the report", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public static void viewPersonalizedReport2(String reportName, int comic_count) {
		getReportRoute();
		Connection con = null;
		String sql = "";
		PreparedStatement preparedSt;
		try {
			con = DbConnection.getConnection();
			preparedSt = con.prepareStatement(sql);
			preparedSt.setInt(1, comic_count);
			ResultSet rSet = preparedSt.executeQuery();
			
			JRResultSetDataSource ds = new JRResultSetDataSource(rSet);
			
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("PREMIERE_YEAR", comic_count);
			
			//Compile the report
			JasperReport report = JasperCompileManager.compileReport(REPORT_ROUTE+reportName);
			
			//Fill the report
			JasperPrint viewer = JasperFillManager.fillReport(report,parameters,ds);
				
			//View the report
			JasperViewer.viewReport(viewer,false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JRException e) {
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Error viewing the report", "Error", JOptionPane.ERROR_MESSAGE);

			// TODO: handle exception
		}
	}
 
	public static void viewReportWithParameters(String reportRoute,String query, HashMap<String, Object> parameters) {
		//Generic method to execute any report with parameters
	}
}
