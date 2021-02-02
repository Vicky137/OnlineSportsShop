package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController // => @Controller at class level + @ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	// dependency
	@Autowired
	private IAdminService service;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Admin loginUser(@RequestBody Admin user) throws Exception {
		String tempEmail=user.getEmail();
		String tempPassword=user.getPassword();
		Admin userObj=null;
		if(tempEmail != null && tempPassword != null) {
			userObj = service.getAdminByEmailAndPassword(tempEmail, tempPassword);
		}
		if(userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> listAllAdmins() throws Exception {
		System.out.println("in list all admins");
		List<Admin> admin = service.getAllAdmins();
		if (admin.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return  ResponseEntity.ok(admin);
	}
		  
}
