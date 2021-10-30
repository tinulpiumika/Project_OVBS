package com.login;

public class User {
	
	private int id;
	private String uname;
	private String ppurl;
	
	
	
	public User(int id, String uname, String pword, String ppurl) {
		this.id = id;
		this.uname = uname;
		this.ppurl = ppurl;
	}



	public int getId() {
		return id;
	}


	public String getUname() {
		return uname;
	}

	public String getPpurl() {
		return ppurl;
	}


}
