package com.compasso.uol.productms.resources;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.uol.productms.entities.Product;
import com.compasso.uol.productms.exceptions.ExceptionResponse;
import com.compasso.uol.productms.model.ProductRequest;
import com.compasso.uol.productms.repositories.ProductRepository;
import com.compasso.uol.productms.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;	

	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findByAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@GetMapping(value = "/search")
	public ResponseEntity<List<Product>> findByFilter(@RequestParam BigDecimal min_price, 
												@RequestParam BigDecimal max_price,
												@RequestParam String q) {
		return ResponseEntity.ok(repository.findByMinPriceAndMaxPriceAndNameOrDescription(min_price, max_price, q));
	}

	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody ProductRequest item) throws ExceptionResponse {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createProduct(item));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> updateProduct() {
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> deleteProduct() {
		return null;
	}

}
