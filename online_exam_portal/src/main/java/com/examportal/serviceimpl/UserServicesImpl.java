
package com.examportal.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.examportal.dto.UserDto;
import com.examportal.dto.UserLoginDto;
import com.examportal.entity.User;
import com.examportal.exception.InvalidCredentialsException;
import com.examportal.exception.UserAlreadyExistException;
import com.examportal.exception.UserNotFoundException;
import com.examportal.iservice.UserService;
import com.examportal.repository.UserRepository;

import jakarta.validation.Valid;


@Service
@Transactional
public class UserServicesImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	public UserServicesImpl(UserRepository userRepository2) {
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly=true)
	 @Override
	    public User login(String userMail, String userPassword) {
	        User existingUser = userRepository.findByUserMailAndUserPassword(userMail, userPassword);

	        // Check if existingUser is not null before accessing its methods
	        if (existingUser != null) {
	            System.out.println("Login successful for user: " + existingUser.getUserMail());
	            return existingUser;
	        } else {
	            System.out.println("Login failed. User not found with provided credentials.");
	            return null; // Or throw an exception if necessary
	        }
	    }

	@Override
	public User createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
			// TODO Auto-generated method stub
		//Users user =Users.usersRepository.saveAll();

			User newUser = new User();
			newUser.setUserId(userDto.getUserId());
			newUser.setUserName(userDto.getUserName());
			newUser.setUserPassword(userDto.getUserPassword());
			newUser.setUserMail(userDto.getUserMail());
			newUser.setMobileNo(userDto.getMobileNo());
			newUser.setUserAddress(userDto.getUserAddress());
			return userRepository.save(newUser);
			
			
		}

	@Override
	public void updateUser(int userId, UserDto userDto) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with Id:"+userId));
		existingUser.setUserName(userDto.getUserName());
		existingUser.setMobileNo(userDto.getMobileNo());
		existingUser.setUserMail(userDto.getUserMail());
		existingUser.setUserAddress(userDto.getUserAddress());
		userRepository.save(existingUser);
		//throw new InvalidCredentialsException("usser prprpr");
	}
	
	@Override
	public void deleteUser(Integer userId) {
	    Optional<User> user = userRepository.findById(userId);
	    if (user.isPresent()) {
	        userRepository.deleteById(userId);
	    } else {
	        throw new UserNotFoundException("User not found with ID: " + userId);
	    }
	}

	    @Override
	    public List<User> getAllUsers() {
	        try {
	            return userRepository.findAll();
	        } catch (Exception e) {
	            // Handle exception appropriately (e.g., log it)
	            return null;
	        }
	    }

	    @Override
	    public User getUserById(Integer userId) {
	    	Optional<User> opUser = userRepository.findById(userId);
	    	if(opUser.isPresent()) return opUser.get();
	    	throw new UserNotFoundException("User not found with Id: " + userId);
	    }

	    private String hash(String password) {
	        // Placeholder for password hashing logic
	        return password; // Replace with actual hashing logic
	    }
	}