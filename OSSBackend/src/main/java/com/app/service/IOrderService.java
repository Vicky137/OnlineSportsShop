package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.dto.OrderDto;
import com.app.pojos.Order;

public interface IOrderService {
	
	List<OrderDto> getAllOrders();
	
	Order findByCustomerId(int custId);

	Order addOrder(Order transientPOJO);

	public ResponseEntity<Order> updateOrder(int orderID, Order detachedPOJO);
	
	String deleteOrder(int orderID);

	Order getOrderById(int id);
	
}
