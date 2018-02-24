package com.webback.controller.model;

public class HomeControllerModel {

	private String message;
	
	public HomeControllerModel(String message) {
		this.message = message;
	}
	
	public HomeControllerModel() {
		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
