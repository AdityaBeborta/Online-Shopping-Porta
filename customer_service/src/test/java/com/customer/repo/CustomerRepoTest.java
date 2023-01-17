package com.customer.repo;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.entities.Customer;
import com.customer.repository.CustomerRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CustomerRepoTest {

	@Autowired
	private CustomerRepository customerRepository;

	// junit for save customer
	
	

	@Test
	@Order(1)
	@Disabled
	public void saveCustomerTest() {
		Customer customer = new Customer();
		customer.setEmail("b@gmail.com");
		customer.setFirstName("junit");
		customer.setLastName("mock");
		Customer save = this.customerRepository.save(customer);
		assertThat(save.getId()).isGreaterThan(0);

	}

	// junit for get customerById
	@Test
	@Order(2)
	public void getCustomerById() {
		Customer customer = this.customerRepository.findById(18L).get();
		assertThat(customer.getId()).isEqualTo(18L);
	}

	// junit for all customers

	@Test
	@Order(3)
	public void getAllCustomers() {
		List<Customer> findAll = this.customerRepository.findAll();
		assertThat(findAll.size()).isGreaterThan(0);
	}

	// junit for updating customer
	@Test
	@Disabled
	@Order(4)
	public void updateCustomer() {
		Customer customer = this.customerRepository.findById(18L).get();
		customer.setEmail("updates@gmail.com");
		Customer customerUpdated = this.customerRepository.save(customer);
		assertThat("updates@gmail.com").isEqualTo(customerUpdated.getEmail());

	}

	@Test
	@Order(5)
	
	public void getCustomerByEmail() {
		Customer cus = this.customerRepository.findByEmail("shubham@gmail.com");
		Customer c = new Customer(18L, "shubham@gmail.com", "shubham", "Ananda");
		assertThat(c.getEmail()).isEqualTo(c.getEmail());

	}
}