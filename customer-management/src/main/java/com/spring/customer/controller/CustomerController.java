package com.spring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.customer.dto.Customer;
import com.spring.customer.services.CustomerServiceImplementation;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
  private CustomerServiceImplementation implementation;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAll(){
		return new ResponseEntity<List<Customer>>(implementation.getAllCustomer(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<Customer> getByfind(@PathVariable("customerId") Long customerId) {
		
		return new ResponseEntity<Customer>(implementation.getById(customerId), HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		
		return new ResponseEntity<Customer>(implementation.createCustomer(customer), HttpStatus.CREATED);	
	}
	
	@PutMapping(value = "/{customerId}")
	public ResponseEntity<Customer> updateCus(@PathVariable("customerId") Long customerId, @RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(implementation.updateCustomer(customer,customerId),HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{customerId}")
	public String deleteCust(@PathVariable("customerId") Long customerId) {
		
	    return	implementation.deleteCustomer(customerId);
	}
}
