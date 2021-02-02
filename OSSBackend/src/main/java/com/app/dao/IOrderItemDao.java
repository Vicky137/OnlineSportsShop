package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.OrderItemDto;
import com.app.pojos.OrderItem;

public interface IOrderItemDao extends JpaRepository<OrderItem, Integer>{
	
	OrderItemDto findById(int id);
}