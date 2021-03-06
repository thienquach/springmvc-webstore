package com.webstore.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstore.common.domain.Category;
import com.webstore.common.repository.jpa.CategoryJPARepository;
import com.webstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryJPARepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Map<String, Category> getCategoryMap() {
		Map<String, Category> categoryMap = new HashMap<String, Category>();
		List<Category> categories = findAll();
		if(categories != null && !categories.isEmpty()){
			for(int i = 0; i < categories.size(); i++){
				categoryMap.put(categories.get(i).getName(), categories.get(i));
			}
		}
		return categoryMap;
	}
	
	@Override
	public Category findOne(Long id){
		return categoryRepository.findOne(id);
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}
	

}
