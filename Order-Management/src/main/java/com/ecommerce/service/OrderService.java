package com.ecommerce.service;

import com.ecommerce.model.Order;

public interface OrderService {
	
	public Order addOrder(Order order);
	public Order getOrderById(Integer Id);
	public Order updateOrderById(Order order);
	public String deleteOrderById(Integer Id);
}
