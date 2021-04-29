package com.compasso.uol.productms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.uol.productms.entities.Product;
import com.compasso.uol.productms.exceptions.ExceptionResponse;
import com.compasso.uol.productms.model.ProductRequest;
import com.compasso.uol.productms.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	public Product createProduct(ProductRequest item) throws ExceptionResponse {
		// TODO Auto-generated method stub
		item.validatePriceGreaterZero();
		Product prod = new Product(item.getName(), item.getDescription(), item.getPrice());
		return repository.saveAndFlush(prod);
	}
}
