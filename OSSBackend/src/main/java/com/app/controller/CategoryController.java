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

import com.app.dto.CategoryDto;
import com.app.pojos.Category;
import com.app.service.ICategoryService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/category")
//@Validated
@CrossOrigin
public class CategoryController {
	// dependency
	@Autowired
	private ICategoryService service;

	public CategoryController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	
	// RESTful end point or API end point or API provider
	//for retrieve the details of one manager
	@GetMapping
	public ResponseEntity<?> listAllCategories() {
		System.out.println("in list all Categories");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<CategoryDto> category = service.getAllCategories();
		if (category.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(category);
	}

	
	  // get category details by its id : supplied by clnt using path var
	  
	  @GetMapping("/{categoryId}") 
	  public ResponseEntity<?> getCategoryDetails(@PathVariable int categoryId) {
		  System.out.println("in get customer details " + categoryId); 
		  // invoke service method 
		  CategoryDto categoryDetails = service.getCategoryById(categoryId); 
		  //valid name : HTTP 200 , marshalled category details 
		  if (categoryDetails!=null)
			  return new ResponseEntity<>(categoryDetails, HttpStatus.OK); 
		  // in case of invalid name : HTTP 404 
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	  }
	  
	  
	  @GetMapping("/name/{categoryName}")
		public ResponseEntity<?> geCategoryDetailsByName(@PathVariable String categoryName) {
			System.out.println("in get category details " + categoryName);
			// invoke service method
			Category categoryDetails = service.getCategoryByName(categoryName);
			// valid name : HTTP 200 , marshalled product details
			if (categoryDetails != null)
				return new ResponseEntity<>(categoryDetails, HttpStatus.OK);
			// in case of invalid name : HTTP 404
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	 

	//req handling method to create a new category : post
	@PostMapping
	public ResponseEntity<Integer> addCategory(@RequestBody CategoryDto newCategory) {
		System.out.println("in add Category " + newCategory);
		try {
			Integer savedCategory = service.addCategory(newCategory);
			return new ResponseEntity<Integer>(savedCategory, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing category
	@PutMapping("/{categoryID}")
	public ResponseEntity<?> updateCategoryDetails(@PathVariable int categoryID, @RequestBody Category c) {
		System.out.println("in update " + categoryID + " " + c);
		try {
			Category updatedDetails = service.updateCategory(categoryID, c);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @DeleteMapping("/{categoryID}")
	 public String deleteCategory(@PathVariable int categoryID)
	 {
		 System.out.println("in delete Category "+categoryID);
		 return service.deleteCategory(categoryID);
		 
	 }

}
