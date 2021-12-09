package com.dealsandcouponsApp.coupons.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsandcouponsApp.coupons.model.Coupon;

public interface CouponsRepository extends MongoRepository<Coupon, String> {


	List<Coupon> findAllByProvider(String provider);

	

}
