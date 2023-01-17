package com.sales_order_service.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sales_order_service.entity.SalesOrder;
import com.sales_order_service.exceptions.ItemNotFoundException;
import com.sales_order_service.exceptions.ResourceNotFoundException;
import com.sales_order_service.payload.CustomerDTO;
import com.sales_order_service.payload.ItemDTO;
import com.sales_order_service.payload.OrderLineItemDTO;
import com.sales_order_service.payload.SalesOrderDTO;
import com.sales_order_service.repository.SalesOrderRepository;
import com.sales_order_service.util.ApplicationConstants;

@Service
public class OrderServiceImpl {

	@Autowired
	
	private RestTemplate restTemplate;

	@Autowired
	
	private ModelMapper modelMapper;

	@Autowired
	private SalesOrderRepository salesOrderRepository;

	public SalesOrderDTO addOrder(SalesOrderDTO salesOrderDTO) {
		CustomerDTO customer = this.restTemplate
				.getForObject(ApplicationConstants.CUSTOMER_SERVICE_URL + salesOrderDTO.getCustId(), CustomerDTO.class);

		
		List<?> forObject = this.restTemplate.getForObject(ApplicationConstants.ITEM_SERVICE_URL, List.class);

		List<ItemDTO> listOfItems = forObject.stream().map((e) -> this.modelMapper.map(e, ItemDTO.class))
				.collect(Collectors.toList());
		List<OrderLineItemDTO> orderLineItems = salesOrderDTO.getOrderLineItems();

		
		double totalPrice = 0;
		for (OrderLineItemDTO orderLineItemDTO : orderLineItems) {
			int counter = 0;
			double price = 0;
					for (ItemDTO item : listOfItems) {
				
				if ((item.getName().equalsIgnoreCase(orderLineItemDTO.getItemName()))) {
					counter++;
					price = price + item.getPrice() * orderLineItemDTO.getItemQuantity();
					totalPrice = totalPrice + price;
				}

			}
			if (counter == 0) {
				throw new ItemNotFoundException("sorry item doesn't exist");
			} 
		}
		//set here
		salesOrderDTO.setTotalPrice(totalPrice);
		salesOrderDTO.setOrderDate(new Date());
		SalesOrder save = this.salesOrderRepository.save(this.modelMapper.map(salesOrderDTO, SalesOrder.class));

		return this.modelMapper.map(save, SalesOrderDTO.class);
	}

	// get all orders of a customer
	public List<SalesOrderDTO> getOrderByCid(long cId) {
		CustomerDTO customer = this.restTemplate.getForObject(ApplicationConstants.CUSTOMER_SERVICE_URL + cId,
				CustomerDTO.class);
		List<SalesOrder> orderByCustId = salesOrderRepository.findByCustId(cId);
		return orderByCustId.stream().map((e) -> this.modelMapper.map(e, SalesOrderDTO.class))
				.collect(Collectors.toList());
	}

	// find order by order id
	public SalesOrderDTO getOrderByOrderId(long orderId) {
		SalesOrder order = this.salesOrderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("order", "id", orderId));
		return this.modelMapper.map(order, SalesOrderDTO.class);
	}
}
