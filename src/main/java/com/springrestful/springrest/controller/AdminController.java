package com.springrestful.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestful.springrest.model.Admin;
import com.springrestful.springrest.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> getLogin(@RequestBody Admin admin){
		boolean success=adminService.login(admin);
		if(success==true)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
/*	@GetMapping("/all")
	public List<Admin> getAll(){
		return adminService.getAdmin();
	}
*/
}
