package com.springrestful.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestful.springrest.model.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer> {
	
}
