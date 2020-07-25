package model;

import java.sql.*;
import model.connection.DBConnection;

public class UserModel {
	
	static DBConnection database = null;
	
	public static User getUserById(int id) {
		ResultSet userData = null;
		User user = null;
		Connection conn;
		database = new DBConnection();
		PreparedStatement requestUser = null;
		String query = "SELECT username, password, name, lastName, idProfilePhoto, idCoverPhoto"
				+ " FROM users WHERE id = ?";
		
		try {
			//String profilePhoto, coverPhoto;
			conn = database.getConnection();
			requestUser = conn.prepareStatement(query);
			requestUser.setInt(1, id);
			userData = requestUser.executeQuery();
			
			if (userData.next()) {
				user = new User(id);
				user.setUsername(userData.getString("username"));
				user.setPassword(userData.getString("password"));
				user.setName(userData.getString("name"));
				user.setLastName(userData.getString("lastname"));
			}
			
			return user;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			database.closeConnection();
		}
	}
	
	public static User getUserByUsername(String username) {
		ResultSet userData = null;
		User user = null;
		Connection conn;
		database = new DBConnection();
		PreparedStatement requestUser = null;
		String query = "SELECT id, password, name, lastName, idProfilePhoto, idCoverPhoto"
				+ " FROM users WHERE username = ?";
		
		try {
			
			conn = database.getConnection();
			requestUser = conn.prepareStatement(query);
			requestUser.setString(1, username);
			userData = requestUser.executeQuery();
			//userData = getUser(query, new String[] {username});
			//String profilePhoto, coverPhoto;
			
			if (userData.next()) {
				user = new User(userData.getInt("id"));
				user.setUsername(username);
				user.setPassword(userData.getString("password"));
				user.setName(userData.getString("name"));
				user.setLastName(userData.getString("lastname"));
			}
			
			return user;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			database.closeConnection();
		}
		
	}
	

	
	// getUsersByName
}
