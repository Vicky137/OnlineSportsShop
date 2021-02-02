package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Vendor;

public interface IVendorDao extends JpaRepository<Vendor, Integer>{

	Vendor findByName(String vName);
	
	Vendor findById(int id);
	
	Vendor findByEmail(String email);
	
	Vendor findByEmailAndPassword(String email, String password);
}