package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Patients;

public class PatientDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PreparedStatement ps;
	ResultSet rs;
	Patients patient;
	
	public Patients getPatient (Connection conn, String username) {
		
		try {
			
			String sql = "SELECT * FROM Patients WHERE Login = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Long OHIP = rs.getLong("OHIPNumber");
				String OHIPVersion = rs.getString("OHIPVersion");
				String fName = rs.getString("FirstName");
				String midInitials = rs.getString("MiddleInitials");
				String lName = rs.getString("LastName");
				String userName = rs.getString("Login");
				String gender = rs.getString("Gender");
				String DOB = rs.getString("DateOfBirth");
				
				patient = new Patients (fName, midInitials, lName, userName, OHIP, OHIPVersion, gender, DOB);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
			return patient;
			
			}
	
	public Patients getPatient (Connection conn, String username, String password) {
		
		try {
			
			String sql = "SELECT * FROM patients p" +
					" INNER JOIN users u " +
					" ON u.username = p.Login " +
					" WHERE u.username = ? AND u.password = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Long OHIP = rs.getLong("OHIPNumber");
				String OHIPVersion = rs.getString("OHIPVersion");
				String fName = rs.getString("FirstName");
				String midInitials = rs.getString("MiddleInitials");
				String lName = rs.getString("LastName");
				String userName = rs.getString("Login");
				String gender = rs.getString("Gender");
				String DOB = rs.getString("DateOfBirth");
				
				patient = new Patients(fName, midInitials, lName, userName, OHIP, OHIPVersion, gender, DOB);
				
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
				}
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
			return patient;
			
			}
	
	public void updatePatient(Connection conn, String name, String ohipVer, String mid, String lName, String name2) {
		
		try {
		String sql = "UPDATE patients SET OHIPVersion = ?, FirstName= ?, MiddleInitials = ?, LastName= ? WHERE FirstName = ?";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, ohipVer);
		ps.setString(2, name);
		ps.setString(3, mid);
		ps.setString(4, lName);
		ps.setString(5, name2);
		
		ps.executeUpdate();
		
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean addPatient (Connection conn, Patients patient) {
		
		boolean success = false;
		
		try {
			
			String sql = "INSERT INTO Patients (OHIPNumber, OHIPVersion, FirstName, MiddleInitials, "+
			"LastName, Login, Gender, DateOfBirth) VALUES (?,?,?,?,?,?,?,?);";
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, patient.getOHIPNumber());
			ps.setString(2, patient.getOHIPVersion());
			ps.setString(3, patient.getFirstName());
			ps.setString(4, patient.getMiddleInitials());
			ps.setString(5, patient.getLastName());
			ps.setString(6, patient.getUserName());
			ps.setString(7, patient.getGender());
			ps.setString(8, patient.getDateofBirth());
			
			int count = ps.executeUpdate();
			if(count > 0) {
				success = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NOT WORKING");
		}
		try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
		
	}
	 
		public void close(PreparedStatement ps, ResultSet rs) {
			try {
			ps.close();
			rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	

}
