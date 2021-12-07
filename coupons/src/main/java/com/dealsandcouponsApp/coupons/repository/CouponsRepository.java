package com.dealsandcouponsApp.coupons.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsandcouponsApp.coupons.model.Coupon;

public interface CouponsRepository extends MongoRepository<Coupon, String> {

}
