package com.webstore.domain.repository;

import java.util.List;

import com.webstore.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
