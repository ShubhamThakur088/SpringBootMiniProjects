package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderServiceImpl;

@RestController
@RequestMapping(path = "orders")
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@PostMapping("order")
	public @ResponseBody Order addOrder(@RequestBody Order order) {
		return orderServiceImpl.addOrder(order);
	}
	
	@GetMapping("getOrder/{id}")
	public @ResponseBody Order getOrder(@PathVariable Integer id) {
		return orderServiceImpl.getOrderById(id);
	}
	
	@PutMapping("updateExistingOrder")
	public @ResponseBody Order updateOrder(@RequestBody Order order) {
		return orderServiceImpl.updateOrderById(order);
	}
	
	@DeleteMapping("deleteRecordById/{Id}")
	public @ResponseBody String deleteOrder(@PathVariable Integer Id) {
		return orderServiceImpl.deleteOrderById(Id);
		
	}

	public OrderServiceImpl getOrderServiceImpl() {
		return orderServiceImpl;
	}

	public void setOrderServiceImpl(OrderServiceImpl orderServiceImpl) {
		this.orderServiceImpl = orderServiceImpl;
	}	
}
