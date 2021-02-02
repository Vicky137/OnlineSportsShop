package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Customer;

public interface ICustomerService {

	List<Customer> getAllCustomers();
	
	Customer addCustomer(Customer transientPOJO);
	
	ResponseEntity<Customer> updateCustomerById(int id, Customer detachedPOJO);
	
	Customer getCustomerById(int id);
	
	ResponseEntity<?> deleteAllCustomers();
	
	ResponseEntity<?> deleteCustomer(int id);
	
	ResponseEntity<Customer> findByEmailAndPassword(String email, String password);
	
	ResponseEntity<Customer> findByEmail(String email);
	
	public void sendAccountRegisterEmail(Customer customer);
}
