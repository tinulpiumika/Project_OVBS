package com.feedback;

import java.sql.Connection;
import java.sql.Statement;


public class FeedbackUtil implements feedbackInterface {
	
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static int rs = 0;

	
	public boolean insertFeedback(String feedback, int vid, String uN) {
		
		boolean outcome = false;
		
		
		
		
		try {
			//Db connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
						
			
			String sql = "INSERT INTO ovbs.feedback VALUES(0, '"+feedback+"', "+vid+", '"+uN+"', NOW())";
			rs = stmt.executeUpdate(sql);
			
			
			if (rs > 0) {
				outcome = true;
			}
			else {
				outcome = false;
			}
		
			con.close();  //closing the connection
			
		} catch (Exception e) {
			
			System.out.println("Error in feedback utilization: " + e);
			
		}
		
		
		
		return outcome;
	}


	public boolean updateFeedback(int id, String feedbackUpdate) {
		
		boolean outcome = false;
		
		try {
			//DB connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
						
			
			String sql = "UPDATE ovbs.feedback SET feedbackMessage = '"+feedbackUpdate+"', date_time = NOW()  WHERE idfeedback = "+id+"";
			rs = stmt.executeUpdate(sql);
			
			
			if (rs > 0) {
				outcome = true;
			}
			else {
				outcome = false;
			}
		
			con.close();  //closing the connection
			
		} catch (Exception e) {
			
			System.out.println("Error in feedback utilization: " + e);
			
		}
		
		
		
		return outcome;
	} 


	
	
	
	
	public boolean deleteFeedback(int feedbackID) {
		boolean outcome = false;
	
		try {
			//DB connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
						
			
			String sql = "DELETE FROM ovbs.feedback WHERE idfeedback = "+feedbackID+"";
			rs = stmt.executeUpdate(sql);
			
			
			if (rs > 0) {
				outcome = true;
			}
			else {
				outcome = false;
			}
		
			
		} catch (Exception e) {
			
			System.out.println("Error in feedback utilization: " + e);
			
		}
		
		
		
		return outcome;
	}
	
	
	
}
