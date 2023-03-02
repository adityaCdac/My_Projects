package com.springrestful.springrest.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrestful.springrest.dao.CourseDao;
import com.springrestful.springrest.model.Course;
@Service
public class CourseService {
	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getAllCourse(){
		return courseDao.findAll();
	}
	
	public Course getCourse(int id) {
		 return courseDao.findById(id).get();
	}
	
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}
	
	public Course deleteCourse(int id) {
		
		Course course1=courseDao.findById(id).get();
		courseDao.delete(course1);
		
		return course1;
	}
	public Course updateCourse(Course course){
		Course entity=courseDao.findById(course.getId()).get();
		courseDao.save(entity);
		return entity;
	} 

}
