package com.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.webstore.domain.Product;

public interface ProductRepository {

	List<Product> getAllProducts();
	Product getProductByCode(String code);
	List<Product> getProductByCategory(String category);
	List<Product> getProductsByManufacturer(String manufacturer);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
}
