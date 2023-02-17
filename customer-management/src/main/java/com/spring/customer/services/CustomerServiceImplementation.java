package com.spring.customer.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.customer.dto.Address;
import com.spring.customer.dto.Customer;
import com.spring.customer.repository.AddressRepository;
import com.spring.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation  implements  CustomerServices{

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository  addressRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
        
	    return customerRepository.findAll();
	}
	
	@Override
	public String deleteCustomer(Long id) {
         
		customerRepository.deleteById(id);
	   	return "Customer Deleted SuccessFully";
	}
	
    @Override
	public Customer getById(Long id) {

	    return customerRepository.findById(id).get();
	}
	
	@Override
	public Customer createCustomer(Customer customer) {
    
		Address add = customer.getAddress();
        add = addressRepository.save(add);
        customer.setAddress(add);
	   return customerRepository.save(customer);
	}
	
	@Override
	public Customer updateCustomer(Customer customer, Long customeId) {
		Customer existingCustomer = customerRepository.findById(customeId).get();
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setAge(customer.getAge());
		existingCustomer.getAddress().setCity(customer.getAddress().getCity());
		existingCustomer.getAddress().setCountry(customer.getAddress().getCountry());
		
		Customer updated = customerRepository.save(existingCustomer);
		return updated;
	}
}
