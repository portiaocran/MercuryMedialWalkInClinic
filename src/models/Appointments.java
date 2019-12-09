package models;

import java.io.Serializable;

public class Appointments implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int appointmentNumber;
	private long healthCardNum;
	private String reasonForVisit;
	private String dateTime;
	private String checkedIn = "N";
	
	public Appointments() {
		
	}

	

	public Appointments(int appointmentNumber, long healthCardNum, String reasonForVisit, String dateTime,
			String checkedIn) {
		super();
		this.appointmentNumber = appointmentNumber;
		this.healthCardNum = healthCardNum;
		this.reasonForVisit = reasonForVisit;
		this.dateTime = dateTime;
		this.checkedIn = checkedIn;
	}

	public int getAppointmentNumber() {
		return appointmentNumber;
	}


	public void setAppointmentNumber(int appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}


	public long getHealthCardNum() {
		return healthCardNum;
	}
	public void setHealthCardNum(long healthCardNum) {
		this.healthCardNum = healthCardNum;
	}
	public String getReasonForVisit() {
		return reasonForVisit;
	}
	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(String checkedIn) {
		this.checkedIn = checkedIn;
	}
	
}
