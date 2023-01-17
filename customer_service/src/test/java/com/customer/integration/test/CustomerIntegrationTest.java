package com.customer.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.customer.payloads.CustomerDTO;
import com.customer.utils.ApplicationConstants;

@SpringBootTest
public class CustomerIntegrationTest {

	private RestTemplate restTemplate = new RestTemplate();

	// get customer by customer id
	@Test
	public void getCustomerById() throws JSONException {
		ResponseEntity<String> customerByName = this.restTemplate
				.getForEntity(ApplicationConstants.GET_BY_CUSTOMER_ID_URL, String.class);
		String expected = ApplicationConstants.EXPECTED_CUSTOMER;
		JSONAssert.assertEquals(expected, customerByName.getBody(), false);

	}

	// get all customers
	@Test
	public void getAllCustomers() throws JSONException {
		ResponseEntity<String> getAllCustomers = this.restTemplate.getForEntity(ApplicationConstants.GET_ALL_CUSTOMERS_URL,
				String.class);
		String expected = ApplicationConstants.EXPECTED_ALL_CUSTOMER;

		assertThat(getAllCustomers.getBody().length()).isGreaterThan(0);

	}

	// add customer
	@Test
	@Disabled
	public void addCustomer() throws JSONException {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setEmail("monolithic@gmail.com");
		customerDTO.setFirstName("mono");
		customerDTO.setLastName("bebortaaaa");
		String expected = ApplicationConstants.ADDED_CUSTOMER_EXPEXTED;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CustomerDTO> request = new HttpEntity<CustomerDTO>(customerDTO, headers);
		ResponseEntity<String> savedItem = this.restTemplate.postForEntity(ApplicationConstants.ADD_CUSTOMER_URL,
				request, String.class);
		JSONAssert.assertEquals(expected, savedItem.getBody(), false);
	}

}