package com.sales_order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sales_order_service.payload.CustomerDTO;

@FeignClient(url = "localhost:8080/customers/get/",name = "orderservice")
public interface OrderClient {

	@GetMapping("/getCustomerById")
	CustomerDTO getASingleCustomer(Long id);
	
	
}
