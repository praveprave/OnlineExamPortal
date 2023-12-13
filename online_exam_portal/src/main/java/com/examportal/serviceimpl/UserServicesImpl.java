
package com.examportal.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.examportal.dto.UserDto;
import com.examportal.dto.UserLoginDto;

import com.examportal.dto.UserRegistrationDto;
import com.examportal.dto.UserUpdateDto;
import com.examportal.entity.User;
import com.examportal.exception.InvalidCredentialsException;
import com.examportal.exception.UserNotFoundException;
import com.examportal.iservice.UserService;
import com.examportal.repository.UserRepository;


@Service
public class UserServicesImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	
	/*@Transactional(readOnly=true)
	  @Override
	public User login(String userMail, String password) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserMail(userMail);
		if(user !=null && user.getUserPassword().equals(password)) {
			return user;
		}
		else {
			throw new InvalidCredentialsException("Invalid username or password");
		}
	}*/
	//Business logic for user login
	@Transactional(readOnly=true)
	@Override
	public User login(String userMail,String userPassword){
		User existingUser=userRepository.findByUserMail(userMail);
		System.out.println(existingUser.getUserMail() +" " + existingUser.getUserPassword());
		if(existingUser.getUserMail().equals(userMail) && !(existingUser.getUserMail().equals(null))) {
			if(existingUser.getUserPassword().equals(userPassword)) {
				System.out.println("login successful");
				return existingUser;
			}
			else {
				System.out.println("check password");
			}
		}
		else {
			System.out.println("you are  unauthorized admin");
		}
		return null;
 
	}


//business logic for user registeration or create row to the data
	@Override
	public void registerUser(UserRegistrationDto registrationRequest) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
		//Users user =Users.usersRepository.saveAll();
			User newUser = new User();
			newUser.setUserId(registrationRequest.getUserId());
			newUser.setUserName(registrationRequest.getUserName());
			newUser.setUserPassword(registrationRequest.getUserPassword());
			newUser.setUserMail(registrationRequest.getUserMail());
			newUser.setMobileNo(registrationRequest.getMobileNo());
			newUser.setUserAddress(registrationRequest.getUserAddress());
			userRepository.save(newUser);
			
			
		}

	@Override
	public void changePassword(String userName, String userPassword) {
		// TODO Auto-generated method stub
	
	}
	
    @Autowired
    public UserServicesImpl(UserRepository userRepository) {
    	this.userRepository=userRepository;
    }
    //logic to get all users
    @Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		/*List<User> user=userRepository.findAll();
		return user.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());*/
    	return userRepository.findAll();
	}

	/*@Override
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
	}*/
	/*public UserDto getUserById(int userId) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with Id:"+userId));
		
		return convertToDto(user);
	}*/
//logic for update data
	@Override
	public void updateUser(int userId, UserUpdateDto updateDto) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with Id:"+userId));
		existingUser.setUserName(updateDto.getUserName());
		existingUser.setMobileNo(updateDto.getMobileNo());
		existingUser.setUserMail(updateDto.getUserMail());
		existingUser.setUserAddress(updateDto.getUserAddress());
		userRepository.save(existingUser);
	}
//to delete
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
	/*	UserDto userDto=new UserDto();
		userDto.setUserId(userDto.getUserId());
		userDto.setUserName(userDto.getUserName());
		userDto.setMobileNo(userDto.getMobileNo());
		userDto.setUserMail(userDto.getUserMail());
		userDto.setUserAddress(userDto.getUserAddress());
		userDto.setUserPassword(userDto.getUserPassword());*/
		userRepository.deleteById(userId);
		
		
		
	}
//get the user by user id
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found"));
	}


}
	
    	
