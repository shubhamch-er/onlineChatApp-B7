package com.sapient.learning.chat.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class GetConnection {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	public static Connection getMySqlConnection() {
		 ResourceBundle rb = ResourceBundle.getBundle("application"); 
		 driver=rb.getString("driver");
		 url=rb.getString("url");
		 username=rb.getString("username");
		 password=rb.getString("password");
		 
		 try {
			Class.forName(driver);
			 return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO: write an exception handler
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static PreparedStatement getPreparedStatement(String sqlString) {
		try {
			return getMySqlConnection().prepareStatement(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
