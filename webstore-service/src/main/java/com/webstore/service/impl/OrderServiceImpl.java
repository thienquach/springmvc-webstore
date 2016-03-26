package com.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private ProductRepository productRepository;

	public void processOrder(String code, int quantity) {
		Product productByCode = productRepository.getProductByCode(code);
		
		if(productByCode.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of Stock. Available Units in stock " + productByCode.getUnitsInStock()); 
		}
		
		productByCode.setUnitsInStock(productByCode.getUnitsInStock() - quantity);
	}

}
