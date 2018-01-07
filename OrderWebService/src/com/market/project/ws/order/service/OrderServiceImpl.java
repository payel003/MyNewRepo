package com.market.project.ws.order.service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.market.project.ws.order.dao.OrderDao;
import com.market.project.ws.order.dao.mapper.OrderRowMapper;
import com.market.project.ws.order.entity.Order;

public class OrderServiceImpl implements OrderService{

	
    private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void create(Order order) {
		orderDao.create(order);
	}

	@Override
	public void update(int id,String status) {
	
		orderDao.update(id, status);
	}

	@Override
	public void delete(int id) {
		
	   orderDao.delete(id);
	}

	@Override
	public Order find(int id) {
		
		return orderDao.find(id);
	}
	
	
	
}