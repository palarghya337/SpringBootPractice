package com.practice.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot.bean.Product;
import com.practice.springboot.services.ProductService;

@RestController
@RequestMapping(path = "product")
public class ProductController {

	@Autowired private ProductService service;
	
	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllProducts() {
		
		return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable int id) {
		return new ResponseEntity<>(service.getProduct(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<Object> update(@RequestBody Product product) {
		return new ResponseEntity<>(service.update(product), HttpStatus.OK);
	}
}
