package de.project;
import java.sql.*;

// stellt verbindung zur gewählten DB her und stellt diese zur Verfügung 


public class DataBase_Connector {
	
	private static String dbPath = null;
	private static Connection connDB = null;

	
	
	public static Connection getConnDB() {
		
			return connDB;
			
		}
	
	public static String getDbPath() {
		
		return  dbPath;
	}
	
	public static void setDbPath(String path) {
		dbPath = path;
	}
	
	public static void connectDB()	{
	// stellt für den Driver Manager den String zum Verbinden zur Verfügung
		
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:sqlite:");
		sb.append(dbPath);
		System.out.println(sb.toString());
		
	 try {
		Class.forName("org.sqlite.JDBC");
		connDB = DriverManager.getConnection(sb.toString());	
		
		
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
