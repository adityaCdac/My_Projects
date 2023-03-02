package com.springrestful.springrest.model;

public class StudentLogin {
	
	private String emailId;
	private String password;
	
	
	public StudentLogin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}


	public StudentLogin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	

}
