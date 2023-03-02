package com.springrestful.springrest.model;

import java.sql.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Faculty{
	@Id
	private int id;
	private String facultyName;
	private double salary;
	private Date joinedDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_course_id")
	private Course course;

	public Faculty(int id, String facultyName, double salary, Date joinedDate, Course course) {
		super();
		this.id = id;
		this.facultyName = facultyName;
		this.salary = salary;
		this.joinedDate = joinedDate;
		this.course = course;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
