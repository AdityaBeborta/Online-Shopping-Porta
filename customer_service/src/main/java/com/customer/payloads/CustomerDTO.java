package com.customer.payloads;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	@NotNull(message = "email cannot be blank")
	@Email(regexp = "([a-zA-Z0-9]+)([\\.{1}])?([a-zA-Z0-9]+)\\@(?:gmail|GMAIL)([\\.])(?:com|COM)")
	private String email;
	
	@Size(min = 2,message ="first name should have minimum 2 characters" )
	private String firstName;
	@Size(min = 2,message ="last name should have minimum 2 characters" )
	private String lastName;

	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(long id,
			@NotNull(message = "email cannot be blank") @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") String email,
			@Size(min = 2, message = "first name should have minimum 2 characters") String firstName,
			@Size(min = 2, message = "last name should have minimum 2 characters") String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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