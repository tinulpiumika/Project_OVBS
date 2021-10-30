package com.video;

public class Video {
	
	private int id;
	private String code;
	private String name;
	private String description;
	private String date;
	private String url;
	private String thumbnail;
	
	
	
	public Video(int id, String code, String name, String description, String date, String url, String thumbnail) {

		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.date = date;
		this.url = url;
		this.thumbnail = thumbnail;
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



	public String getThumbnail() {
		return thumbnail;
	}

	

}
