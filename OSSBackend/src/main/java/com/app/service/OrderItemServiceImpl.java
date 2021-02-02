package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.OrderItemNotFoundException;
import com.app.dao.IOrderItemDao;
import com.app.dto.OrderItemDto;
import com.app.pojos.Order;
import com.app.pojos.OrderItem;

@Service
@Transactional
public class OrderItemServiceImpl implements IOrderItemService {
	// dependency
	@Autowired
	private IOrderItemDao dao;
	@Autowired
	private IOrderService odao;

	@Override
	public List<OrderItem> getAllOrderItems() {
		System.out.println("dao imple class " + dao.getClass().getName());
		return dao.findAll();
	}
	
	@Override
	public  OrderItemDto getOrderItemById(int id) {
		// TODO Auto-generated method stub
		return  dao.findById(id);
	}
	
	@Override
	public OrderItem addOrderItem(OrderItem oi) {
		//Order o = odao.getOrderById(oi.getOrder().getId());
		OrderItem orderItem = new OrderItem();
		orderItem.setItemDiscount(oi.getItemDiscount());
		orderItem.setQuantity(oi.getQuantity());
		orderItem.setUnitPrice(oi.getUnitPrice());
		
		//orderItem.setOrder(o);
		return dao.save(orderItem);
	}

	@Override
	public OrderItemDto updateOrderItem(int orderItemID, OrderItem o1) {
		// chk if OrderItem exists : findById
		OrderItemDto o = dao.findById(orderItemID);
		if (o!=null) {
			OrderItemDto orderItem = o;
			orderItem.setItemDiscount(o1.getItemDiscount());
			orderItem.setQuantity(o1.getQuantity());
			orderItem.setUnitPrice(o1.getUnitPrice());
			return orderItem;

		}
		//in case of no orderItem found : throw custom exception
		throw new OrderItemNotFoundException("Invalid orderItem ID");
	}

	@Override
	public String deleteOrderItem(int orderItemID) {
		dao.deleteById(orderItemID);
		return "OrderItem with ID " + orderItemID + " deleted";
	}
	
}
