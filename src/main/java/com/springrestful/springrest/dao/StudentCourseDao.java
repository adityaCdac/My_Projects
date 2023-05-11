package com.springrestful.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestful.springrest.model.StudentCourse;

public interface StudentCourseDao extends JpaRepository<StudentCourse, Integer> {

}
