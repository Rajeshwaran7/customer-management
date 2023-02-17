package com.spring.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.customer.dto.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
