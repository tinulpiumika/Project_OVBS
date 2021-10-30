package com.video;


import java.util.ArrayList;

public class VideoFeedback {
	
	private int id;
	private String code;
	private String name;
	private String description;
	private String date;
	private String url;
	private ArrayList <Feedback> feedback;
	private int count;
	


	public VideoFeedback(int id, String code, String name, String description, String date, String url,
			ArrayList<Feedback> feedback, int count) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.date = date;
		this.url = url;
		this.feedback = feedback;
		this.count = count;
	}




	public int getId() {
		return id;
	}




	public String getCode() {
		return code;
	}




	public String getName() {
		return name;
	}




	public String getDescription() {
		return description;
	}




	public String getDate() {
		return date;
	}




	public String getUrl() {
		return url;
	}


	public ArrayList <Feedback> getFeedback() {
		return feedback;
	}




	public int getCount() {
		return count;
	}









}
