package com.dealsand.couponsApp.Customer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dealsand.couponsApp.Customer.exception.CustomerNotFoundException;
import com.dealsand.couponsApp.Customer.model.Coupon;
import com.dealsand.couponsApp.Customer.model.Customer;
import com.dealsand.couponsApp.Customer.repository.CustomerRepository;

@RestController
@RequestMapping("/users")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String Test() {
		return "hello world!!!";
	}

	// --------------- All crud operations of Customer------------------//

	@GetMapping(value = "/list")
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@PostMapping(value = "/add")
	public String addCustomer(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return "customer Added Succesfully" + customer.getName();
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteCustomer(@PathVariable String id) {
		customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer is not found :" + id));
		customerRepo.deleteById(id);
		return "Deleted Successfully";
	}

	// ------------- Getting data based on Id------------------//

	@PutMapping(value = "/update/{id}")
	public Customer updateUser(@RequestBody Customer customerId, @PathVariable String id) {
		Customer cust = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("customer is not found :" + id));
		cust.setName(customerId.getName());
		cust.setUsername(customerId.getUsername());
		cust.setPassword(customerId.getPassword());
		return customerRepo.save(cust);
	}

	// ---------------------------- To get coupons List-------------------------//

	@GetMapping("/get")
	public List<Coupon> getAllCoupons() {
		Coupon[] cop = restTemplate.getForObject("http://coupon/coupons/list", Coupon[].class);
		return Arrays.asList(cop);
	}
}
