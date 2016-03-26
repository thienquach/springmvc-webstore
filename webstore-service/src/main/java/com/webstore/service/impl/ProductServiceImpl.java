package com.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;
import com.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductByCode(String code) {
		return productRepository.getProductByCode(code);
	}

}
