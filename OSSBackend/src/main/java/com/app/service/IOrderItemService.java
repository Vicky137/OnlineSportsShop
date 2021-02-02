package com.app.service;

import java.util.List;

import com.app.dto.OrderItemDto;
import com.app.pojos.OrderItem;

public interface IOrderItemService {
	// list all OrderItem
	List<OrderItem> getAllOrderItems();
	
	// get OrderItem details by id
	OrderItemDto getOrderItemById(int id);

	// add new OrderItem details
	OrderItem addOrderItem(OrderItem transientPOJO);

	// update existing OrderItem details
	OrderItemDto updateOrderItem(int orderItemID, OrderItem detachedPOJO);
	
	String deleteOrderItem(int orderItemID);
	
}
