package com.springrestful.springrest.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Faculty{
	@Id
	@GeneratedValue
	private int id;
	private String facultyName;
	private double salary;
	private Date joinedDate;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Course.class,mappedBy = "faculty")
	private List<Course>courses;

	public Faculty(int id, String facultyName, double salary, Date joinedDate, List<Course> courses) {
		super();
		this.id = id;
		this.facultyName = facultyName;
		this.salary = salary;
		this.joinedDate = joinedDate;
		this.courses = courses;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
}
