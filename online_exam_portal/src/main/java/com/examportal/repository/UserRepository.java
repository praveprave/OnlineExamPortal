package com.examportal.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.entity.User;


public interface UserRepository extends JpaRepository<User, Integer >{
	//Optional<User> findbyUserId(Integer userId);

	//Users findByUserNameandUserPassword(char userName,String userPassword);

	User findByUserMail(String userMail);
	//User save(User user);
	List<User> findAll();
	void deleteById(Integer userId);

}
