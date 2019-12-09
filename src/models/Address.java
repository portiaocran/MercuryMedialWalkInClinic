//Java bean created to hold address of doctor's office 
package models;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private int addressId;
	private String streetline1;
	private String streetline2;
	private String aptOrUnitNumber;
	private String city;
	private String province;
	private String postalCode;
	private String type;
	private String occupant;
	
	public Address(String streetline1, String streetline2, String aptOrUnitNumber, String city,
			String province, String postalCode, String type, String occupant) {
		this.streetline1 = streetline1;
		this.streetline2 = streetline2;
		this.aptOrUnitNumber = aptOrUnitNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.type = type;
		this.occupant = occupant;
	}
	
	
	public Address(int addressId, String streetline1, String streetline2, String aptOrUnitNumber, String city,
			String province, String postalCode, String type, String occupant) {
		this.addressId = addressId;
		this.streetline1 = streetline1;
		this.streetline2 = streetline2;
		this.aptOrUnitNumber = aptOrUnitNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.type = type;
		this.occupant = occupant;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetline1() {
		return streetline1;
	}
	public void setStreetline1(String streetline1) {
		this.streetline1 = streetline1;
	}
	public String getStreetline2() {
		return streetline2;
	}
	public void setStreetline2(String streetline2) {
		this.streetline2 = streetline2;
	}
	public String getAptOrUnitNumber() {
		return aptOrUnitNumber;
	}
	public void setAptOrUnitNumber(String aptOrUnitNumber) {
		this.aptOrUnitNumber = aptOrUnitNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOccupant() {
		return occupant;
	}
	public void setOccupant(String occupant) {
		this.occupant = occupant;
	}
	
	
}
