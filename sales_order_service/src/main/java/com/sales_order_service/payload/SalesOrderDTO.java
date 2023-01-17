package com.sales_order_service.payload;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalesOrderDTO {



	private long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private long custId;
	@Size(min = 2,max = 50,message = "order description should be more then two characters and less then 50 characters")
	private String orderDesc;
	private double totalPrice;
	private List<OrderLineItemDTO> orderLineItems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderLineItemDTO> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItemDTO> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	@Override
	public String toString() {
		return "SalesOrderDTO [id=" + id + ", orderDate=" + orderDate + ", custId=" + custId + ", orderDesc="
				+ orderDesc + ", totalPrice=" + totalPrice + ", orderLineItems=" + orderLineItems + "]";
	}

}