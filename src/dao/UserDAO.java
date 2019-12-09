package dao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Users;

public class UserDAO implements Serializable {

	PreparedStatement ps;
	
	private static final long serialVersionUID = 1L;
	
	
	public boolean addUser (Connection con, Users user) {
		boolean success=false;
		
		try {
			String sql = "INSERT into Users (username, role, password)" 
					+ "VALUES(?,?,?)";
			
			ps= con.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setInt(2, user.getRole());
			ps.setString(3, user.getPassword());
			
			
			ps.executeUpdate();
			success=true;
			
		} catch(SQLException e) {
			System.err.println();
		}
		try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		return success;
	}
	
	public boolean updateUser(Connection conn, String username, String password) {
		boolean success= false;
		
		try {
			String sql = " UPDATE users " +
					"SET password = ? " +
					" WHERE username= ? ;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			
			ps.executeUpdate();
			
			success= true;
	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	public boolean updateDate(Connection conn, String username, String date) {
		boolean success= false;
	
		try {
			String sql = " UPDATE users " +
					"SET dateOfLastLogin = ? " +
					" WHERE username= ? ;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, date);
			ps.setString(2, username);
			
			ps.executeUpdate();
			
			success= true;
	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	

}
