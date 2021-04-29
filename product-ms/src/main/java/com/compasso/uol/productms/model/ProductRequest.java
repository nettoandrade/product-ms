package com.compasso.uol.productms.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.http.HttpStatus;

import com.compasso.uol.productms.exceptions.ExceptionResponse;

public class ProductRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private BigDecimal price;

	public ProductRequest() {

	}

	public ProductRequest(String name, String description, BigDecimal price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public void validatePriceGreaterZero() throws ExceptionResponse {
		if(this.price.doubleValue() < 0) {
			throw new ExceptionResponse("Preço menos que zero!!", HttpStatus.BAD_REQUEST);
		}
	}

}

