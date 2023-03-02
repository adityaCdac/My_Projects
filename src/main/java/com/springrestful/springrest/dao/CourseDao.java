package com.springrestful.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestful.springrest.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
