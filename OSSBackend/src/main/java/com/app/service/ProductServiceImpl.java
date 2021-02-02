package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.ProductNotFoundException;
import com.app.dao.ICategoryDao;
import com.app.dao.IOrderItemDao;
import com.app.dao.IProductDao;
import com.app.dao.IVendorDao;
import com.app.dto.ProductDto;
import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.pojos.Vendor;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	// dependency
	@Autowired
	private IProductDao dao;
	
	//@Autowired
	//private IOrderItemDao orderItemDao;
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private IVendorDao vendorDao;
	
	private ProductDto mapToDto(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		productDto.setCategoryId(product.getCategory().getId());
		productDto.setCategoryName(product.getCategory().getName());
		productDto.setBrand(product.getCategory().getBrand());
		productDto.setVendorName(product.getVendor().getName());
		productDto.setVendorEmail(product.getVendor().getEmail());
		//productDto.setOrderItemId(product.getOrderItem().getId());
		productDto.setVendorId(product.getVendor().getId());
		return productDto;
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		System.out.println("dao imple class " + dao.getClass().getName());
		List<Product> productEntities = dao.findAll();
		List<ProductDto> prods = productEntities.stream().map(prod -> mapToDto(prod)).collect(Collectors.toList());
		return prods;
	}

	@Override
	public ProductDto getProductById(int id) {
		Product optionalProduct = dao.findById(id);
		ProductDto prod = mapToDto(optionalProduct);
			return prod;

	}

	@Override
	public Product getProductByName(String pName) {
		Optional<Product> optionalProduct = dao.findByName(pName);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	
	
	@Override
	public List<ProductDto> getAllProductsByVendorEmail(String email) {
		List<Product> productEntities = dao.findByVendorEmail(email);
		List<ProductDto> prods = productEntities.stream().map(prod -> mapToDto(prod)).collect(Collectors.toList());
		return prods;
	}

	@Override
	public Integer addProduct(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		//OrderItem orderItem = orderItemDao.findById(productDto.getOrderItemId()).get();
		//product.setOrderItem(orderItem);
		Vendor vendor = vendorDao.findById(productDto.getVendorId()).get();
		product.setVendor(vendor);
		Category category = categoryDao.findById(productDto.getCategoryId()).get();
		product.setCategory(category);
		Product savedProduct = dao.save(product);
		return savedProduct.getId();
	}

	@Override
	public Product updateProduct(int productID, Product existingProduct) {
		Product updatedProduct = dao.findById(productID);
		if (updatedProduct != null) {
			updatedProduct.setUnitPrice(existingProduct.getUnitPrice());
			updatedProduct.setQuantity(existingProduct.getQuantity());
			return dao.save(updatedProduct);
		}
		throw new ProductNotFoundException("Invalid Product ID");
	}

	@Override
	public String deleteProduct(int productID) {
		dao.deleteById(productID);
		return "Product with ID " + productID + " deleted";
	}

}












