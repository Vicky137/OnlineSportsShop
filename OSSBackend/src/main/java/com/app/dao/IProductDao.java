package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.Vendor;

public interface IProductDao extends JpaRepository<Product, Integer>{

	//search by Customer name
	Optional<Product> findByName(String pName);
	
	Product findById(int id);
	
	@Query(value = "SELECT * FROM PRODUCTS p WHERE p.category_id =:id", nativeQuery = true)
	List<Product> findByCategory(@Param("id") Category id);

	@Query(value = "SELECT * FROM PRODUCTS p WHERE p.vendor_id =:id", nativeQuery = true)
	List<Product> findByVendor(@Param("id") Vendor id);
	
	@Query(value = "SELECT * FROM PRODUCTS p INNER JOIN oss.categories as c WHERE c.category_name= :name and p.category_id=c.category_id;", nativeQuery = true)
	List<Product> findByCategoryName(@Param("name") String categoryName);
	
	@Query(value ="SELECT * FROM PRODUCTS p INNER JOIN oss.vendors as c WHERE c.vendor_name= :name and p.vendor_id=c.vendor_id;", nativeQuery = true) 
	List<Product> findByVendorName(@Param("name") String vendorName);
	
	@Query(value ="SELECT * FROM PRODUCTS p INNER JOIN oss.vendors as c WHERE c.email= :email and p.vendor_id=c.vendor_id;", nativeQuery = true) 
	List<Product> findByVendorEmail(@Param("email") String vendorEmail);
	 
	
}