package com.webstore.common.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webstore.common.domain.Customer;

@Repository
public interface CustomerJPARepository extends CrudRepository<Customer, Long> {

}
