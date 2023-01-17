package com.order_lookup_service.exception;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(String msg) {
		super(msg);
	}
}
