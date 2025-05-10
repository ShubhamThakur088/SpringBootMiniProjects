package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public OrderRepository getOrderRepo() {
		return orderRepo;
	}

	public void setOrderRepo(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	public Order addOrder(Order order) {
		Order savedOrder = orderRepo.save(order);
		return savedOrder;
	}
	
	public Order getOrderById(Integer Id) {
		Optional<Order> optionalOrder =  orderRepo.findById(Id);
		return optionalOrder.orElse(null);
	}
	
	public String deleteOrderById(Integer Id) {
		orderRepo.deleteById(Id);
		return "Success!";
	}
	
	public Order updateOrderById(Order order) {
		Order orderFromDb = orderRepo.findById(order.getId()).orElse(null);
		
		if(orderFromDb == null) {
			throw new RuntimeException("No such order exist!");
		}
		else {
			orderFromDb.setCustomerName(order.getCustomerName());
			orderFromDb.setAmount(order.getAmount());
			
			return orderRepo.save(orderFromDb);
		}
	}

}
