package com.webstore.service;

import java.util.List;
import java.util.Map;

import com.webstore.common.domain.Category;

public interface CategoryService {
	
	List<Category> findAll();
	Category findOne(Long id);
	void save(Category category);
}
