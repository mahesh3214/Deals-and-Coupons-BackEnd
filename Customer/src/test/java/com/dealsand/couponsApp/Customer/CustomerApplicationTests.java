package com.dealsand.couponsApp.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dealsand.couponsApp.Customer.controller.CustomerController;
import com.dealsand.couponsApp.Customer.model.Customer;
import com.dealsand.couponsApp.Customer.repository.CustomerRepository;

@SpringBootTest
class CustomerApplicationTests {
	@MockBean
	CustomerRepository customerRepository;

	@Autowired
	CustomerController customerController;

	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll())
				.thenReturn(Stream.of(new Customer("1", "amazon", "amaze", "1234")).collect(Collectors.toList()));
		assertEquals(1, customerController.getAllCustomers().size());

	}

	@Test

	public void addCustomerTest() {
		Customer cust = new Customer("1", "amazon", "amaze", "1234");
		when(customerRepository.save(cust)).thenReturn(cust);
		assertEquals("customer Added Succesfully" + cust.getName(), customerController.addCustomer(cust));
	}

	@Test
	public void deleteCustomerTest() {

		String customerId = "1";

		Customer cust = new Customer("1", "amazon", "amaze", "1234");
		customerRepository.deleteById(customerId);
		verify(customerRepository).deleteById(customerId);

	}
}
