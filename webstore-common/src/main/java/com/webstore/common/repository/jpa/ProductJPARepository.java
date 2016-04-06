package com.webstore.common.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webstore.common.domain.Product;

@Repository
public interface ProductJPARepository extends CrudRepository<Product, Long> {

	Product findByCode(String code);
	Page<Product> findByCategory(String category, Pageable pageable);
	Page<Product> findByManufacturer(String manufacturer, Pageable pageable);
	List<Product> findByCategory(String category);
	List<Product> findByManufacturer(String manufacturer);
}
