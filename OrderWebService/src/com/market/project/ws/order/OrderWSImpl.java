package com.market.project.ws.order;

import javax.ws.rs.core.Response;

import com.market.project.ws.order.dao.OrderDao;
import com.market.project.ws.order.dto.Order;
import com.market.project.ws.order.service.OrderService;

public class OrderWSImpl implements OrderWS {

//	private OrderDao orderDao;
//	public OrderDao getOrderDao() {
//		return orderDao;
//	}
//
//	public void setOrderDao(OrderDao orderDao) {
//		this.orderDao = orderDao;
//	}
	
	
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Response add(Order order) {
		
		com.market.project.ws.order.entity.Order orderEntity = mapWSToDao(order);
		orderService.create(orderEntity);
		return Response.ok().build();
	}

	private com.market.project.ws.order.entity.Order mapWSToDao(Order order) {
		com.market.project.ws.order.entity.Order orderEntity=new com.market.project.ws.order.entity.Order();
		orderEntity.setId(order.getId());
		orderEntity.setOrderDetails(order.getOrderDetails());
		orderEntity.setBillingInfo(order.getBillingInfo());
		orderEntity.setPaymentInfo(order.getPaymentInfo());
		orderEntity.setStatus(order.getStatus());
		return orderEntity;
	}

	@Override
	public Response update(Order order) {
		
		orderService.update(order.getId(), order.getStatus());
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		orderService.delete(id);
		return Response.ok().build();
	}

	@Override
	public Order find(int id) {
		com.market.project.ws.order.entity.Order orderEntity=orderService.find(id);
		Order order = mapDaoToWS(orderEntity);
		return order;
	}

	private Order mapDaoToWS(com.market.project.ws.order.entity.Order orderEntity) {
		Order order=new Order();
		order.setId(orderEntity.getId());
		order.setBillingInfo(orderEntity.getBillingInfo());
		order.setOrderDetails(orderEntity.getOrderDetails());
		order.setPaymentInfo(orderEntity.getPaymentInfo());
		order.setStatus(orderEntity.getStatus());
		return order;
	}

}
