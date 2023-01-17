package com.sales_order_service.exceptions;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(String msg) {
		super(msg);
	}
}
