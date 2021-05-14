package com.sapient.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	public static Connection getMySQLConn() {
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url ="jdbc:mysql://localhost/Group_System"; 
		String name ="root";
		String password ="1813";

		try {
			Class.forName(driver); 
			return  DriverManager.getConnection(url, name, password); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return null;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getMySQLConn());
	}
	
	
	
//	public Connection getOracleConn() {}
//	public Connection getDB2() {}
}
