package com.springrestful.springrest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@Column(name="username")
	private String id;
	private String password;
	
	
	public Admin(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
		
}
