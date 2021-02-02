package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.dto.OrderDto;
import com.app.pojos.Customer;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	// dependency
	@Autowired
	private IOrderDao dao;
	@Autowired
	private ICustomerService cdao;
	
	private OrderDto mapToDto(Order order) {
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(order, orderDto);
		orderDto.setCustomerId(order.getCustomer().getId());
		return orderDto;
	}
	
	@Override
	public List<OrderDto> getAllOrders() {
		System.out.println("dao imple class " + dao.getClass().getName());
		List<Order> orderEntities = dao.findAll();
		List<OrderDto> orders = orderEntities.stream().map(ord -> mapToDto(ord)).collect(Collectors.toList());
		return orders;
	}

	@Override
	public Order getOrderById(int id) {
		Optional<Order> optionalOrder = dao.findById(id);
		if(optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		return null;
	}
	
	@Override
	public Order findByCustomerId(int custId) {
		return dao.findByCustomer(custId);
	}
	
	@Override
	public Order addOrder(Order o) {
		//Customer c = cdao.getCustomerById(o.getCustomer().getId());
		Order order = new Order();
		order.setDiscount(o.getDiscount());
		order.setGrandTotal(o.getGrandTotal());
		order.setOrderDate(o.getOrderDate());
		order.setOrderStatus(o.getOrderStatus());
		order.setSubTotal(o.getSubTotal());
		//order.setCustomer(c);
		return dao.save(order);
	}

	@Override
	public ResponseEntity<Order> updateOrder(int orderID, Order c1) {
		// chk if Order exists : findById
		Optional<Order> c = dao.findById(orderID);
		if (c.isPresent()) {
			Order order = c.get();
			order.setDiscount(c1.getDiscount());
			order.setGrandTotal(c1.getGrandTotal());
			order.setOrderDate(c1.getOrderDate());
			order.setOrderStatus(c1.getOrderStatus());
			order.setSubTotal(c1.getSubTotal());
			return new ResponseEntity<>(order, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public String deleteOrder(int orderID) {
		dao.deleteById(orderID);
		return "Order with ID " + orderID + " deleted";
	}
	
}
