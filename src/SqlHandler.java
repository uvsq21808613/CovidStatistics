import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlHandler {
	
	public static String hospital_name = "demo";
	
	public static String sql_username = "root";
	public static String sql_password = "";
	public static String sql_jdbc = "jdbc:mysql://localhost:3306/";
	
	public static Connection conn = null;
	
	public static String getDbName() {
		String db_name = "safeguard"+hospital_name;
		return db_name;
	}
	
	public static Connection getConnexion() throws SQLException {
		
		
		if ( conn == null ) {
			conn = DriverManager.getConnection(sql_jdbc, sql_username, sql_password);
			return conn;
		}else {
			return conn;
		}
	}
	
	
	public static void setTup() throws SQLException {
		if (!isExisteDb()) {
			
			createDb();
			String sql_with_db = sql_jdbc + getDbName();
			conn = DriverManager.getConnection(sql_with_db, sql_username, sql_password);
			
			createStockTable(conn);
			createPersonnelTable(conn);
			createPatientTable(conn);
			createAppointmentTable(conn);
		}
		
	}
	public static boolean isExisteDb() throws SQLException {
		
		String query = "SHOW DATABASES LIKE '"+getDbName()+"';";
		ResultSet rs = getConnexion().createStatement().executeQuery(query); 
		if (!rs.next()) { 
			return false;
		}
		else {
			return true;
		}

		
	}
	
	public static void createDb() throws SQLException {
		
		String sql_query = "CREATE DATABASE "+getDbName()+";";
		Statement stmt = getConnexion().createStatement();
		stmt.executeUpdate(sql_query);
	}
	
	public static ResultSet executeQuery(String query) throws SQLException {
		String sql_with_db = sql_jdbc + getDbName();
		conn = DriverManager.getConnection(sql_with_db, sql_username, sql_password);
		ResultSet rs = conn.createStatement().executeQuery(query);
		return rs;
	}
	public static void executeQueryWithNoReturn(String query) throws SQLException {
		String sql_with_db = sql_jdbc + getDbName();
		conn = DriverManager.getConnection(sql_with_db, sql_username, sql_password);
		conn.createStatement().executeUpdate(query);
		
	} 
	public static void addStockQuery(String name, int quanity) throws SQLException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
		String date_str = dateFormat.format(date);
		int current = getStockQuery(name, date_str);
		int new_quanity = current + quanity;
		String sql = "UPDATE STOCK SET quantity = "+new_quanity+ " WHERE name = '"+name+"' and date = '"+date_str+"' ;";
		conn.createStatement().executeUpdate(sql);
		
		
	}
	public static void replaceStockQuery(String name, int quanity) throws SQLException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
		String date_str = dateFormat.format(date);
		//int current = getStockQuery(name, date_str);
//		int new_quanity = quanity;
		String sql = "UPDATE STOCK SET quantity = "+quanity+ " WHERE name = '"+name+"' and date = '"+date_str+"' ;";
		conn.createStatement().executeUpdate(sql);
		
		
	}
	public static int getStockQuery(String name , String date) throws SQLException {
		
		String sql_with_db = sql_jdbc + getDbName();
		conn = DriverManager.getConnection(sql_with_db, sql_username, sql_password);
		
		String sql = "select quantity from STOCK WHERE name = '"+name+"' and date = '"+date+"' ;";
		ResultSet rs = conn.createStatement().executeQuery(sql);
		if (rs.next()) {
			return rs.getInt("quantity");
		}
		else {
			
			sql = "INSERT INTO STOCK (name, quantity) values('"+name+"', 0)";
			conn.createStatement().executeUpdate(sql);
			return 0;
		}
	}
	public static void createStockTable(Connection conn) throws SQLException {
		
		String sql = "CREATE TABLE STOCK " +
              "(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
              " name VARCHAR(255), " + 
              " quantity VARCHAR(255), " +  
              " date DATE DEFAULT (current_date) " +  " ) ;";
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		sql = "INSERT INTO STOCK (name, quantity) values('MASK', 0)";
		conn.createStatement().executeUpdate(sql);
		sql = "INSERT INTO STOCK (name, quantity) values('GEL', 0)";
		conn.createStatement().executeUpdate(sql);
		sql = "INSERT INTO STOCK (name, quantity) values('VACCIN-PFIZER', 0)";
		conn.createStatement().executeUpdate(sql);
		sql = "INSERT INTO STOCK (name, quantity) values('VACCIN-MODERNA', 0)";
		conn.createStatement().executeUpdate(sql);
		sql = "INSERT INTO STOCK (name, quantity) values('TEST-PCR', 0)";
		conn.createStatement().executeUpdate(sql);
		sql = "INSERT INTO STOCK (name, quantity) values('TEST-ANTI', 0)";
		conn.createStatement().executeUpdate(sql);
	}
	
	public static void createPersonnelTable(Connection conn) throws SQLException {
		
		String sql = "CREATE TABLE STAFF " +
	              "(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
	              " first_name VARCHAR(255), " + 
	              " last_name VARCHAR(255), " + 
	              " username VARCHAR(255), " + 
	              " phone VARCHAR(255), " + 
	              " email VARCHAR(255) DEFAULT NULL " +  " ) ;";
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
	}
	
	public static void createPatientTable(Connection conn) throws SQLException {
		
		String sql = "CREATE TABLE PATIENT " +
	              "(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
	              " first_name VARCHAR(255), " + 
	              " last_name VARCHAR(255), " +
	              " address VARCHAR(255), " +
	              " vaccin_type VARCHAR(255), " + 
	              " vaccin_cov VARCHAR(255), " + 
	              " phone VARCHAR(255), " + 
	              " next_vaccin_date VARCHAR(255), " + 
	              " last_vaccin_date VARCHAR(255), " + 
	              " email VARCHAR(255) NOT NULL DEFAULT '' " +  " ) ;";
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
	}
	
	public static void createAppointmentTable(Connection conn) throws SQLException {
		
		String sql = "CREATE TABLE APPOINTMENT " +
	              "(id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
	              " patient_id INTEGER, " + 
	              " staff_id INTEGER, " + 
	              " date VARCHAR(255), " + 
	              " FOREIGN KEY (staff_id) REFERENCES STAFF(id), " + 
	              " FOREIGN KEY (patient_id) REFERENCES PATIENT(id) " +  " ) ;";
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
	}
	
	
	public static void main(String args[]) throws SQLException {
		System.out.println("SQDQS");
		SqlHandler.setTup();
	}
}
