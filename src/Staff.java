
public class Staff {
	
	private String firstName;
	private String lastName;
	private int ID;
	private int phoneNumber;
	private String mail;
	
	public Staff(String firstName, String lastName, int iD, int phoneNumber, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		ID = iD;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
