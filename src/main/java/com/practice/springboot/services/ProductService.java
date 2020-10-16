package com.practice.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springboot.bean.Product;
import com.practice.springboot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProducts() {
		return repository.getAll();
	}

	public Product getProduct(int id) {
		
		return repository.get(id);
	}

	public Product update(Product product) {
		return repository.update(product);
	}
}
