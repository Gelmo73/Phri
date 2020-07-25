package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection{

	// Using mysql-connector-java-8.0.20
	private static final String USER = "root";
	private static final String PASSWORD = "zshTEXlYJUh6SDhA";
	private static final String BDNAME = "phri";
	private static final String TIMEZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String URL = "jdbc:mysql://localhost:3306/" + BDNAME + TIMEZONE;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}

}
