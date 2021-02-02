package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	// dependency
	@Autowired
	private ICustomerService service;

	public CustomerController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	
	@PostMapping(path = "/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) throws Exception {
		String tempEmail=customer.getEmail();
		String tempPassword=customer.getPassword();
		ResponseEntity<Customer> customerObj=null;
		if(tempEmail != null && tempPassword != null) {
			customerObj = service.findByEmailAndPassword(tempEmail, tempPassword);
		}
		if(customerObj == null) {
			throw new Exception("Bad credentials");
		}
		return customerObj;
	}
	
	// RESTful end point or API end point or API provider
	//for retrieve the details of one manager
	@GetMapping
	public ResponseEntity<?> listAllCustomers() {
		System.out.println("in list all customer");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Customer> customer = service.getAllCustomers();
		if (customer.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(customer);
	}

	
	  // get customer details by its id : supplied by clnt using path var
	  
	  @GetMapping("/{customerId}") 
	  public ResponseEntity<?> getCustomerDetails(@PathVariable int customerId) {
		  System.out.println("in get customer details " + customerId); 
		  // invoke service method 
		  Customer customerDetails = service.getCustomerById(customerId); 
		  //valid name : HTTP 200 , marshalled customer details 
		  if (customerDetails!=null)
			  return new ResponseEntity<>(customerDetails, HttpStatus.OK); 
		  // in case of invalid name : HTTP 404 
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }
	 

	//req handling method to create a new customer : post
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		System.out.println("in add customer " + customer);
		try {
			Customer savedCustomer = service.addCustomer(customer);
			return new ResponseEntity<>(savedCustomer, HttpStatus.OK);	
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	
/*	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public  User registerUser(@RequestBody User user) throws Exception {
		String tempEmail=user.getEmail();
		if(tempEmail!=null  && "".equals(tempEmail)) {
			User userobj=service.fetchUserByEmail(tempEmail);
			if(userobj !=null) {
				throw new Exception("User this id "+tempEmail+"is already exist");
			}
			
		}
		User userobj = null;
		userobj=service.saveUser(user);
		if (userobj != null) {
			 service.sendAccountRegisterEmail(userobj);
				return userobj;
			}
			return null;		
}*/

	
	
	
	
	

	// req handling method to update existing customer
	@PutMapping("/{customerID}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable int customerID, @RequestBody Customer c) {
		System.out.println("in update " + customerID + " " + c);
		try {
			ResponseEntity<Customer> updatedDetails = service.updateCustomerById(customerID, c);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{customerID}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerID)
	{
		System.out.println("in delete customer "+customerID);
		return service.deleteCustomer(customerID);
		 
	}
	 
	@DeleteMapping
	public ResponseEntity<?> deleteAllCustomers()
	{
		return service.deleteAllCustomers();
	}

}
