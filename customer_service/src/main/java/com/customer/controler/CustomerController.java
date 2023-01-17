package com.customer.controler;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.payloads.CustomerDTO;
import com.customer.serviceimpl.CustomerService;
import com.customer.utils.ApiResponse;

@RestController
@RequestMapping("/customers")


public class CustomerController {

	@Autowired
	private CustomerService customerService;

	 private static final Logger LOGGER = Logger.global;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<CustomerDTO> all() {
		LOGGER.info("get all method of customer controller");
		return customerService.all();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public CustomerDTO get(@PathVariable long id) {
		return customerService.get(id);
	}

//	@ResponseStatus(HttpStatus.OK)
//	@PutMapping("/{id}")
//	public CustomerDTO put(@PathVariable long id, @Valid @RequestBody CustomerDTO customerDTO) {
//		customerDTO.setId(id);
//		return customerService.save(customerDTO);
//	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public ApiResponse delete(@PathVariable long id) {

		customerService.delete(id);
		return new ApiResponse("deleted successfully", true);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO add(@Valid @RequestBody CustomerDTO customerDTO) {
		return customerService.save(customerDTO);
	}

}
