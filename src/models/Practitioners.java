package models;

public class Practitioners extends Person {

	private static final long serialVersionUID = 1L;
	
	private String PracticeName;
	private int CPSO;
	private int address;
	
	

	public Practitioners(String firstName, String middleInitials, String lastName, String userName, String pracName, int CPSO, int address) {
		super(firstName, middleInitials, lastName, userName);
		this.PracticeName = pracName;
		this.CPSO = CPSO;
		this.address = address;
		// TODO Auto-generated constructor stub
	}

	public String getPracticeName() {
		return PracticeName;
	}

	public void setPracticeName(String practiceName) {
		PracticeName = practiceName;
	}

	public int getCPSO() {
		return CPSO;
	}

	public void setCPSO(int cPSO) {
		CPSO = cPSO;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	
}
