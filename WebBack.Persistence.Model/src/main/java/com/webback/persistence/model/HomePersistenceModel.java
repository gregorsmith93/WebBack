package com.webback.persistence.model;

public class HomePersistenceModel {

	private String message;
	
	public HomePersistenceModel(String message) {
		this.message = message;
	}
	
	public HomePersistenceModel() {
		
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
