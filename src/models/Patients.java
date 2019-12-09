package models;

public class Patients extends Person {

	private static final long serialVersionUID = 1L;
	
	private Long OHIPNumber;
	private String OHIPVersion;
	private String gender;
	private String dateOfBirth;
		
	public Patients(String firstName, String middleInitials, String lastName, String userName) {
		super(firstName, middleInitials, lastName, userName);
	}
	
	public Patients() {
		super();
	}

	public Patients(String firstName, String middleInitials, String lastName, String userName, Long OHIPNumber, String OHIPVersion, String gender, String date) {
		super(firstName, middleInitials, lastName, userName);
		this.gender= gender;
		this.OHIPVersion = OHIPVersion;
		this.OHIPNumber = OHIPNumber;
		this.dateOfBirth = date;
	}
	
	public Long getOHIPNumber() {
		return OHIPNumber;
	}
	
	public void setOHIPNumber(Long oHIPNumber) {
		OHIPNumber = oHIPNumber;
	}
	
	public String getOHIPVersion() {
		return OHIPVersion;
	}
	
	public void setOHIPVersion(String oHIPVersion) {
		OHIPVersion = oHIPVersion;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofBirth() {
		return dateOfBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		dateOfBirth = dateofBirth;
	}
	
}
