package de.project;
import java.sql.*;

public class DataBase_Connector {
	
	private static String dbPath = "";
	private static Connection connDB = null;
	
	public static Connection getConnDB() {
		
			return connDB;
		}
	
	public static void setDbPath(String path) {
		dbPath = path;
	}
	
	static void connectDB() {
	 try {
		Class.forName("org.sqlite.JDBC");
		connDB = DriverManager.getConnection("jdbc:sqlite:dbPath");	
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("SQL Problem");
	}
	
	 
	}

	

}
