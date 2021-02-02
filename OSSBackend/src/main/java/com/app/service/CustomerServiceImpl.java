package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	// dependency
	@Autowired
	private ICustomerDao dao;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<Customer> getAllCustomers() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}
	
	@Override
	public ResponseEntity<Customer> findByEmailAndPassword(String email, String password) {

		Customer authCustomer =  dao.findByEmailAndPassword(email, password);

		return new ResponseEntity<Customer>(authCustomer, HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Customer> findByEmail(String email) {
		dao.findByEmail(email);
		return null;
	}

	@Override
	public Customer getCustomerById(int id) 
	{	  
		return dao.findById(id);
	}
	 
		
	@Override
	public Customer addCustomer(Customer transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

	/*@Override
	public Customer updateCustomer(int customerID, Customer c1) {
		// chk if Customer exists : findById
		Customer c = dao.findById(customerID);
		if (c!=null) {
			Customer customer = c;
			customer.setAddress(c1.getAddress());
			customer.setName(c1.getName());
			customer.setCantactNumber(c1.getCantactNumber());
			customer.setEmail(c1.getEmail());
			customer.setPassword(c1.getPassword());
			return customer;

		}
		//in case of no Customer found : throw custom exception
		throw new CustomerNotFoundException("Invalid Customer ID");
	}*/
	
	@Override
	public ResponseEntity<Customer> updateCustomerById(int id, Customer detachedPOJO) {
		
		Customer existingCustomer = dao.findById(id);
		//CANNOT UPDATE EMAIL ID**********
		if(existingCustomer!=null) {			
			Customer customer = existingCustomer;
			customer.setAddress(detachedPOJO.getAddress());
			customer.setPassword(detachedPOJO.getPassword());
			customer.setContactNumber(detachedPOJO.getContactNumber());

			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public ResponseEntity<?> deleteCustomer(int customerID) {
		try {
			dao.deleteById(customerID);
			return  new ResponseEntity<> (HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<?> deleteAllCustomers() {
		
		try {
			dao.deleteAll();
			return new ResponseEntity<> (HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public void sendAccountRegisterEmail(Customer customer) {
		SimpleMailMessage mailCustomer = new SimpleMailMessage();
		mailCustomer.setTo(customer.getEmail());
		mailCustomer.setFrom("vikas13793@gmail.com");
		mailCustomer.setSubject("Customer Account Successfully Registerd !" + customer.getName());
		mailCustomer.setText("Account Registered Successfully your \n Customer Id : "+ customer.getId() + "\n Password :" + customer.getPassword());
		mailSender.send(mailCustomer);
	}
	
}













