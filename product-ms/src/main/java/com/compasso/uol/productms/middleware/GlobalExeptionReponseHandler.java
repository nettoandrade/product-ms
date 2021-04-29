package com.compasso.uol.productms.middleware;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.compasso.uol.productms.exceptions.ExceptionResponse;

@RestControllerAdvice
public class GlobalExeptionReponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ExceptionResponse.class, })
    public ResponseEntity<ExceptionResponse> handleObject(ExceptionResponse ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), HttpStatus.valueOf(ex.getStatus_code()));
        return ResponseEntity.status(HttpStatus.valueOf(ex.getStatus_code())).body(response);
    }
}
