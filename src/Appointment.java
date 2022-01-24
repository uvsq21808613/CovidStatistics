
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Appointment {
	
	private int staffID;
	private int patientID;
	private Date date;
	private int duration;
	private String reason;
	
	
	
	public Appointment(int staffID, int patientID, Date date, int duration, String reason) {
		super();
		this.staffID = staffID;
		this.patientID = patientID;
		this.date = date;
		this.duration = duration;
		this.reason = reason;
	}
	
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
public static void addAppointmentToDb(Appointment app) throws SQLException {
		

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(app.date);
		String sql = "INSERT INTO APPOINTMENT (patient_id, staff_id, date, raison, duration)"
				+ " values('"+app.patientID+"', '"+app.staffID+"', '"+date+"', '"+app.duration+"', "+app.duration+" )";
		
		SqlHandler.executeQueryWithNoReturn(sql);
		
	}

public static List<Appointment> getAllAppointments() throws SQLException, ParseException{
	String query = "select * from APPOINTMENT;";
	List<Appointment> list = new ArrayList<Appointment>();
	ResultSet result = SqlHandler.executeQuery(query);

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	while(result.next()) {
		Appointment app = new Appointment(result.getInt("staff_id"),
				result.getInt("patient_id"),
				formatter.parse(result.getString("date")),
				result.getInt("duration"),
				result.getString("raison")
				);
		
		list.add(app);
		
	}
	return list;
}

	
	
public static void main(String args []) throws SQLException, ParseException {
	
	SqlHandler.setTup();
	Staff st = new Staff("Carlos", "Maria", "+336565657", "carloa@gmail.com");
	Staff.addStaffToDb(st);
	
	Staff random_staff = Staff.getAllStaffs().get(0);
	
	Patient p = new Patient();
	
	p.firstName = "Cami";
	p.lastName = "Dono";
	p.address = "Mulhouse";
	p.mail = "cami@gmail.com";
	p.vaccine = VaccineType.PFIZER;
	p.numberOfDoses = 2;
	p.nextAppointment = new Date();
	p.lastDose = new Date();
	
	SqlHandler.setTup();
	Patient.addPatientToDb(p);
	
	Patient random_patient = Patient.getAllPatients().get(0);
	
	Appointment app = new Appointment(random_staff.ID, random_patient.ID,  new Date(), 60, "Second Vaccin");
	Appointment.addAppointmentToDb(app);
	System.out.println(Appointment.getAllAppointments());
}

}
