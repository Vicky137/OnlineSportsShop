package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.CategoryNotFoundException;
import com.app.custom_excs.ProductNotFoundException;
import com.app.dao.ICategoryDao;
import com.app.dto.CategoryDto;
import com.app.dto.ProductDto;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	// dependency
	@Autowired
	private ICategoryDao dao;
	
	private CategoryDto mapToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);

		return categoryDto;
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		System.out.println("dao imple class " + dao.getClass().getName());
		List<Category> categoryEntities = dao.findAll();
		List<CategoryDto> categories = categoryEntities.stream().map(cate -> mapToDto(cate)).collect(Collectors.toList());
		return categories;
	}

	@Override 
	public Category getCategoryByName(String cName) { 
		Category optionalCategory = dao.findByName(cName);
		if(optionalCategory!=null) {
			return optionalCategory;
		}
		return null;
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		Category optionalCategory = dao.findById(id);
		CategoryDto category = mapToDto(optionalCategory);
			return category;

	}

	@Override
	public Integer addCategory(CategoryDto categoryDto) {
		Category category = new Category();
		//List<Product> products = dao.findByVendorId(vendorId);
		// covert list of entities into list of dto's
		// return list
		BeanUtils.copyProperties(categoryDto, category);
		
		Category savedCategory = dao.save(category);
		return savedCategory.getId();
	}

	@Override
	public Category updateCategory(int categoryID, Category existingcategory) {
		Category updatedcategory = dao.findById(categoryID);
		if (updatedcategory != null) {
			updatedcategory.setBrand(existingcategory.getBrand());
			updatedcategory.setAsscociatedSport(existingcategory.getAsscociatedSport());
			return dao.save(updatedcategory);
		}
		throw new ProductNotFoundException("Invalid Product ID");
	}

	@Override
	public String deleteCategory(int categoryID) {
		dao.deleteById(categoryID);
		return "Category with ID " + categoryID + " deleted";
	}

}













