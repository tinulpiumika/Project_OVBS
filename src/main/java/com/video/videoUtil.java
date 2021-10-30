package com.video;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class videoUtil implements videoInterface {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;


	//get latest 6 videos in videoResult JSP
	
	
	public List<Video> getAllVideo() {

		ArrayList<Video> videoList = new ArrayList<>();

		int id;
		String code;
		String name;
		String description;
		String date;
		String url;
		String thumbnail;
		Video videoDet;
		int c=0;


		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from video ORDER BY date DESC";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				id = rs.getInt(1);
				code = rs.getString(2);
				name = rs.getString(3);
				description = rs.getString(4);
				date = rs.getString(5);
				url = rs.getString(6);
				thumbnail = rs.getString(7);
				

				videoDet = new Video(id, code, name, description, date, url, thumbnail);
				videoList.add(videoDet);
				c++;
				
				
				if(c>5) {
					break;
				} //display only 6 latest video only
			}
			
			con.close();  //closing the connection

		} catch (Exception e) {

			System.out.println("Error in display all video utilization: " + e);

		}

		return videoList;	
	}



	//search keyword using filter
	
	public List<Video> searchVideo(String keyword, int filter){
		
		ArrayList <Video> resultVideo = new ArrayList<>();
		
		
		int id;
		String code;
		String name;
		String description;
		String date;
		String url;
		String thumbnail;
		Video videoDet;
		
		
		if(filter == 1) {
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM ovbs.video where videoName LIKE '%"+keyword+"%'";
				rs = stmt.executeQuery(sql);
				
				

				
				while(rs.next()) {

					id = rs.getInt(1);
					code = rs.getString(2);
					name = rs.getString(3);
					description = rs.getString(4);
					date = rs.getString(5);
					url = rs.getString(6);
					thumbnail = rs.getString(7);


					videoDet = new Video(id, code, name, description, date, url, thumbnail);
					resultVideo.add(videoDet);
				}
	
				
				con.close();  //closing the connection
				
				
			}catch(Exception e) {
				System.out.println("Error in display search video (filter1) utilization: " + e);
			}
			
			
		}
		
		else if(filter == 2) {
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM ovbs.video where date = '"+keyword+"'";
				rs = stmt.executeQuery(sql);
				
				
				
				
				while(rs.next()) {

					id = rs.getInt(1);
					code = rs.getString(2);
					name = rs.getString(3);
					description = rs.getString(4);
					date = rs.getString(5);
					url = rs.getString(6);
					thumbnail = rs.getString(7);

					videoDet = new Video(id, code, name, description, date, url, thumbnail);
					resultVideo.add(videoDet);
				}
	
				
			
				con.close();  //closing the connection	
				
			}catch(Exception e) {
				System.out.println("Error in display search video (filter2) utilization: " + e);
			}
			
		}
		
		else {
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM ovbs.video where videoName LIKE '%"+keyword+"%' OR videocode  LIKE '%"+keyword+"%' OR description LIKE '%"+keyword+"%'";
				rs = stmt.executeQuery(sql);
				
				
				
				
				
				while(rs.next()) {

					id = rs.getInt(1);
					code = rs.getString(2);
					name = rs.getString(3);
					description = rs.getString(4);
					date = rs.getString(5);
					url = rs.getString(6);
					thumbnail = rs.getString(7);

					videoDet = new Video(id, code, name, description, date, url, thumbnail);
					resultVideo.add(videoDet);
				}
	
				
				con.close();  //closing the connection
				
			}catch(Exception e) {
				System.out.println("Error in display search video (else) utilization: " + e);
			}
			
			
		}
		
		return resultVideo;
	}


	
//get single video data to JSP	
	

	public List<VideoFeedback> getVideo(int id) {
		
		
		ArrayList <VideoFeedback> vDetails = new ArrayList<>();
		
		
		//1st Query attributes
		int id1 = 0;
		String code = null;
		String name = null;
		String description = null;
		String date = null;
		String url = null;
		int count = 0;
		
		
		//2nd query attributes
		int idfeedback;
		String feedbackmessage;
		int vid;
		String username;
		Date datetime;
		Feedback feedback;
		ArrayList <Feedback> fList = new ArrayList<>();
		//fList = null;
		


		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql1 = "SELECT id, videocode, videoName, description, date, path FROM ovbs.video WHERE id ='"+id+"'";
			String sql2 = "SELECT * FROM ovbs.feedback WHERE videoID = '"+id+"' ORDER BY date_time DESC";
			


			//executing first query
			rs = stmt.executeQuery(sql1);

			if(rs.next()) {

				id1 = rs.getInt(1);
				code = rs.getString(2);
				name = rs.getString(3);
				description = rs.getString(4);
				date = rs.getString(5);
				url = rs.getString(6);
			}
			
			
			
			//executing second query
			rs = stmt.executeQuery(sql2);
			
			
			while(rs.next()) {
				idfeedback = rs.getInt(1);
				feedbackmessage = rs.getString(2);
				vid = rs.getInt(3);
				username = rs.getString(4);
				datetime = rs.getDate(5);
				
				feedback = new Feedback(idfeedback, feedbackmessage, vid, username, datetime);
				fList.add(feedback);
				++count;
				

			}
			
			VideoFeedback videoDet = new VideoFeedback(id1, code, name, description, date, url , fList, count);
			vDetails.add(videoDet);

			con.close();  //closing the connection

		}catch(Exception e) {
			System.out.println("Error in display get Video Feedback details utilization: " + e);
		}



		return vDetails;
	}






}