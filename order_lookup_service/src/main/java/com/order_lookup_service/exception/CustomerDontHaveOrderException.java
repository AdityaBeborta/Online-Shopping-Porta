package com.order_lookup_service.exception;

public class CustomerDontHaveOrderException extends RuntimeException{

	public CustomerDontHaveOrderException(String msg) {
		super(msg);
	}
}
