package com.dealsand.couponsApp.Customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsand.couponsApp.Customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	void save(String customerId);



	/*
	 * Optional<Customer> findById(String id); Customer findByUserName(String
	 * userName);
	 */
}
