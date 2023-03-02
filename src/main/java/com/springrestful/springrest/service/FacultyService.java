package com.springrestful.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestful.springrest.dao.FacultyDao;
import com.springrestful.springrest.model.Faculty;

@Service
public class FacultyService {
	@Autowired
	private FacultyDao facultyDao;
	
	public List<Faculty> getAllFaculty(){
		return facultyDao.findAll();
	}
	
	public Faculty getFaculty(int id){
		Faculty faculty=facultyDao.findById(id).get();
		return faculty;
	}
	
	public Faculty updateFaculty(Faculty faculty) {
		Faculty fclt=facultyDao.findById(faculty.getId()).get();
		return fclt;
	}
	
	public Faculty addFaculty(Faculty faculty) {
		facultyDao.save(faculty);
		return faculty;
	}
	
	public Faculty deleteFaculty(int id) {
		Faculty faculty=facultyDao.findById(id).get();
		facultyDao.delete(faculty);
		return faculty;
		
	}
	
	
}
