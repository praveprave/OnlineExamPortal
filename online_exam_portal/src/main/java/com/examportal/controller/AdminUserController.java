package com.examportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.examportal.dto.UserDto;
import com.examportal.entity.User;
import com.examportal.exception.UserAlreadyExistException;
import com.examportal.exception.UserNotFoundException;
import com.examportal.iservice.UserService;
import com.examportal.serviceimpl.UserServicesImpl;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/users") // Assuming a RESTful API structure
public class AdminUserController {

    private UserServicesImpl userServicesImpl; // Assuming an AdminUserService for admin-related business logic

    @Autowired
    public AdminUserController(UserServicesImpl userServicesImpl) {
        this.userServicesImpl = userServicesImpl;
    }
    @PostMapping("/create")
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
    /*@PostMapping("/create")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            // If there are validation errors, construct a meaningful error message
            String errorMessage = result.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .collect(Collectors.joining("; "));
            return ResponseEntity.badRequest().body(errorMessage);
        }

        // Your logic here if validation is successful
        return ResponseEntity.ok("Registration successful"); // Or any other success message
    }*/
    @PutMapping("/{userId}")
	public ResponseEntity<String>updateUser(@PathVariable int userId,@RequestBody UserDto userDto){
	userServicesImpl.updateUser(userId, userDto);
	return ResponseEntity.ok("User updated successfully");
}
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        try {
            userServicesImpl.deleteUser(userId);
            return ResponseEntity.ok("User successfully deleted");
        } catch (UserNotFoundException ex) {
            // Handle UserNotFoundException
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + userId);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServicesImpl.getAllUsers();
        if (users != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(userServicesImpl.getUserById(userId));
    }


}