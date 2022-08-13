package com.example.sprningboote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({CustomAppException.class, IllegalArgumentException.class})
	public ResponseEntity<Object> handleCustomeException(Exception customAppException, WebRequest request) {
		return new ResponseEntity<>(customAppException.getMessage(), HttpStatus.NOT_FOUND);
	}
}

