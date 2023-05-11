package com.springrestful.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestful.springrest.model.Course;
import com.springrestful.springrest.model.Student;
import com.springrestful.springrest.model.StudentLogin;
import com.springrestful.springrest.service.StudentService;

@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable String studentId) {
		return studentService.getStudent(Integer.parseInt(studentId));
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@DeleteMapping("/students/{studentId}")
	public Student deleteStudent(@PathVariable String studentId) {
		return studentService.deleteStudent(Integer.parseInt(studentId));
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@PostMapping("/student-login")
	public ResponseEntity<Integer> authenticateStudent(@RequestBody StudentLogin studentLogin){
		boolean success=studentService.authenicateStudent(studentLogin);
		List<Student> list=studentService.getAllStudents();
		int id=0;
		if(success==true)
		{
			for(Student item : list) {
				if(item.getEmail().equals(studentLogin.getEmailId())&& item.getPassword().equals(studentLogin.getPassword())){
					id=item.getId();
					break;
				}
			
			
		}
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(0,HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/student/courses/{studentId}")
	public List<Course> getAllCourses(@PathVariable String studentId){
		return studentService.getAllCourses(Integer.parseInt(studentId));
	}
	
	@GetMapping("/student/other-courses/{studentId}")
	public List<Course> getOtherCourses(@PathVariable String studentId){
		return studentService.getOtherCourses(Integer.parseInt(studentId));
	}
	
	@PostMapping("/buy/{courseId}")
	public ResponseEntity<HttpStatus> buyCourse(@RequestBody Student student,@PathVariable String courseId ){
		boolean result=studentService.buyCourse(student, Integer.parseInt(courseId));
		if(result==true)
			return new ResponseEntity<>(HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
