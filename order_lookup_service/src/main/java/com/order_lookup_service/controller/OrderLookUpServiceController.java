package com.order_lookup_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order_lookup_service.exception.CustomerDontHaveOrderException;
import com.order_lookup_service.payloads.ApplicationConstants;
import com.order_lookup_service.payloads.SalesOrderDTO;

@RestController
@RequestMapping("/orderLookUpService")
public class OrderLookUpServiceController {

	
	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired
	private ModelMapper modelMapper;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{orderId}")
	public SalesOrderDTO getByOrderId(@PathVariable long orderId) {
		System.out.println("order look up service");
		SalesOrderDTO orderById = restTemplate.getForObject(ApplicationConstants.SALES_ORDER_SERVICE_URL + orderId,
				SalesOrderDTO.class);
		return orderById;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/customer/{cid}")
	public List<SalesOrderDTO> getAllOrderByCustomerId(@PathVariable long cid) {
		List<?> forObject = this.restTemplate.getForObject(ApplicationConstants.SALES_ORDER_SERVICE_URL2 + cid, List.class);

		List<SalesOrderDTO> listOfItems = forObject.stream().map((e) -> this.modelMapper.map(e, SalesOrderDTO.class))
				.collect(Collectors.toList());
		if(listOfItems.size()==0) {
			throw new CustomerDontHaveOrderException("customer does not placed any order yet!!!");
		}
		return listOfItems;

	}
}
