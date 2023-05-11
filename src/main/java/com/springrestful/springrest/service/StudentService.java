package com.springrestful.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestful.springrest.dao.CourseDao;
import com.springrestful.springrest.dao.StudentCourseDao;
import com.springrestful.springrest.dao.StudentDao;
import com.springrestful.springrest.model.Course;
import com.springrestful.springrest.model.Student;
import com.springrestful.springrest.model.StudentCourse;
import com.springrestful.springrest.model.StudentLogin;
@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private StudentCourseDao studentCourseDao;
	
	public List<Course> getAllCourses(){
		return courseDao.findAll();
	}
	
	public List<Student> getAllStudents(){
		List<Student> students=studentDao.findAll();
		
		return students;
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
		std.setCity(student.getCity());
		std.setCollegeName(student.getCollegeName());
		std.setEmail(student.getEmail());
		std.setMobileNo(student.getMobileNo());
		std.setName(student.getName());
		std.setPincode(student.getPincode());
		std.setState(student.getState());
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
			List<StudentCourse> studentCourses=studentCourseDao.findAll();
			List<Course> courses=new ArrayList<>();
			for(StudentCourse studentCourse : studentCourses) {
				if(studentCourse.getStudent().getId()==id) {
					courses.add(studentCourse.getCourse());
				}
			}
			return courses;
	}
	
	public List<Course> getOtherCourses(int id){
		List<StudentCourse> studentCourses=studentCourseDao.findAll();
		List<Course> courses=new ArrayList<>();
		for(StudentCourse studentCourse : studentCourses) {
			if(studentCourse.getStudent().getId()==id) {
				courses.add(studentCourse.getCourse());
			}
		}
		List<Course> courses1=courseDao.findAll();
		
		
		courses1.removeAll(courses);
		
		return courses1;
	
	}	
	
	public boolean buyCourse(Student student, int id) {
		Course course=courseDao.findById(id).get();
		StudentCourse studentCourse=new StudentCourse();
		Student student1=studentDao.findById(student.getId()).get();
		studentCourse.setCourse(course);
		studentCourse.setStudent(student1);
		studentCourseDao.save(studentCourse);
		return true;
		
	}
}
