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
	//private static String REPORT_ROUTE =  System.getProperty("user.dir") + "\\src\\es\\daumienebi\\comicmanagement\\reports\\";
	//private static String REPORT_ROUTE =  "./reports/";
	
	private static void getReportRoute() {
		if(Configuration.debug_mode) {
			REPORT_ROUTE =  "./reports/";
		}else
			REPORT_ROUTE =  System.getProperty("user.dir") + "\\src\\es\\daumienebi\\comicmanagement\\reports\\";
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
	
	public static void viewPersonalizedReport1(String reportName,double rating) {
		getReportRoute();
		Connection con = null;
		String sql = "SELECT m.*,g.name as genre_name FROM movie m"
					+ " inner join genre g"
					+ " on m.id_genero = g.id"
					+ " WHERE puntuacion > ?";
		PreparedStatement preparedSt;
		try {
			con = DbConnection.getConnection();
			preparedSt = con.prepareStatement(sql);
			preparedSt.setDouble(1, rating);
			ResultSet rSet = preparedSt.executeQuery();
			
			JRResultSetDataSource ds = new JRResultSetDataSource(rSet);
			
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("RATING", rating);
			
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
	
	public static void viewPersonalizedReport2(String reportName, int year) {
		getReportRoute();
		Connection con = null;
		String sql = "SELECT titulo,duracion,puntuacion,g.name,fecha_estreno FROM movie m"
					+ " INNER JOIN genre g"
					+ " ON(m.id_genero = g.id)"
					+ " WHERE YEAR(fecha_estreno) = ?"
					+ " ORDER BY titulo asc"
					+ "";
		PreparedStatement preparedSt;
		try {
			con = DbConnection.getConnection();
			preparedSt = con.prepareStatement(sql);
			preparedSt.setInt(1, year);
			ResultSet rSet = preparedSt.executeQuery();
			
			JRResultSetDataSource ds = new JRResultSetDataSource(rSet);
			
			//define a HashMap to get the parameters for the report
			HashMap<String,Object> parameters = new HashMap<String,Object>();
			parameters.put("PREMIERE_YEAR", year);
			
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
