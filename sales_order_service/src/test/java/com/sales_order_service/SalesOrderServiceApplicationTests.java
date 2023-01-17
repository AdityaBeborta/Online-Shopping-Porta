package com.sales_order_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sales_order_service.repository.SalesOrderRepository;
import com.sales_order_service.services.OrderServiceImpl;

@SpringBootTest
class SalesOrderServiceApplicationTests {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@MockBean
	private SalesOrderRepository salesOrderRepository;

	@Test
	void contextLoads() {
	}

}
