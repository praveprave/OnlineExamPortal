package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.dto.UserDto;
import com.examportal.dto.UserRegistrationDto;
import com.examportal.dto.UserUpdateDto;
import com.examportal.entity.User;
import com.examportal.iservice.UserService;
import com.examportal.serviceimpl.UserServicesImpl;

@RestController
@RequestMapping("admin/users")
public class AdminUserController {
	@Autowired
	UserServicesImpl userServicesImpl;

	
	public AdminUserController(UserServicesImpl userServicesImpl) {
		super();
		this.userServicesImpl = userServicesImpl;
	}
	@GetMapping("/all")
	public List<User> getAllUsers(){
	/*public ResponseEntity<List<UserDto>>getAllUsers(){
	   List<UserDto> users=userServicesImpl.getAllUsers();
		return ResponseEntity.ok(users);*/
		return userServicesImpl.getAllUsers();
	}
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Integer userId) {
		return userServicesImpl.getUserById(userId);
	}
	
	/*public ResponseEntity<UserDto> getUserById(@PathVariable int userId){
		
	UserDto user=userServicesImpl.getUserById(userId);
	return ResponseEntity.ok(user);
	}*/
	@PostMapping
	public ResponseEntity<String>createUser(@RequestBody UserRegistrationDto registrationRequest ){
		
			userServicesImpl.registerUser(registrationRequest);
			return ResponseEntity.ok("Created successful");	
		
	}
	@PutMapping("/{userId}")
		public ResponseEntity<String>updateUser(@PathVariable int userId,@RequestBody UserUpdateDto updateDto){
		userServicesImpl.updateUser(userId, updateDto);
		return ResponseEntity.ok("User updated successfully");
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<String>deleteUser(@PathVariable int userId){
		userServicesImpl.deleteUser(userId);
		return ResponseEntity.ok("User successfully deleted");
	}

}
