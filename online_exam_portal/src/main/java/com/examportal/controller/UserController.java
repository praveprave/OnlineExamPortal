package com.examportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.UserDto;
import com.examportal.dto.UserLoginDto;
import com.examportal.entity.User;
import com.examportal.exception.UserAlreadyExistException;
import com.examportal.serviceimpl.UserServicesImpl;

import jakarta.validation.Valid;



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
	    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto, BindingResult result) {
	        if (result.hasErrors()) {
	            // If there are validation errors, construct a meaningful error message
	            String errorMessage = result.getFieldErrors().stream()
	                    .map(fieldError -> fieldError.getDefaultMessage())
	                    .collect(Collectors.joining("; "));
	            return ResponseEntity.badRequest().body(errorMessage);
	        }

	        try {
	            userServicesImpl.createUser(userDto);
	            return ResponseEntity.ok("User created successfully");
	        } catch (Exception e) {
	            // Log the exception for debugging purposes
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
	        }
	    }
	/*
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDto registrationRequest ){
		try {
			userServicesImpl.registerUser(registrationRequest);
			return ResponseEntity.ok("Registration successful");
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
			
		}
			
	}
	*/
	  /*@PostMapping("/register")
	    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDto registrationRequest, BindingResult bindingResult) {
		  if (bindingResult.hasErrors()) {
	            // If there are validation errors, handle them here
	            List<FieldError> errors = bindingResult.getFieldErrors();
	            Map<String, String> errorMap = new HashMap<>();

	            for (FieldError error : errors) {
	                errorMap.put(error.getField(), error.getDefaultMessage());
	            }

	            // You can log the errors, return a custom response, or throw an exception
	            return ResponseEntity.badRequest().body("Validation errors: " + errorMap);
	        }

	        // If there are no validation errors, proceed with your business logic
	        userServicesImpl.registerUser(registrationRequest);
	        return ResponseEntity.ok("User created successfully");
	    }*/
	}

