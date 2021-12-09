package com.dealsandcouponsApp.coupons.controller;

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


import com.dealsandcouponsApp.coupons.model.Coupon;
import com.dealsandcouponsApp.coupons.repository.CouponsRepository;

@RestController
@RequestMapping("/coupons")
public class CouponsController {
	
	@RequestMapping("/")
	public String Test() {
		return "hello world";
		
	}
     @Autowired
	private CouponsRepository couponrepo;
     
     @GetMapping(value="/list")
     public List<Coupon> getList(){
    	 
    	 return couponrepo.findAll(); 
    	 }
     @GetMapping("/get/{provider}")
     public List<Coupon> getByprovider(@PathVariable("provider") String provider){
    	 return couponrepo.findAllByProvider(provider);
    	 
     }
     
     
     @PostMapping(value="/add")
	public String addCoupon(@RequestBody Coupon coupon) {
		couponrepo.save(coupon);
		return "Coupon is Added";
		
	}
	@PutMapping("/update/{id}")
	public String getById(@PathVariable String id, @RequestBody Coupon coupon) {
		Coupon couponid=couponrepo.findById(id).get();
		couponid.setProvider(coupon.getProvider());
		couponid.setCode(coupon.getCode());
		couponid.setCategory(coupon.getCategory() );
		couponid.setDescription(coupon.getDescription());
		couponid.setExpiryDate(coupon.getExpiryDate());
		couponrepo.save(couponid);
		return "updated coupon";
		}
		@DeleteMapping("/delete/{id}")
		public String deleteById(@PathVariable String id) {
			couponrepo.deleteById(id);
	return "deleted succefully";
	}
	
	
	
	
}
