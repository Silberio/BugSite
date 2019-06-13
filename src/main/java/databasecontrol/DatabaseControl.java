package databasecontrol;

import java.sql.Connection;

public class DatabaseControl {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/KaufenListDB";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   //	Connection session
	   private static Connection conn = null;

	   
	   
}
