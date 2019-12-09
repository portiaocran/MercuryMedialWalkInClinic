 package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Appointments;

public class AppointmentDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean addAppointment (Connection conn, Appointments appointment) {
		
		boolean success = false;
		
		try {
			
			String sql = "INSERT into appointments (Patient, ReasonForVisit, DateTime, IsPatientChecvisitkedIn)" 
					+ "VALUES (?, ?, ?, ?);";
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, appointment.getHealthCardNum());
			ps.setString(2, appointment.getReasonForVisit());
			ps.setString(3, appointment.getDateTime());
			ps.setString(4, appointment.getCheckedIn());
			
			ps.executeUpdate();
			
			success=true;
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
	
	public ArrayList<Appointments> getApptList(Connection conn, Long healthCard){
		
		ArrayList<Appointments> appointList = new ArrayList<Appointments>();
		
		try {
			String sql = " SELECT ApptNumber, ReasonForVisit, DateTime " +
					"FROM appointments a " +
					"WHERE a.Patient = ? ;";
			
			ps = conn.prepareStatement(sql);
			
			ps.setLong(1, healthCard);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Appointments a1 = new Appointments();
				
				a1.setAppointmentNumber(rs.getInt("ApptNumber"));
				a1.setReasonForVisit(rs.getString("ReasonForVisit"));
				a1.setDateTime(rs.getString("DateTime"));
				
				appointList.add(a1);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return appointList;	
		
	}
	
	public boolean cancelAppt(Connection conn, int apptNumber) {
		
		boolean success= false;
		try {
			
			String sql ="DELETE FROM appointments WHERE ApptNumber = ? ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, apptNumber);
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
	
	public Appointments registerAppt(Connection conn, String date, Long healthcardNum) {

		Appointments a1 = null;
		
		try {
		
			String sql = "SELECT ApptNumber, ReasonForVisit, DateTime " + 
					"FROM appointments " + 
					"WHERE DATE(DateTime) = ? AND Patient = ? AND " +
					"(IsPatientChecvisitkedIn = 'N' OR IsPatientChecvisitkedIn = null)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, date);
			ps.setLong(2, healthcardNum);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				a1 = new Appointments();
				a1.setAppointmentNumber(rs.getInt("ApptNumber"));
				a1.setReasonForVisit(rs.getString("ReasonForVisit"));
				a1.setDateTime(rs.getString("DateTime"));
			}

			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return a1;
	}
	
	public boolean checkIn(Connection conn, Appointments a1) {
		
		boolean success= false;
		
		try {
			String sql = "UPDATE appointments " +
					"SET IsPatientChecvisitkedIn = 'Y'" +
					"WHERE ApptNumber = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a1.getAppointmentNumber());
			ps.executeUpdate();
			success = true;
					
		} catch (SQLException e) {
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
