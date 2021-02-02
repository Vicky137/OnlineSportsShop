package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.CategoryDto;
import com.app.pojos.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer>{

	Category findByName(String cName);
	
	Category findById(int id);

}