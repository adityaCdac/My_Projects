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
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String courseName;
	private String courseDiscription;
	private int duration;
	private double fees;
	private Date startDate;
	private Date endDate;
	private double rating;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Student.class, mappedBy = "course")
	private List<Student> students;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Faculty.class, mappedBy = "course")
	private List<Faculty> faculties;

	public Course(int id, String courseName, String courseDiscription, int duration, double fees,
			Date startDate, Date endDate, int rating, List<Student> students, List<Faculty> faculties) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDiscription = courseDiscription;
		this.duration = duration;
		this.fees = fees;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rating = rating;
		this.students = students;
		this.faculties = faculties;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDiscription() {
		return courseDiscription;
	}

	public void setCourseDiscription(String courseDiscription) {
		this.courseDiscription = courseDiscription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	
	
		
}
