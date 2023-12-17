package com.examportal.iservice;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.dto.UserDto;

import com.examportal.entity.User;
import com.examportal.repository.UserRepository;


public interface UserService {
	 User login(String userMail,String password);
	 //Users registration(int userId,String userName,String userMail,long mobileNo,String userAddress);
    // Users inserOrModifyUsers(Users users);
      //Users save(UsersRepository userRepository);
	// public void registerUser(UserRegistrationDto registrationRequest);
	 //public void changePassword(String userName, String userPassword);
	 //admin user management
	public User createUser(UserDto userDto);
	 List<User> getAllUsers();
	 //User getUserById(int userId);
	 //UserDto getUserById(int userId);
	 //public void updateUser(int userId,UserUpdateDto updateDto);
	// public void deleteUser(int userId);
	//User getUserById(Integer userId);
	//void registerUser(UserDto userDto);
	User getUserById(Integer userId);
	//Optional<User> updateUser(Integer userId, UserDto userDto);
	 void deleteUser(Integer userId);
	//User createUser(UserDto userDto);
	//Optional<User> updateUser(Integer userId, UserUpdateDto userUpdateDto);
	void updateUser(int userId, UserDto userDto);

	
	 
}
