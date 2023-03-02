package com.springrestful.springrest.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestful.springrest.model.Admin;
public interface AdminDao extends JpaRepository<Admin, String> {
	
}
