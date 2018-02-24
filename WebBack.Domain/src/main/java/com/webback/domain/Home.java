package com.webback.domain;

public class Home {

	private String message;
	
	public Home(String message) {
		this.message = message;
	}
	
	public Home() {
		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
