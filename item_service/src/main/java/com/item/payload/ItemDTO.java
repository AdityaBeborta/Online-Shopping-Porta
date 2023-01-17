package com.item.payload;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemDTO {

	
	private long id;
	@Size(min = 2 ,message = "item name should be minumum of 2 characters")
	private String name;
	@Size(message = "description should be minumum of 2 characters and maximum 50 character",max = 50,min = 2)
	private String description;
	@NotNull(message = "price cannot be null")
	private double price;
	

	public ItemDTO() {
		super();
	}

	public ItemDTO(long id, @Size(min = 2, message = "item name should be minumum of 2 characters") String name,
			@Size(message = "description should be minumum of 2 characters and maximum 50 character", max = 50, min = 2) String description,
			@NotNull(message = "price cannot be null") double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}