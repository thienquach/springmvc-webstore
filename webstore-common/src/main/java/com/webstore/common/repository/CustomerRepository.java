package com.webstore.common.repository;

import java.util.List;

import com.webstore.common.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
}
