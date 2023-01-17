package com.customer.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entities.Customer;
import com.customer.entities.Customer_Sos;
import com.customer.exception.CustomerAlreadyExistException;
import com.customer.exception.ResourceNotFoundException;
import com.customer.payloads.CustomerDTO;
import com.customer.repository.CustomerRepository;
import com.customer.repository.CustomerSosRepository;

@Service
public class CustomerService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomerRepository customerRepository;

	
	@Autowired
	private CustomerSosRepository customerSosRepository;

	public List<CustomerDTO> all() {
		return customerRepository.findAll().stream().map(c -> modelMapper.map(c, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	public CustomerDTO save(CustomerDTO customerDTO) {
		Customer findByEmail = this.customerRepository.findByEmail(customerDTO.getEmail());
		if(findByEmail!=null) {
			throw new CustomerAlreadyExistException("customer with "+findByEmail.getEmail()+" email already exist");
		}
		Customer customer = customerRepository.save(modelMapper.map(customerDTO, Customer.class));
		
		Customer_Sos c_Sos = this.modelMapper.map(customerDTO, Customer_Sos.class);
		c_Sos.setId(customer.getId());
		this.customerSosRepository.save(c_Sos);
		CustomerDTO result = modelMapper.map(customer, CustomerDTO.class);

		return result;
	}

	public CustomerDTO get(long customerId) {
		Customer_Sos customer = this.customerSosRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer", "id", customerId));

		return this.modelMapper.map(customer, CustomerDTO.class);
	}

	public void delete(long customerId) {
		Customer customer = this.customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer", "id", customerId));
		this.customerSosRepository.deleteById(customer.getId());
		this.customerRepository.delete(customer);

	}
}