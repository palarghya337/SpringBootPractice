package com.practice.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot.services.FirstService;

@RestController
public class ControllerOne {

	@Autowired private FirstService firstService;
	
	@GetMapping(value = "/getMapping")
	public String getMapping() {
		return firstService.method1();
	}
	@RequestMapping(value = "/requestMapping")
	public String requestMapping() {
		return "Request Mapping method";
	}
}
