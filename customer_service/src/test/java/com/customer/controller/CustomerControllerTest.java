package com.customer.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.controler.CustomerController;
import com.customer.payloads.CustomerDTO;
import com.customer.serviceimpl.CustomerService;
import com.customer.utils.ApiResponse;

@SpringBootTest(classes = { CustomerControllerTest.class })
public class CustomerControllerTest {

	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerService customerService;

	private List<CustomerDTO> customers;
	

	private CustomerDTO customer;

	// junit test for get all contacts

	@Test
	@Order(1)
	public void getAllCust() {
		customers = new ArrayList<>();
		customers.add(new CustomerDTO(1, "aditya@gmail.com", "aditya", "beborta"));
		customers.add(new CustomerDTO(2, "sri@gmail.com", "sriya", "rauto"));
		when(customerService.all()).thenReturn(customers);
		List<CustomerDTO> allCustomers = this.customerController.all();
		assertThat(2).isEqualTo(allCustomers.size());

	}
	
	@Test
	@Order(2)
	public void getAllCust_Negative() {
		customers = new ArrayList<>();
		customers.add(new CustomerDTO(1, "aditya@gmail.com", "aditya", "beborta"));
		customers.add(new CustomerDTO(2, "sri@gmail.com", "sriya", "rauto"));
		when(customerService.all()).thenReturn(customers);
		List<CustomerDTO> allCustomers = this.customerController.all();
		assertThat(3).isEqualTo(allCustomers.size());

	}
	
	@Test
	@Order(3)
	public void getCustomerByCustomerId() {
		customer=new CustomerDTO(1, "aditya@gmail.com", "aditya", "beborta");
		long id=1;
		when(customerService.get(id)).thenReturn(customer);
		CustomerDTO customerDTO = this.customerController.get(id);
		assertThat(customer).isEqualTo(customerDTO);
	}

	@Test
	@Order(4)
	public void saveCustomer() {
		customer=new CustomerDTO(1, "aditya@gmail.com", "aditya", "beborta");
		when(customerService.save(customer)).thenReturn(customer);
		CustomerDTO addedCustomer = this.customerController.add(customer);
		assertThat(customer.getEmail()).isEqualTo(addedCustomer.getEmail());
	}
	
	@Test
	@Order(5)
	public void deleteCustomerId() {
		customer=new CustomerDTO(1, "aditya@gmail.com", "aditya", "beborta");
		long id=1;
		ApiResponse apiResponse = customerController.delete(id);
		assertThat("true").isEqualTo(apiResponse.getSuccess().toString().trim());
		
	}
	
	@Test
	@Order(6)
	public void deleteCustomerId_Negative() {
		customer=new CustomerDTO(1, "aditya@gmail.com", "aditya", "beborta");
		long id=1;
		ApiResponse apiResponse = customerController.delete(id);
		assertThat("false").isEqualTo(apiResponse.getSuccess().toString().trim());
		
	}
	

}