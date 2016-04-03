package com.webstore.domain.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.webstore.domain.Product;
import com.webstore.domain.repository.ProductRepository;

public class JPAProductRepository implements ProductRepository{

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
