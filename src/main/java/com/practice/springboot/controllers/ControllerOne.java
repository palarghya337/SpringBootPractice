package com.practice.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerOne {

	@RequestMapping("/")
	public String requestMapping() {
		return "Here you go... First Spring Boot Run";
	}
}
