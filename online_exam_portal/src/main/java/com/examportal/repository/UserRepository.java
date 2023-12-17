package com.examportal.repository;

import java.util.List;
import java.util.Optional;
import com.examportal.entity.User;




import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer >{
	//Optional<User> findbyUserId(Integer userId);

	//Users findByUserNameandUserPassword(char userName,String userPassword);

   User findByUserMail(String userMail);
	User save(User user);
	List<User> findAll();
    void deleteById(Integer userId);
	User findByUserMailAndUserPassword(String userMail, String userPassword);

}