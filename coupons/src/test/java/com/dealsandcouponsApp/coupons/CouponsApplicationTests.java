package com.dealsandcouponsApp.coupons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dealsandcouponsApp.coupons.controller.CouponsController;
import com.dealsandcouponsApp.coupons.model.Coupon;
import com.dealsandcouponsApp.coupons.repository.CouponsRepository;

@SpringBootTest
class CouponsApplicationTests {

	@MockBean
	CouponsRepository couponRepository;

	@Autowired
	CouponsController couponController;

	@Test
	public void getAllCouponsTest() {
		when(couponRepository.findAll())
				.thenReturn(Stream.of(new Coupon("", "amazon", "amaz12", "mobiles", "10% offer", "12-10-2021"))
						.collect(Collectors.toList()));
		assertEquals(1, couponController.getList().size());

	}

	@Test
	public void addCouponTest() {
		Coupon coupon = new Coupon("", "amazon", "ama12", "mobiles", "10% offer", "20-10-2021");
		when(couponRepository.save(coupon)).thenReturn(coupon);
		assertEquals("Coupon is Added" + coupon, couponController.addCoupon(coupon));
	}

	@Test
	public void deleteDealTest() {

		String couponId = "1";

		Coupon coupon = new Coupon("1", "amazon", "ama12", "mobiles", "10% offer", "12-10-21");
		couponRepository.deleteById(couponId);
		verify(couponRepository).deleteById(couponId);

	}
}
