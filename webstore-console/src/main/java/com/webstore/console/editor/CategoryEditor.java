package com.webstore.console.editor;

import java.beans.PropertyEditorSupport;

import com.webstore.common.domain.Category;
import com.webstore.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {
	
	
	private CategoryService categoryService;
	
	public CategoryEditor(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@Override
	public void setAsText(String text){
		Category category = categoryService.findOne(Long.parseLong(text));
		setValue(category);
	}

}
