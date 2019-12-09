//DAO used to store or retrieve address into a database
package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Address;

public class AddressDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean addAddress (Connection conn, Address address) {
		
		boolean success=false;
		
		try {
			
			String sql = "INSERT INTO addresses (streetLine1, streetLine2, aptOrUnitNumber,"+
			" city, province, postalCode, type, occupant) VALUES (?,?,?,?,?,?,?,?);";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, address.getStreetline1());
			ps.setString(2, address.getStreetline2());
			ps.setString(3, address.getAptOrUnitNumber());
			ps.setString(4, address.getCity());
			ps.setString(5, address.getProvince());
			ps.setString(6, address.getPostalCode());
			ps.setString(7, address.getType());
			ps.setString(8, address.getOccupant());
			
			ps.executeUpdate();
			
			success= true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 	try {
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return success;	
	}
	
	public Address getAddress(Connection con, String username) {
		
		Address address = null;

		try {
			String sql = "SELECT * FROM addresses WHERE occupant = ?";
			
			ps =con.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int addressID = rs.getInt("addressID");
				String streetAdd = rs.getString("streetLine1");
				String streetAdd2 = rs.getString("streetLine2");
				String apt = rs.getString("aptOrUnitNumber");
				String city= rs.getString("city");
				String province = rs.getString("province");
				String postalCode = rs.getString("postalCode");
				String type = rs.getString("type");
				String occupant = rs.getString("occupant");
				
				address= new Address(addressID, streetAdd, streetAdd2, apt, city, province, postalCode, type, occupant);
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Address not retrieved");
		}
		try {
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return address;
		
	}
}
