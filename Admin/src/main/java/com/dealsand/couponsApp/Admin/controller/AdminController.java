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
   
	@RequestMapping("/")
	public String Test() {
		return "hello world";
     }
	@Autowired
	private AdminRepository adminrepo;
	
    @GetMapping("/list")
	public List<Admin> getAllAdmins(){
		return adminrepo.findAll();
	}
	@PostMapping("/addAdmin")
    public String addAdmin(@RequestBody Admin ad) {
    	adminrepo.save(ad);
    	return "Admin is created :"+ad.getName();
    }
	@PutMapping("/update/{name}")
	public String updateAdmin(@PathVariable String name,@RequestBody Admin ad) {
		adminrepo.save(ad);
		return "Admin is update: "+ad.getName();
	}
	@DeleteMapping("/deleteAdmin/{id}")
	public String DeleteAdmin(@PathVariable String id) {
		adminrepo.deleteById(id);
		return "deleted Admin :" +id;
	}
	
	
	
	
	//-------------customer----------------//
	@GetMapping("/getCustomers")
	public String getAllCustomers() {
		return restTemplate.getForObject("http://customer/customer/list", String.class);
	}
	@PutMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id") String id, @RequestBody Customer custid) {
		restTemplate.put("http://customer/customer/update/{id}",custid,String.class);
		return "updated Customer :"+custid.getFirstName();	}

	@DeleteMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable String id) {
		restTemplate.delete("http://customer/customer/delete/{id}",id,String.class);
		return "deleted Customer"+id;
	}
	
	
	
	//-----------------coupons------------------//
	
	
    @GetMapping("/getcoupons")
    public String getAllCoupons(){
   return restTemplate.getForObject("http://coupon/coupons/list",String.class);	 
   }
    @PostMapping(value = "/addCoupon")
    public  String addCoupon(@RequestBody Coupon coupon){
        return  restTemplate.postForObject("http://coupon/coupons/add",coupon,String.class);
    }
    @PutMapping("/updatecoupon/{id}")
	public String updateCoupon(@PathVariable("id") String id, @RequestBody Coupon couponid) {
		restTemplate.put("http://coupon/coupons/update/{id}",couponid,String.class);
		return "updated Customer :"+couponid.getProvider();
   
}  
    @DeleteMapping("/deletecoupon/{id}")
public String deleteCoupon(@PathVariable String id) {
	restTemplate.delete("http://coupon/coupons/delete/{id}",id,String.class);
	return "deleted Customer"+id;
    
    }

}
	
	
