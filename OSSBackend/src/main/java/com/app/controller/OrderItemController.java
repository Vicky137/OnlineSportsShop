package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.OrderItemDto;
import com.app.pojos.OrderItem;
import com.app.service.IOrderItemService;

@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/orderitem")
@CrossOrigin
public class OrderItemController {
	// dependency
	@Autowired
	private IOrderItemService service;

	public OrderItemController() {
		System.out.println("in ctor of " + getClass().getName());
	}


	// RESTful end point or API end point or API provider
	//for retrieve the details of one manager
	@GetMapping
	public ResponseEntity<?> listAllOrderItems() {
		System.out.println("in list all orderItems");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<OrderItem> orderItem = service.getAllOrderItems();
		if (orderItem.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(orderItem);
	}

	
	  // get orderItem details by its id : supplied by clnt using path var
	  
	  @GetMapping("/{orderItemId}") 
	  public ResponseEntity<?> getOrderItemDetails(@PathVariable int orderItemId) {
		  System.out.println("in get OrderItem details " + orderItemId); 
		  // invoke service method 
		  OrderItemDto orderItemDetails = service.getOrderItemById(orderItemId); 
		  //valid name : HTTP 200 , marshalled orderItem details 
		  if (orderItemDetails!=null)
			  return new ResponseEntity<>(orderItemDetails, HttpStatus.OK); 
		  // in case of invalid name : HTTP 404
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 

	//req handling method to create a new orderItem : post
	@PostMapping
	public ResponseEntity<?> addOrderItem(@RequestBody OrderItem o) {
		System.out.println("in add OrderItem " + o);
		try {
			OrderItem savedOrderItem = service.addOrderItem(o);
			return new ResponseEntity<>(savedOrderItem, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing orderItem
	@PutMapping("/{orderItemID}")
	public ResponseEntity<?> updateOrderDetails(@PathVariable int orderItemID, @RequestBody OrderItem o) {
		System.out.println("in update " + orderItemID + " " + o);
		try {
			OrderItemDto updatedDetails = service.updateOrderItem(orderItemID, o);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @DeleteMapping("/{orderItemID}")
	 public String deleteOrderItem(@PathVariable int orderItemID)
	 {
		 System.out.println("in delete orderItem "+orderItemID);
		 return service.deleteOrderItem(orderItemID);
		 
	 }

}
