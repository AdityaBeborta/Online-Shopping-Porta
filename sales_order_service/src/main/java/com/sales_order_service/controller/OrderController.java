package com.sales_order_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sales_order_service.payload.SalesOrderDTO;
import com.sales_order_service.services.OrderServiceImpl;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	// place order

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/")

	public SalesOrderDTO addOrder(@Valid @RequestBody SalesOrderDTO id) {
		return this.orderServiceImpl.addOrder(id);
	}

	// get all order of a customer
	@ApiIgnore
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/customer/{cid}")
	public List<SalesOrderDTO> getAll(@PathVariable long cid) {
		return this.orderServiceImpl.getOrderByCid(cid);

	}

	@ApiIgnore
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{orderId}")
	public SalesOrderDTO getByOrderId(@PathVariable long orderId) {
		return this.orderServiceImpl.getOrderByOrderId(orderId);
	}

}
