package models;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String FirstName;
	private String MiddleInitials;
	private String LastName;
	private String userName;
	
	
	public Person() {
		
	}
	
	public Person(String firstName, String middleInitials, String lastName, String userName) {
		
		this.FirstName = firstName;
		this.MiddleInitials = middleInitials;
		this.LastName = lastName;
		this.userName = userName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getMiddleInitials() {
		return MiddleInitials;
	}
	public void setMiddleInitials(String middleInitials) {
		MiddleInitials = middleInitials;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	
	
	
}
