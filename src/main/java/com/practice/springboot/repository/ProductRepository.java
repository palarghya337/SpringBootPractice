package com.practice.springboot.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.practice.springboot.bean.Product;
import com.practice.springboot.exceptions.ProductNotFoundException;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductRepository {

	private Map<Integer, Product> idProductMap;
	
	public ProductRepository() {
		idProductMap = new HashMap<>();
		loadAllProducts();
	}

	private void loadAllProducts() {
		
		IntStream.rangeClosed(1, 50).forEach(index -> idProductMap.put(index, new Product(index, "Product-" + index)));
	}
	
	public List<Product> getAll() {
		
		List<Product> products = new LinkedList<>(idProductMap.values());
		return products;
	}

	public Product get(int id) {
		
		return checkIfProductAvailable(id);
	}

	public Product update(Product product) {
		
		Product dbProduct = checkIfProductAvailable(product.getId());
		return idProductMap.put(dbProduct.getId(), product);
	}
	
	private Product checkIfProductAvailable(int id) {
		Product product = idProductMap.get(id);
		if (product == null) {
			throw new ProductNotFoundException(id + "");
		}
		return product;
	}
}
