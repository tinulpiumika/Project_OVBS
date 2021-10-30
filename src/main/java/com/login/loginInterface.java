package com.login;

import java.util.List;

public interface loginInterface {
	
	public boolean validate(String username, String password);  //validate the login available
	public List<User> getUser(String username);					//retrieve the user details
}
