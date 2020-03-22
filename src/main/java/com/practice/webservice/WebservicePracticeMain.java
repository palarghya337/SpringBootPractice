package com.practice.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.practice.webservice")
public class WebservicePracticeMain {

	public static void main(String[] args) {
		SpringApplication.run(WebservicePracticeMain.class, args);
	}
}
