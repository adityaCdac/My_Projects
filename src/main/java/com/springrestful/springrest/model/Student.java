 package com.springrestful.springrest.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private long mobileNo;
	private String collegeName;
	private String city;
	private String state;
	private int pincode;
	private String password;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,targetEntity = StudentCourse.class,mappedBy = "student")
//	@JoinColumn(name="student")
	private List<StudentCourse> studentCourses;


	public Student(int id, String name, String email, long mobileNo, String collegeName, String city, String state,
			int pincode, String password, List<StudentCourse> studentCourses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.collegeName = collegeName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.password = password;
		this.studentCourses = studentCourses;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getCollegeName() {
		return collegeName;
	}


	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}


	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	
	
}
