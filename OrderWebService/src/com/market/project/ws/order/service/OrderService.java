package com.market.project.ws.order.service;

import com.market.project.ws.order.entity.Order;

public interface OrderService {
	
	public void create(Order order);
	
	public void update(int id,String status);
	
	public void delete(int id);
	
	public Order find(int id);

}
