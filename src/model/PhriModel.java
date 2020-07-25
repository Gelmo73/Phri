package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.connection.DBConnection;

public class PhriModel {
	
	static DBConnection database = null;

	public static List<Phris> getList() {
		ResultSet phriData = null;
		List<Phris> phris = new ArrayList<Phris>();
		Connection conn;
		database = new DBConnection();
		PreparedStatement requestPhri = null;
		String query = "SELECT id, idUser, text, date FROM phris";
		
		try {
			conn = database.getConnection();
			requestPhri = conn.prepareStatement(query);
			phriData = requestPhri.executeQuery();
			
			while (phriData.next()) {
				int id = phriData.getInt("id");
				int idUser = phriData.getInt("idUser");
				User user = UserModel.getUserById(idUser);
				String text = phriData.getString("text");
				String date = phriData.getString("date");
				Phris phri = new Phris(id, user, text, date);
				phris.add(phri);
			}
			
			return phris;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			database.closeConnection();
		}
	}
	
	public static Phris getPhriById(int id) {
		ResultSet phriData = null;
		Phris phri = null;
		Connection conn;
		database = new DBConnection();
		PreparedStatement requestPhri = null;
		String query = "SELECT id, idUser, text, date"
				+ " FROM phris WHERE id = ?";
		
		try {
			//String profilePhoto, coverPhoto;
			conn = database.getConnection();
			requestPhri = conn.prepareStatement(query);
			requestPhri.setInt(1, id);
			phriData = requestPhri.executeQuery();
			
			if (phriData.next()) {
				int idUser = phriData.getInt("idUser");
				User user = UserModel.getUserById(idUser);
				String text = phriData.getString("text");
				String date = phriData.getString("date");
				phri = new Phris(id, user, text, date);
			}
			
			return phri;
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			return null;
		} finally {
			database.closeConnection();
		}
	}

}
