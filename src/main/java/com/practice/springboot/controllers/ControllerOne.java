package com.practice.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot.services.FirstService;

@RestController
public class ControllerOne {

	@Autowired private FirstService firstService;
	
	@GetMapping(value = "/welcome")
	public String requestMapping() {
		return firstService.method1();
	}
}
