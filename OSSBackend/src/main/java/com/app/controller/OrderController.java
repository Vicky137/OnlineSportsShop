package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.OrderDto;
import com.app.pojos.Order;
import com.app.service.IOrderService;

@RestController // => @Controller at class level + @ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
	// dependency
	@Autowired
	private IOrderService service;

	public OrderController() {
		System.out.println("in ctor of " + getClass().getName());
	}


	// RESTful end point or API end point or API provider
	//for retrieve the details of one manager
	@GetMapping
	public ResponseEntity<?> listAllOrders() {
		System.out.println("in list all orders");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		// repo's impl class(SC)
		List<OrderDto> order = service.getAllOrders();
		if (order.isEmpty())
			// empty  list : set sts code : HTTP 204 (no contents)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// in case of non empty list : OK, send the list
		return  ResponseEntity.ok(order);
	}

	//req handling method to create a new order : post
	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody Order o) {
		System.out.println("in add Order " + o);
		try {
			Order savedOrder = service.addOrder(o);
			return new ResponseEntity<>(savedOrder, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// req handling method to update existing order
	@PutMapping("/{orderID}")
	public ResponseEntity<?> updateOrderDetails(@PathVariable int orderID, @RequestBody Order o) {
		System.out.println("in update " + orderID + " " + o);
		try {
			ResponseEntity<Order> updatedDetails = service.updateOrder(orderID, o);
			return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @DeleteMapping("/{orderID}")
	 public String deleteOrder(@PathVariable int orderID)
	 {
		 System.out.println("in delete order "+orderID);
		 return service.deleteOrder(orderID);
		 
	 }

}
