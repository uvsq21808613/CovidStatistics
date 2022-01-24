import java.sql.*;  

public class Stock {


	public static int getMaskByDay(String date) throws SQLException {
		return getStockByNameAndDate("MASK", date);
	}
	
	public static int getGelByDay(String date) throws SQLException {
		return getStockByNameAndDate("GEL", date);
	}
	
	public static int getVaccinFizerByDay(String date) throws SQLException {
		return getStockByNameAndDate("VACCIN-PFIZER", date);
	}
	
	public static int getVaccinModernaByDay(String date) throws SQLException {
		return getStockByNameAndDate("VACCIN-MODERNA", date);
	}
	
	public static int getTestPcrByDay(String date) throws SQLException {
		return getStockByNameAndDate("TEST-PCR", date);
	}
	
	public static int getTestAntiByDay(String date) throws SQLException {
		return getStockByNameAndDate("TEST-ANTI", date);
	}
	
	public static int getStockByNameAndDate(String name, String date) throws SQLException {
		SqlHandler.setTup();
		return SqlHandler.getStockQuery(name, date);
	}
	
	public static void addMask(int quanity) throws SQLException {
		addStockByName("MASK", quanity);
	}
	
	public static void addGel(int quanity) throws SQLException {
		addStockByName("GEL", quanity);
	}
	
	public static void addStockByName(String name, int quanity) throws SQLException {
		SqlHandler.setTup();
		SqlHandler.addStockQuery(name, quanity);
	}
	
	public static void main(String args[]) throws SQLException {
		System.out.println(getStockByNameAndDate("MASK", "2022-01-24"));
		System.out.println(getGelByDay("2022-01-24"));
	}

}
