package com.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.common.domain.Customer;
import com.webstore.common.repository.jpa.CustomerJPARepository;
import com.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerJPARepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}
	
}
