package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.VendorNotFoundException;
import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Service
@Transactional
public class VendorServiceImpl implements IVendorService {
	// dependency
	@Autowired
	private IVendorDao dao;

	@Override
	public List<Vendor> getAllVendors() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}
	
	
	/*
	 * @Override public Vendor getCustomerDetails(String vName) { //TODO
	 * Auto-generated method stub return dao.findByName(vName); }
	 */
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		return dao.save(vendor);
	}
	
	@Override 
	public Vendor getVendorByEmailAndPassword(String email, String password) { 
		return dao.findByEmailAndPassword(email, password); 
	}
	
	@Override 
	public Vendor getVendorById(int id) 
	{	  
		return dao.findById(id); 
	}
	 
		
	@Override
	public Vendor addVendor(Vendor transientPOJO) {
		// TODO Auto-generated method stub
		return dao.save(transientPOJO);
	}

	@Override
	public Vendor updateVendor(int vendorID, Vendor v1) {
		// chk if Vendor exists : findById
		Vendor v = dao.findById(vendorID);
		if (v!=null) {
			Vendor vendor = v;
			vendor.setContactNumber(v1.getContactNumber());
			vendor.setEmail(v1.getEmail());
			vendor.setStoreName(v1.getStoreName());
			vendor.setName(v1.getName());
			
			return vendor;

		}
		//in case of no Vendor found : throw custom exception
		throw new VendorNotFoundException("Invalid Vendor ID");
	}

	@Override
	public String deleteVendor(int vendorId) {
		dao.deleteById(vendorId);
		return "Vendor with ID " + vendorId + " deleted";
	}
	
}













