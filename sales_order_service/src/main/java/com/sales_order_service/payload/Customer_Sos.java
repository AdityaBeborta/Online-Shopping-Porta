package com.sales_order_service.payload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMER_SOS")
public class Customer_Sos {

	@Id
	@Column(name = "custId")
	private long id;

	@NotNull
	@Column(name = "custEmail")
	private String email;

	@NotNull
	@Column(name = "custFirstName")
	private String firstName;

	@NotNull
	@Column(name = "custLastName")
	private String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}