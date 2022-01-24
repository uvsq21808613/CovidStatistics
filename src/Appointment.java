
import java.util.Date;
import java.time.Duration;

public class Appointment {
	
	private int staffID;
	private int patientID;
	private Date date;
	private Duration duration;
	private String reason;
	
	
	
	public Appointment(int staffID, int patientID, Date date, Duration duration, String reason) {
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
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
