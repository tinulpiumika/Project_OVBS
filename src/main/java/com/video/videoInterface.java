package com.video;

import java.util.List;

public interface videoInterface {
	
	public List<Video> getAllVideo();					 //use to retrieve for most recent 6 video
	public List<Video> searchVideo(String keyword, int filter);		//use to search the videos details in DB
	public List<VideoFeedback> getVideo(int id);					//use to get the video details to VideoPlayer

}
