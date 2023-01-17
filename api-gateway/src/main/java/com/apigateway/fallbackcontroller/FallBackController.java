package com.apigateway.fallbackcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.util.ApiResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

	public static final String CUSTOMER_SERVICE = "customer-service";

	@CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "customerFallBackHandler")
	@GetMapping("/customerFallBackHandler")
	public ResponseEntity<ApiResponse> customerFallBackHandler(Exception e) {
		System.out.println("hello fall back");
		ApiResponse apiResponse = new ApiResponse("customer service is down", false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
