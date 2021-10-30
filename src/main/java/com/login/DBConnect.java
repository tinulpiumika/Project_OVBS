package com.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	//create database connection
	
	private static String url = "jdbc:mysql://localhost:3306/ovbs";
	private static String user = "root";
	private static String pass = "qwer123";
	private static Connection con;

	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");   //run interface
			
			con = DriverManager.getConnection(url, user, pass);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is not success!!!");
		}
		
		return con;
	}
	
}
