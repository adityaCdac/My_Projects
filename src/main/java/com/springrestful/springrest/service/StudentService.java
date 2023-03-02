package com.springrestful.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestful.springrest.dao.CourseDao;
import com.springrestful.springrest.dao.StudentDao;
import com.springrestful.springrest.model.Course;
import com.springrestful.springrest.model.Student;
import com.springrestful.springrest.model.StudentLogin;
@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getAllCourses(){
		return courseDao.findAll();
	}
	
	public List<Student> getAllStudents(){
		return studentDao.findAll();
	}
	
	
	public Student getStudent(int id) {
		return studentDao.findById(id).get();
	}
	
	
	public Student addStudent(Student student) {
		studentDao.save(student);
		return student;
	}
	
	public Student updateStudent(Student student) {
		Student std=studentDao.findById(student.getId()).get();
		studentDao.save(std);
		return std;
	}
	public Student deleteStudent(int id) {
		Student student=studentDao.findById(id).get();
		studentDao.delete(student);
		return student;
	}
	
	public boolean authenicateStudent(StudentLogin studentLogin){
		boolean success=false;
		List<Student>students=studentDao.findAll();
		for(Student item : students) {
			if(item.getEmail().equals(studentLogin.getEmailId())&& item.getPassword().equals(studentLogin.getPassword())) {
				success=true;
				break;
			}
				
		}
		return success;
	}
	
	
	public List<Course> getAllCourses(int id){
		List<Course>course1=new ArrayList<>();
		Student std=studentDao.findById(id).get();
		List<Student>students=studentDao.findAll();
		for(Student student: students) {
			if(student.getEmail().equals(std.getEmail())) {
				course1.add(student.getCourse());
				
			}
		}
		
		return course1;	
	}
	
}
