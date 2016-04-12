package com.webstore.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webstore.common.domain.Product;
import com.webstore.common.repository.jpa.ProductJPARepository;
import com.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductJPARepository productRepository;
	
	
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}
	
	public Page<Product> findAll(Pageable pageable){
		return productRepository.findAll(pageable);
	}

	public Product findByCode(String code) {
		return productRepository.findByCode(code);
	}

	public Page<Product> findByCategory(String category, Pageable pageable) {
//		Pageable pageable = new PageRequest(0, 10, Direction.ASC, "name");
		return productRepository.findByCategory(category, pageable);
	}

	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		return (Set<Product>) productRepository.findAll();
	}

	public Page<Product> findByManufacturer(String manufacturer, Pageable pageable) {
//		Pageable pageable = new PageRequest(0, 10, Direction.ASC, "name");
		return productRepository.findByManufacturer(manufacturer, pageable);
	}

	@Override
	public void addProduct(Product product) {
		product.setCreatedDate(new Date(System.currentTimeMillis()));
		product.setLastUpdatedDate(new Date(System.currentTimeMillis()));
		productRepository.save(product);
	}

	@Override
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
