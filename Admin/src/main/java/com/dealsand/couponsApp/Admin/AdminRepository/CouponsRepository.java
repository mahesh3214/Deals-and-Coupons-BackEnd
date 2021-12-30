package com.dealsand.couponsApp.Admin.AdminRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealsand.couponsApp.Admin.model.Coupon;

public interface CouponsRepository extends MongoRepository<Coupon, String> {

	List<Coupon> findAllByProvider(String provider);

}
