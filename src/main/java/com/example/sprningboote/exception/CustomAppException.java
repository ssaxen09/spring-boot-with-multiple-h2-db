package com.example.sprningboote.exception;

public class CustomAppException extends RuntimeException{

	public CustomAppException(String name, Exception e) {
		super(name, e);
	}

	public CustomAppException(Throwable t) {
		super(t);
	}
}
