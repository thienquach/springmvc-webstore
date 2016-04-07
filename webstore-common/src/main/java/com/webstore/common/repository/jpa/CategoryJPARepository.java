package com.webstore.common.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.webstore.common.domain.Category;

public interface CategoryJPARepository extends CrudRepository<Category, Long>{

}
