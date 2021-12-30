package com.dealsand.couponsApp.Admin.controller;

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

import com.dealsand.couponsApp.Admin.AdminRepository.AdminRepository;
import com.dealsand.couponsApp.Admin.model.Admin;
import com.dealsand.couponsApp.Admin.model.Coupon;
import com.dealsand.couponsApp.Admin.model.Customer;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AdminRepository adminrepo;

	@RequestMapping("/")
	public String Test() {
		return "hello world";
	}

	@GetMapping("/list")
	public List<Admin> getAllAdmins() {
		return adminrepo.findAll();
	}

	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin ad) {
		adminrepo.save(ad);
		return "Admin is created :" + ad.getName();
	}

	@PutMapping("/update/{name}")
	public String updateAdmin(@PathVariable String name, @RequestBody Admin ad) {
		adminrepo.save(ad);
		return "Admin is update: " + ad.getName();
	}

	@DeleteMapping("/deleteAdmin/{id}")
	public String DeleteAdmin(@PathVariable String id) {
		adminrepo.deleteById(id);
		return "deleted Admin :" + id;
	}

	// -------------customer----------------//

	@GetMapping("/getCustomers")
	public String getAllCustomers() {
		return restTemplate.getForObject("http://users/users/list", String.class);
	}

	@PutMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable String id, @RequestBody Customer custid) {
		restTemplate.put("http://users/users/update/{id}", custid, id, Customer.class);
		return "customer updated :" + custid.getName();

	}

	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable String id) {
		restTemplate.delete("http://users/users/delete/{id}", id, Customer.class);
		return "deleted Customer" + id;
	}

	// -----------------coupons------------------//

	@GetMapping("/getcoupons")
	public String getAllCoupons() {
		return restTemplate.getForObject("http://coupon/coupons/list", String.class);
	}

	@PostMapping(value = "/addCoupon")
	public String addCoupon(@RequestBody Coupon coupon) {
		return restTemplate.postForObject("http://coupon/coupons/add", coupon, String.class);
	}

	@PutMapping("/updatecoupon/{id}")
	public String updateCoupon(@PathVariable("id") String id, @RequestBody Coupon couponid) {
		restTemplate.put("http://coupon/coupons/update/{id}", couponid, id, Coupon.class);
		return "updated Customer :" + couponid.getProvider();
	}

	@DeleteMapping("/deletecoupon/{id}")
	public String deleteCoupon(@PathVariable String id) {
		restTemplate.delete("http://coupon/coupons/delete/{id}", id, String.class);
		return "deleted Customer" + id;

	}

}
