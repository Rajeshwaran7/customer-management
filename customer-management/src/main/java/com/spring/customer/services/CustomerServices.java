package com.spring.customer.services;

import java.util.List;

import com.spring.customer.dto.Customer;

public interface CustomerServices {

	public List<Customer> getAllCustomer();
	public String deleteCustomer(Long id);
	public Customer getById(Long id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer, Long customeId) ;
}
