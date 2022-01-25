import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Staff {
	
	private String firstName;
	private String lastName;
	public int ID;
	private String phoneNumber;
	private String mail;
	
	public Staff(String firstName, String lastName, String phoneNumber, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public static void addStaffToDb(Staff staph) throws SQLException {
		String sql = "INSERT INTO STAFF (first_name, last_name, phone, email)"
				+ " values('"+staph.firstName+"', '"+staph.lastName+"', '"+staph.lastName+"', '"+staph.mail+"')";
		SqlHandler.executeQueryWithNoReturn(sql);
	}
	
	public static List<Staff> getAllStaffs() throws SQLException, ParseException{
		String query = "select * from STAFF;";
		List<Staff> list = new ArrayList<Staff>();
		ResultSet result = SqlHandler.executeQuery(query);

		
		while(result.next()) {
			Staff p = new Staff(result.getString("first_name"),
					result.getString("last_name"),
					result.getString("phone"),
					result.getString("email"));
			
			p.ID = result.getInt("id");
			list.add(p);
			
		}
		return list;
	}
	
	public static Staff getStaffByID(int ID) throws SQLException {
		
		String query = "select * from STAFF WHERE id ="+ID+";";
		ResultSet result = SqlHandler.executeQuery(query);
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		while(result.next()) {
			Staff p = new Staff(result.getString("first_name"),
					result.getString("last_name"),
					result.getString("phone"),
					result.getString("email"));
			
			p.ID = result.getInt("id");
			return p;
			
		}
		return null;
	}
//	public static void main(String args[]) throws SQLException, ParseException{
//		SqlHandler.setTup();
//		Staff st = new Staff("Carlos", "Maria", "+336565657", "carloa@gmail.com");
//		Staff.addStaffToDb(st);
//		System.out.println(Staff.getStaffByID(1).firstName);
//	}

}
