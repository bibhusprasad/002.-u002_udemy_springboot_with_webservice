package com.udemy.in28min.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<UserExceptionResponse> userNotFound(UserNotFoundException ex) {
		UserExceptionResponse userExceptionResponse = new UserExceptionResponse();
		userExceptionResponse.setTimeStamp(new Date());
		userExceptionResponse.setMessage(ex.getMessage());
		userExceptionResponse.setDetails("Please try with another user.");
		return new ResponseEntity<UserExceptionResponse>(userExceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<UserExceptionResponse> validationFailed(MethodArgumentNotValidException ex) {
		UserExceptionResponse userExceptionResponse = new UserExceptionResponse();
		userExceptionResponse.setTimeStamp(new Date());
		userExceptionResponse.setMessage(ex.getMessage());
		userExceptionResponse.setDetails("Please enter user having more than 2 letter");
		return new ResponseEntity<UserExceptionResponse>(userExceptionResponse, HttpStatus.BAD_REQUEST);
		
	}

}
