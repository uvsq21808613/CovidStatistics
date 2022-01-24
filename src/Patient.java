
import java.util.Date;

public class Patient {
	
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private int ID;
	private String address;
	private String mail;
	private VaccineType vaccine;
	private int numberOfDoses;
	private Date nextAppointment;
	private Date lastDose;
	
	public Patient(String firstName, String lastName, int phoneNumber, int iD, String address, String mail,
			VaccineType vaccine, int numberOfDoses, Date nextAppointment, Date lastDose) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		ID = iD;
		this.address = address;
		this.mail = mail;
		this.vaccine = vaccine;
		this.numberOfDoses = numberOfDoses;
		this.nextAppointment = nextAppointment;
		this.lastDose = lastDose;
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
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public VaccineType getVaccine() {
		return vaccine;
	}
	public void setVaccine(VaccineType vaccine) {
		this.vaccine = vaccine;
	}
	public int getNumberOfDoses() {
		return numberOfDoses;
	}
	public void setNumberOfDoses(int numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}
	public Date getNextAppointment() {
		return nextAppointment;
	}
	public void setNextAppointment(Date nextAppointment) {
		this.nextAppointment = nextAppointment;
	}
	public Date getLastDose() {
		return lastDose;
	}
	public void setLastDose(Date lastDose) {
		this.lastDose = lastDose;
	}
	
	
	

}
