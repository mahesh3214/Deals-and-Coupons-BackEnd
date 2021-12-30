package com.dealsand.couponsApp.Customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "customer")
public class Customer {

	@Id
	private String id;
	private String name;

	private String username;
	@JsonIgnore
	private String password;

	public Customer() {

	}

	public Customer(String id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;

		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}