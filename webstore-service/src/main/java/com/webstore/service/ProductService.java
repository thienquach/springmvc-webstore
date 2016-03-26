package com.webstore.service;

import java.util.List;

import com.webstore.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductByCode(String code);
}
