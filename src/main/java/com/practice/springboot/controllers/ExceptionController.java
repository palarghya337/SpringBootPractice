package com.practice.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.springboot.exceptions.InvalidOperationException;
import com.practice.springboot.exceptions.ProductNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = InvalidOperationException.class)
	public ResponseEntity<Object> invalidOperationException(InvalidOperationException exception) {
		return new ResponseEntity<Object>("Operation is not valid", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> productNotFoundException(ProductNotFoundException exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
