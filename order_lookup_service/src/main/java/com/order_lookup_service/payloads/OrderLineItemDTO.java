package com.order_lookup_service.payloads;
public class OrderLineItemDTO {

	private long id;
	private String itemName;
	private long itemQuantity;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "OrderLineItemDTO [id=" + id + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + "]";
	}

	
}