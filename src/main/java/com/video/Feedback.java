package com.video;

import java.sql.Date;

public class Feedback {
	
	private int idfeedback;
	private String feedbackmessage;
	private int vid;
	private String fusername;
	private Date datetime;
	
	

	public Feedback(int idfeedback, String feedbackmessage, int vid, String username, Date datetime) {
		this.idfeedback = idfeedback;
		this.feedbackmessage = feedbackmessage;
		this.vid = vid;
		this.fusername = username;
		this.datetime = datetime;
	}



	public int getIdfeedback() {
		return idfeedback;
	}



	public String getFeedbackmessage() {
		return feedbackmessage;
	}



	public String getFusername() {
		return fusername;
	}



	public Date getDatetime() {
		return datetime;
	}



	public int getVid() {
		return vid;
	}



}
