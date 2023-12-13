package com.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.UserLoginDto;
import com.examportal.dto.UserRegistrationDto;
import com.examportal.entity.User;
import com.examportal.serviceimpl.UserServicesImpl;


@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	UserServicesImpl userServicesImpl;
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginDto userLogin){
		User user=userServicesImpl.login(userLogin.getUserMail(),userLogin.getUserPassword());
		if(user !=null) {
			return ResponseEntity.ok("Login successful");
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
			//return "Invalid username or password";
		}
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String>registerUser(@RequestBody UserRegistrationDto registrationRequest ){
		try {
			userServicesImpl.registerUser(registrationRequest);
			return ResponseEntity.ok("Registration successful");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
			
		}
		
	}
	

}
