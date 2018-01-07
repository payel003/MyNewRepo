package com.market.project.ws.order.dao;

import com.market.project.ws.order.entity.Order;

public interface OrderDao {
	
	public void create(Order order);
	
	public void update(int id,String status);
	
	public void delete(int id);
	
	public Order find(int id);

}
