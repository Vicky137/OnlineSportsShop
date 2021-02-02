package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	// dependency
	@Autowired
	private IAdminDao dao;
	
	@Override 
	public Admin getAdminByEmailAndPassword(String email, String password) { 
		return dao.findByEmailAndPassword(email, password); 
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return dao.findAll();
	}	

}













