package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer>{
	
	Customer findById(int customerId);

	//search by Customer name
	Customer findByName(String cName);
	
	Customer findByEmail(String email);
	
	Customer findByEmailAndPassword(String email, String password);
	
	
	
}