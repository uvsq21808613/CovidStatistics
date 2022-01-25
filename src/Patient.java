
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class Patient {

	public String firstName;
	public String lastName;
	public String phoneNumber = "";
	public int ID;
	public String address;
	public String mail;
	public String vaccine;
	public int numberOfDoses;
	public String nextAppointment;
	public String lastDose;
	
	
	public Patient() {}
	public Patient(String firstName, String lastName, String phoneNumber, int iD, String address, String mail,
			String vaccine, int numberOfDoses, String nextAppointment, String lastDose) {
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
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
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public int getNumberOfDoses() {
		return numberOfDoses;
	}
	public void setNumberOfDoses(int numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}
	public String getNextAppointment() {
		return nextAppointment;
	}
	public void setNextAppointment(String nextAppointment) {
		this.nextAppointment = nextAppointment;
	}
	public String getLastDose() {
		return lastDose;
	}
	public void setLastDose(String lastDose) {
		this.lastDose = lastDose;
	}
	public static List<Patient> getAllPatients() throws SQLException, ParseException{
		String query = "select * from PATIENT;";
		List<Patient> list = new ArrayList<Patient>();
		ResultSet result = SqlHandler.executeQuery(query);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		
		while(result.next()) {
			Patient p = new Patient();
			
			p.firstName = result.getString("first_name");
			p.lastName = result.getString("last_name");
			p.address = result.getString("address");
			p.mail = result.getString("email");
			p.ID = result.getInt("id");
			
			p.vaccine = result.getString("vaccin_type");
			
			p.numberOfDoses = result.getInt("vaccin_cov");
			p.nextAppointment = /*formatter.parse*/(result.getString("next_vaccin_date"));
			p.lastDose = /*formatter.parse*/(result.getString("last_vaccin_date"));
			list.add(p);
			
		}
		return list;
	}
	
	public static Patient getPatientByID(int ID) throws SQLException, ParseException {
		String query = "select * from PATIENT WHERE id ="+ID+";";
		ResultSet result = SqlHandler.executeQuery(query);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		while(result.next()) {
			Patient p = new Patient();
			
			p.firstName = result.getString("first_name");
			p.lastName = result.getString("last_name");
			p.address = result.getString("address");
			p.mail = result.getString("email");
			p.ID = result.getInt("id");
			
			p.vaccine = result.getString("vaccin_type");
			
			p.numberOfDoses = result.getInt("vaccin_cov");
			p.nextAppointment = /*formatter.parse*/result.getString("next_vaccin_date");
			p.lastDose = /*formatter.parse*/result.getString("last_vaccin_date");
			System.out.println(p.firstName);
			return p;
			
		}
		return null;
		
	}
	
	public static void addPatientToDb(Patient patient) throws SQLException {
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String next_date = dateFormat.format(patient.nextAppointment);
//		String last_date = dateFormat.format(patient.lastDose);
		
		String sql = "INSERT INTO PATIENT (first_name, last_name, address, email, vaccin_type,"
				+ " vaccin_cov, phone, next_vaccin_date, last_vaccin_date)"
				+ " values("
				+ "'"+patient.firstName+"', '"+patient.lastName+"', '"+patient.address+"', '"+patient.mail+"', '"+patient.vaccine+"'  ,"
				+ "'"+patient.numberOfDoses+"', '"+patient.phoneNumber+"', '"+patient.nextAppointment+"' , '"+patient.lastDose+"'  "
				+ ")";
		
		SqlHandler.executeQueryWithNoReturn(sql);
		
	}
	
//	public static void main(String args[]) throws SQLException, ParseException {
//		
//		Patient p = new Patient();
//		
//		p.firstName = "Cami";
//		p.lastName = "Dono";
//		p.address = "Mulhouse";
//		p.mail = "cami@gmail.com";
//		p.vaccine = "Pfizer";
//		p.numberOfDoses = 2;
//		p.nextAppointment = new Date();
//		p.lastDose = new Date();
//		
//		SqlHandler.setTup();
//		Patient.addPatientToDb(p);
//		System.out.println(Patient.getAllPatients());
//		
//		
//	}


}
