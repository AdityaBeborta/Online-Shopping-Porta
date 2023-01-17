package com.customer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.entities.Customer;
import com.customer.entities.Customer_Sos;
import com.customer.repository.CustomerRepository;
import com.customer.repository.CustomerSosRepository;
import com.customer.serviceimpl.CustomerService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
	private CustomerService customerService;
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomerSosRepository customerSosRepository;
	public List<Customer> customer;

	
	@Mock
	public ModelMapper modelMapper;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	@Order(1)
	public void getAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1L, "aditya@gmail.com", "aditya", "bebprta"));
		customers.add(new Customer(2L, "som@gmail.com", "som", "java"));
		when(customerRepository.findAll()).thenReturn(customers);
		assertThat(2).isEqualTo(customerService.all().size());
	}

	@Test
	public void getCustomerById() {
		Customer customer = new Customer(1L, "aditya@gmail.com", "aditya", "bebprta");
		Customer_Sos customerSos=new Customer_Sos(customer.getId(), customer.getEmail(), customer.getFirstName(), customer.getLastName());
		
		lenient().when(customerSosRepository.findById(1L)).thenReturn(Optional.of(customerSos));
		System.err.println(customerSos);
		String email = customerSos.getEmail();
		
		assertThat("aditya@gmail.com").isEqualTo(email);
		
		
	}

	
}