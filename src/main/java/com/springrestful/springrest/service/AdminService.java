package com.springrestful.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestful.springrest.dao.AdminDao;
import com.springrestful.springrest.model.Admin;
@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	public boolean login(Admin admin) {
		Admin temp=adminDao.findById(admin.getId()).get();
		if(temp.getId().equals(admin.getId()) && temp.getPassword().equals(admin.getPassword()))
			return true;
		else
			return false;
		
		
	}
	
/*	public List<Admin> getAdmin(){
		return adminDao.findAll();
	}*/
	
	

}
