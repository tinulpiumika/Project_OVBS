package com.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDbUtil implements loginInterface{
	
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	public boolean validate(String username, String password) {   //validate User-name and password
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from logindb where username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public List<User> getUser(String username) {
		
		ArrayList<User> userList = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from logindb where username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String userU = rs.getString(2);
				String passW = rs.getString(3);
				String pp = rs.getString(4);
				
				User userDet = new User(id,userU,passW, pp);
				userList.add(userDet);
				
				con.close();  //closing the connection
			}
			
		} catch (Exception e) {
			
		}
		
		return userList;	
	}
	
	
	
	

}
