package com.dealsand.couponsApp.Customer.controller;

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

import com.dealsand.couponsApp.Customer.model.Customer;
import com.dealsand.couponsApp.Customer.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String Test() {
		return "hello world!!!";}
		
		
	 @GetMapping(value = "/list")
	    public List<Customer> getAllCustomers(){
	        return customerRepo.findAll();
	    }
	    @PostMapping(value = "/add")
	    public String addCustmer(@RequestBody Customer customer){
	        customerRepo.save(customer);
	        return "customer Added Succesfully";
	    }
	 
	    @DeleteMapping (value = "/delete/{id}")
	    public String deleteUser(@PathVariable String id) {
	        System.out.println("Delete method called");
	        customerRepo.deleteById(id);
	        return "Deleted Successfully";
	    }
	    
	    @PutMapping(value = "/update/{id}")
	    public String updateUser(@RequestBody Customer customerId, @PathVariable String id){
	    	customerRepo.save(customerId);
	        return "customer is Updated Succesfully";
	    }
	    @GetMapping("/get")
	    public String getAllCoupons(){
       return restTemplate.getForObject("http://coupon/coupons/list",String.class);	    }
	    
	
}
