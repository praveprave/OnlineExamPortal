package com.examportal.iservice;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dto.UserDto;
import com.examportal.dto.UserRegistrationDto;
import com.examportal.dto.UserUpdateDto;
import com.examportal.entity.User;
import com.examportal.repository.UserRepository;


public interface UserService {
	 User login(String userMail,String password);
	 //Users registration(int userId,String userName,String userMail,long mobileNo,String userAddress);
    // Users inserOrModifyUsers(Users users);
      //Users save(UsersRepository userRepository);
	 public void registerUser(UserRegistrationDto registrationRequest);
	 public void changePassword(String userName, String userPassword);
	 //admin user management
	// public void registerUser(UserRegistrationDto registrationDto);
	 List<User> getAllUsers();
	 User getUserById(int userId);
	 //UserDto getUserById(int userId);
	 public void updateUser(int userId,UserUpdateDto updateDto);
	 public void deleteUser(int userId);
	User getUserById(Integer userId);
	
	 
}
