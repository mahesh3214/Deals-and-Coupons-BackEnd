package com.deals.and.couponsApp.company.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document(collection="company")
public class Companys {
	
	@Id
	private String companyname;
	private String username;
	@JsonIgnore
	private String password;
    private String role;
    public Companys() {
    	
    }
	public Companys(String companyname, String username, String password, String role) {
		
		this.companyname = companyname;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
    
    
    
}
