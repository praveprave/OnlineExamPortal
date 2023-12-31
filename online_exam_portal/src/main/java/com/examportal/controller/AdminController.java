package com.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.AdminLoginDto;
import com.examportal.entity.Admin;
import com.examportal.serviceimpl.AdminServicesImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminServicesImpl adminServicesImpl;
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AdminLoginDto adminLogin){
		Admin admin=AdminServicesImpl.admin(adminLogin.getAdminMail(),adminLogin.getAdminPassword());
		//Users user=usersServicesImpl.login(userLogin.getUserMail(),userLogin.getUserPassword());
		if(admin !=null) {
			return ResponseEntity.ok("Login successful");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
			//return "Invalid username or password";
		}
		
	}

}