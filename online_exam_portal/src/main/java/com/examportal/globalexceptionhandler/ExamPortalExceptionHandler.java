package com.examportal.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.examportal.exception.InvalidCredentialsException;

public class ExamPortalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(InvalidCredentialsException.class)
	public  ResponseEntity<String> invalidCredentialsExceptionHandler(InvalidCredentialsException ex) {
		System.out.println(ex);
		return new ResponseEntity<String>("Invalid Credentials ",HttpStatus.NO_CONTENT);
	}	

}
