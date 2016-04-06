package com.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.webstore.common.domain.Product;

public interface ProductService {

	List<Product> findAll();
	Product findByCode(String code);
	List<Product> findByCategory(String category);
	Page<Product> findByCategory(String category, Pageable pageable);
	List<Product> findByManufacturer(String manufacturer);
	Page<Product> findByManufacturer(String manufacturer, Pageable pageable);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams );
	void addProduct(Product product);
}
