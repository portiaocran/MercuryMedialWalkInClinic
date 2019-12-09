package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Practitioners;

public class PractitionerDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Practitioners p1;
	PreparedStatement ps;
	ResultSet rs;
	
	public Practitioners getPractitioners(Connection conn, String username) {
	
		try {
		
			String sql = "SELECT * FROM practitioners WHERE login= ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				int cpso= rs.getInt("CPSO");
				String fName = rs.getString("FirstName");
				String midInt = rs.getString("MiddleInitials");
				String lName = rs.getString("LastName");
				String login = rs.getString("Login");
				int pracAdd = rs.getInt("PrimaryPracticeAddress");
				String pracName = rs.getString("PracticeName");
				
				p1 = new Practitioners(fName, midInt, lName, login,pracName, cpso, pracAdd);		
			}	
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("practitioner not retrieved");
			
		}
		
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return p1;	
		
	}
	
	public Practitioners getPractitioners(Connection conn, String username, String password) {
		
		try {
		
			String sql = "SELECT * FROM practitioners p" +
					" INNER JOIN users u " +
					" ON u.username = p.Login " +
					" WHERE u.username = ? AND u.password = ?;";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				int cpso= rs.getInt("CPSO");
				String fName = rs.getString("FirstName");
				String midInt = rs.getString("MiddleInitials");
				String lName = rs.getString("LastName");
				String login = rs.getString("Login");
				int pracAdd = rs.getInt("PrimaryPracticeAddress");
				String pracName = rs.getString("PracticeName");
				
				p1 = new Practitioners(fName, midInt, lName, login,pracName, cpso, pracAdd);		
			}	
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("practitioner not retrieved");
			
		}
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p1;	
		
	}
	
	
	public boolean addPractitioner (Connection conn, Practitioners practit) {
		
		boolean success= false;
		
		try {
			String sql = "INSERT INTO practitioners (CPSO, FirstName, MiddleInitials, LastName, Login," + 
					"PrimaryPracticeAddress, PracticeName) VALUES (?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, practit.getCPSO());
			ps.setString(2, practit.getFirstName());
			ps.setString(3, practit.getMiddleInitials());
			ps.setString(4, practit.getLastName());
			ps.setString(5, practit.getUserName());
			ps.setInt(6, practit.getAddress());
			ps.setString(7, practit.getPracticeName());
			
			ps.executeUpdate();
			
			success= true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("doctor not added");
		}
		try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}
}
