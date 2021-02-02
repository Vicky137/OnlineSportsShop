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

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/vendor")
@CrossOrigin
public class VendorController {
	// dependency
	@Autowired
	private IVendorService service;

	public VendorController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Vendor loginVendor(@RequestBody Vendor vendor) throws Exception {
		String tempEmail=vendor.getEmail();
		String tempPassword=vendor.getPassword();
		Vendor vendorObj=null;
		if(tempEmail != null && tempPassword != null) {
			vendorObj = service.getVendorByEmailAndPassword(tempEmail, tempPassword);
		}
		if(vendorObj == null) {
			throw new Exception("Bad credentials");
		}
		return vendorObj;
	}
	
	
	// RESTful end point or API end point or API provider
	//for retrieve the details of one manager
	@GetMapping
	public ResponseEntity<?> listAllVendors() {
		System.out.println("in list all vendor");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<Vendor> vendor = service.getAllVendors();
		if (vendor.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(vendor);
	}

	
	  // get vendor details by its id : supplied by clnt using path var
	  
	  @GetMapping("/{vendorId}") 
	  public ResponseEntity<?> getCustomerDetails(@PathVariable int vendorId) {
		  System.out.println("in get vendor details " + vendorId); 
		  // invoke service method 
		  Vendor vendorDetails = service.getVendorById(vendorId); 
		  //valid name : HTTP 200 , marshalled vendor details 
		  if (vendorDetails!=null)
			  return new ResponseEntity<>(vendorDetails, HttpStatus.OK); 
		  // in case of invalid name : HTTP 404 
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }
	 

	//req handling method to create a new vendor : post
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> addVendor(@RequestBody Vendor v) {
		System.out.println("in add Vendor " + v);
		try {
			Vendor savedVendor = service.addVendor(v);
			return new ResponseEntity<>(savedVendor, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	// req handling method to update existing vendor
	@PutMapping("/{vendorID}")
	public ResponseEntity<?> updateVendorDetails(@PathVariable int vendorID, @RequestBody Vendor v) {
		System.out.println("in update " + vendorID + " " + v);
		try {
			Vendor updatedDetails = service.updateVendor(vendorID, v);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @DeleteMapping("/{vendorID}")
	 public String deleteVendor(@PathVariable int vendorID)
	 {
		 System.out.println("in delete Vendor "+vendorID);
		 return service.deleteVendor(vendorID);
		 
	 }

}
