package com.app.service;

import java.util.List;

import com.app.pojos.Admin;

public interface IAdminService {
	
	List<Admin> getAllAdmins();
	
	// Admin login
	Admin getAdminByEmailAndPassword(String email, String password);	
	
}
