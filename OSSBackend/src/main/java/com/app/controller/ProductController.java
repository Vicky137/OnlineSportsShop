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

import com.app.dao.IProductDao;
import com.app.dto.ProductDto;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.Vendor;
import com.app.service.IProductService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/product")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	// dependency
	@Autowired
	private IProductService service;
	
	@Autowired
	private IProductDao dao;

	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	// for retrieve the details of one manager
	@GetMapping
	public ResponseEntity<?> listAllProducts() {
		System.out.println("in list all Products");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<ProductDto> products = service.getAllProducts();
		if (org.springframework.util.CollectionUtils.isEmpty(products)) {
			// empty list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		// in case of non empty list : OK, send the list
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<?> getProductsByCategoryId(@PathVariable (value = "categoryId") Category categoryId)
	{
		List<Product> products = dao.findByCategory(categoryId);
		if (org.springframework.util.CollectionUtils.isEmpty(products)) {
				// empty list : set sts code : HTTP 204 (no contents)
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			// in case of non empty list : OK, send the list
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/category/name/{categoryName}")
	public ResponseEntity<?> getProductsByCategoryName(@PathVariable (value = "categoryName") String categoryName)
	{
		List<Product> products = dao.findByCategoryName(categoryName);
		if (org.springframework.util.CollectionUtils.isEmpty(products)) {
				// empty list : set sts code : HTTP 204 (no contents)
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			// in case of non empty list : OK, send the list
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/vendor/{vendorId}")
	public ResponseEntity<?> getProductsByVendorId(@PathVariable (value = "vendorId") Vendor vendorId)
	{
		//List<Product> products = dao.findByVendorId(vendorId);
				// covert list of entities into list of dto's
				// return list
		List<Product> products = dao.findByVendor(vendorId);
		if (org.springframework.util.CollectionUtils.isEmpty(products)) {
				// empty list : set sts code : HTTP 204 (no contents)
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			// in case of non empty list : OK, send the list
		return ResponseEntity.ok(products);
	}
	
	
	 @GetMapping("/vendor/name/{vendorName}") 
	 public ResponseEntity<?> getProductsByVendorName(@PathVariable (value = "vendorName") String vendorName) { 
		 List<Product> products = dao.findByVendorName(vendorName); 
		 if(org.springframework.util.CollectionUtils.isEmpty(products)) { 
			 // empty list : set sts code : HTTP 204 (no contents) 
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 } // in case of non empty list : OK, send the list 
		 return ResponseEntity.ok(products);
	}
	 
	 @GetMapping("/vendor/email/{vendorEmail}") 
	 public ResponseEntity<?> getProductsByVendorEmail(@PathVariable (value = "vendorEmail") String vendorEmail) { 
		 List<Product> products = dao.findByVendorEmail(vendorEmail); 
		 if(org.springframework.util.CollectionUtils.isEmpty(products)) { 
			 // empty list : set sts code : HTTP 204 (no contents) 
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		 } // in case of non empty list : OK, send the list 
		 return ResponseEntity.ok(products);
	}

	// get product details by its id : supplied by clnt using path var
	@GetMapping("/{productId}")
	public ResponseEntity<?> getProductDetailsById(@PathVariable int productId) {
		System.out.println("in get product details " + productId);
		// invoke service method
		ProductDto productDetails = service.getProductById(productId);
		// valid name : HTTP 200 , marshalled product details
		if (productDetails != null)
			return new ResponseEntity<>(productDetails, HttpStatus.OK);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/name/{productName}")
	public ResponseEntity<?> getProductDetailsByName(@PathVariable String productName) {
		System.out.println("in get product details " + productName);
		// invoke service method
		Product productDetails = service.getProductByName(productName);
		// valid name : HTTP 200 , marshalled product details
		if (productDetails != null)
			return new ResponseEntity<>(productDetails, HttpStatus.OK);
		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// req handling method to create a new product : post
	@PostMapping()
	public ResponseEntity<Integer> addProductDetails(@RequestBody ProductDto newProduct) {		
		System.out.println("in add Product " + newProduct.toString());
		try {
			Integer productId = service.addProduct(newProduct);
			return new ResponseEntity<Integer>(productId, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing product
	@PutMapping("/{productID}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<?> updateProductDetails(@PathVariable int productID, @RequestBody Product existingProduct) {
		System.out.println("in update " + productID + " " + existingProduct);
		try {
			Product updatedDetails = service.updateProduct(productID, existingProduct);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{productID}")
	public String deleteProductByid(@PathVariable int productID) {
		System.out.println("in delete product " + productID);
		return service.deleteProduct(productID);

	}

}
