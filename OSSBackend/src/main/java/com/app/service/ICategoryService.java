package com.app.service;

import java.util.List;

import com.app.dto.CategoryDto;
import com.app.pojos.Category;

public interface ICategoryService {
	// list all Customers
	List<CategoryDto> getAllCategories();

	// get Customer details by name
	Category getCategoryByName(String cName);
	
	// get Customer details by id
	CategoryDto getCategoryById(int id);

	// add new Customer details
	Integer addCategory(CategoryDto transientPOJO);

	// update existing Customer details
	Category updateCategory(int categoryID, Category detachedPOJO);
	
	String deleteCategory(int categoryID);
	
}
