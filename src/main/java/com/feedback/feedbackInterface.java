package com.feedback;

public interface feedbackInterface {
	
	public boolean insertFeedback(String feedback, int vid, String uN);    //create function for feedback
	public boolean updateFeedback(int id, String feedbackUpdate);		  //update function for feedback
	public boolean deleteFeedback(int feedbackID);						//delete function for feedback
}
