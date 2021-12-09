package com.deals.and.couponsApp.company.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deals.and.couponsApp.company.model.Coupon;


public interface CouponsRepository extends MongoRepository<Coupon, String> {

}
