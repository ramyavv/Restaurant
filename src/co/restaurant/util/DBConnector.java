package co.restaurant.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.restaurant.exception.RestaurantException;

public class DBConnector {
	private final static String USERNAME = "root";
	private final static String PASSWORD = ""; // Error? No remember if password
	private final static String DBURL = "jdbc:mysql://localhost:3306/restaurant_db";

	public static Connection getDBConnection() throws RestaurantException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection Error" + e.getMessage());
			e.printStackTrace();
			throw new RestaurantException("Error" + e.getMessage(),
					e.getCause());
		}

		return conn;
	}

	public static void closeResources(PreparedStatement ps, ResultSet rs,
			Connection conn) {

		try {
			if (ps != null) {

				ps.close();
			}
			if (rs != null) {

				rs.close();
			}
			if (conn != null) {

				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			Connection con = DBConnector.getDBConnection();
		} catch (RestaurantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
