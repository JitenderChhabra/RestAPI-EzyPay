package com.ezypay.utills;

public enum EndPointURL {

	
	LOGIN("/login"),
	
	// *** Sample of other End Points for future purpose.
	UPDATE_LOGIN(""),
	DELETE_LOGIN(""),
	GET_LOGINS(""),
	GET_LOGIN_BY_LOGINNAME(""),
	UPDATE_LOGIN_BY_LOGINNAME("");
	
	String resourcePath;
		
	// *** Constructor to Initialize enum constants.
	EndPointURL(String resourcePath){
		this.resourcePath = resourcePath;
	}
	
	// *** Will return resource of the particular URL.
	public String getResourcePath(){
		return this.resourcePath;
	}
	
	public String getResourcePath(String data){
		return this.resourcePath+data;
	}
	
	
}
