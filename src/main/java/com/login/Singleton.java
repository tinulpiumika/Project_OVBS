package com.login;

public class Singleton    //for get one session for single login
{
    // static variable single_instance of type Singleton 
    private static Singleton single_instance = null;
  
    // variable of type String
    private static String username;
  
    
    // private constructor restricted to this class itself
    private Singleton() {  }
     
    // static method to create instance of Singleton class
    public static Singleton getInstance(String username)
    {
        if (single_instance == null) { 
        	
            single_instance = new Singleton();
            
            Singleton.username = username;
        }
        return single_instance;
    }
    
    
    public static void removeInstances() {
    	Singleton.single_instance = null;
    }
    
    
	public String getUsername() {
		return username;
	}
    
}











/*package com.login;

public class UN {
	
	private String username;
	
	public UN(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}

}
*/