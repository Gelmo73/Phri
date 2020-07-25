package model.connection;

import java.sql.*;

public class DBConnection {
	
	private Connection conn = null;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		conn = MySQLConnection.getConnection();
		return conn;
	}
	
	public void closeConnection() {
		try {
			if(!conn.isClosed() && !(conn == null)) conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
