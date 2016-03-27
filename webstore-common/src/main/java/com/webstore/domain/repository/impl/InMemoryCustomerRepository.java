package com.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.webstore.domain.Customer;
import com.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	public List<Customer> getAllCustomers() {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		
		Customer customer = new Customer(1, "Alex Quach", "HCMC");
		
		listOfCustomer.add(customer);
		
		return listOfCustomer;
	}

}
