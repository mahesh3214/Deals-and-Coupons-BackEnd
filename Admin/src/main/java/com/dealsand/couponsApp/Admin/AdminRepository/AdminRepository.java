package com.dealsand.couponsApp.Admin.AdminRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsand.couponsApp.Admin.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

}
