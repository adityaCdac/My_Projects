package com.springrestful.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestful.springrest.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
