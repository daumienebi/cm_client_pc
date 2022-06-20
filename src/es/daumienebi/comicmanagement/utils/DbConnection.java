package es.daumienebi.comicmanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbConnection {
	private static Connection con;

	public static Connection connect(){        
        try
        {
        	userConnection();        	
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "The JDBC library was not found");
        } catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null,"Error in the database connection, please check your settings.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
	}
    
    private static Connection userConnection() throws ClassNotFoundException, SQLException {
    	Class.forName("org.mariadb.jdbc.Driver");
		//Class.forName("com.mysql.cj.jdbc.Driver");
    	String urlCon="jdbc:mariadb://"+Configuration.db_ip+":"+Configuration.db_port+"/"+Configuration.db_name;
        con=DriverManager.getConnection(urlCon, Configuration.db_user, Configuration.db_password);
        con.setAutoCommit(false);          
        return con;
    }
    
     
    public static Connection getConnection(){
    	return con != null ? con : null;
    }
    
    public static void setToNull(){
    	con = null;
    }
    
    public static void closeConnection() {
    	try {
			con.close();
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, "Error closing the connection");
		}
    }
}
