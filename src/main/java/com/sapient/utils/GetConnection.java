package com.sapient.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GetConnection {
	public static Connection getMySQLConn() {
		
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String name = rb.getString("name");
		String password = rb.getString("password");
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, name, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public Connection getOracleConn() {}
//	public Connection getDB2() {}
}
