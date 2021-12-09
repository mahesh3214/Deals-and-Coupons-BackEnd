package com.dealsand.couponsApp.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsand.couponsApp.Customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	Customer findByid(String id);

}
