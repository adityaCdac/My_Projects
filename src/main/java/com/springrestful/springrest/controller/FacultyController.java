package com.springrestful.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestful.springrest.model.Faculty;
import com.springrestful.springrest.service.FacultyService;

@CrossOrigin
@RestController
public class FacultyController {
	@Autowired
	private FacultyService facultyService;
	
	
	@GetMapping("/faculty")
	public List<Faculty> getAllFaculty(){
		return facultyService.getAllFaculty();
	}
	
	@GetMapping("/faculty/{facultyId}")
	public Faculty getFaculty(@PathVariable String facultyId) {
		return facultyService.getFaculty(Integer.parseInt(facultyId));
	}
	
	@DeleteMapping("/faculty/{facultyId}")
	public Faculty deleteFaculty(@PathVariable String facultyId){
		return facultyService.deleteFaculty(Integer.parseInt(facultyId));
	}
	
	@PostMapping("/faculty")
	public Faculty deleteFaculty(@RequestBody Faculty faculty) {
		return facultyService.addFaculty(faculty);
	}
	
	@PutMapping("/faculty")
	public Faculty updateFaculty(@RequestBody Faculty faculty) {
		return facultyService.updateFaculty(faculty);
	}
	

}
