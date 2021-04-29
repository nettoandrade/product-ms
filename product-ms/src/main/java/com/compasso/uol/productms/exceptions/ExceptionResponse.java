package com.compasso.uol.productms.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int status_code;
	
	public ExceptionResponse(String message, HttpStatus status) {
		this.message = message;
		this.status_code = status.value();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	
	

}

