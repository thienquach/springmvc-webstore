package com.webstore.common.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.webstore.common.domain.Customer;
import com.webstore.common.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	public List<Customer> getAllCustomers() {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		
		Customer customer = new Customer("Alex", "Quach");
		
		listOfCustomer.add(customer);
		
		return listOfCustomer;
	}

}
