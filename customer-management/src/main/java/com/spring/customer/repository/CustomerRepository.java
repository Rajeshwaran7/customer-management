package com.spring.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.customer.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
