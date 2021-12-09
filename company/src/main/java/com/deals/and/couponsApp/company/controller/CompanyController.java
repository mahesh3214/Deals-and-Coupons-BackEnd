package com.deals.and.couponsApp.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deals.and.couponsApp.company.model.Companys;
import com.deals.and.couponsApp.company.model.Coupon;
import com.deals.and.couponsApp.company.repository.CompanyRepository;
import com.deals.and.couponsApp.company.repository.CouponsRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private RestTemplate restTemplate; 
	
    @Autowired
	private CompanyRepository companyrepo;
	@Autowired
    private CouponsRepository couponrepo;
       
        @GetMapping("/getCompanys")
        public List<Companys> getAllCompanys(){
        	return companyrepo.findAll();
        	
        }
    @PostMapping("/addcompany")
    public String addCompany(@RequestBody Companys company) {
    	companyrepo.save(company);
    	return "company added :"+company.getCompanyname();
    	
    }
    
    @PutMapping("/update/{companyname}")
    public String updateCompany(@PathVariable String companyname,@RequestBody Companys company) {
    	Companys comp= companyrepo.findByCompanyname(companyname);
    	comp.setCompanyname(company.getCompanyname());
    	comp.setUsername(company.getUsername());
    	comp.setPassword(company.getPassword());
    	companyrepo.save(comp);
    	return "company updated :"+comp.getCompanyname();
    }
    @DeleteMapping("/delete/{companyname}")
    public String deleteCompany(@PathVariable String companyname) {
    	companyrepo.deleteByCompanyname(companyname);
    	return "delete company :"+companyname;
    }
    
    
    //----------------coupons data--------------------------//
    
    @PostMapping("/add")
	public  String addCoupon(@RequestBody Coupon coupon){
     return restTemplate.postForObject("http://coupon/coupons/add",coupon,String.class);   	
}
    @GetMapping("/getcoupons/{provider}")
public String getCoupons(@PathVariable("provider") String provider){
return    	 restTemplate.getForObject("http://coupon/coupons/get/{provider}",String.class,provider);

}
   
}
