package com.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.webstore.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductByCode(String code);
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByManufacturer(String manufacturer);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams );
	void addProduct(Product product);
}
