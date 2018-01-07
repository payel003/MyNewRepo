package com.market.project.ws.order.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.market.project.ws.order.dao.mapper.OrderRowMapper;
import com.market.project.ws.order.entity.Order;

public class OrderDaoImpl implements OrderDao{

	
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(Order order) {
		
		jdbcTemplate.update("insert into orderdb.order value(" + order.getId() + ",'" + order.getOrderDetails() + "','"
				+ order.getBillingInfo() + "','" + order.getPaymentInfo() + "','" + order.getStatus() + "')");
	}

	@Override
	public void update(int id,String status) {
		
		jdbcTemplate.update("update orderdb.order set status='"+status+"' where id="+id);
	}

	@Override
	public void delete(int id) {
		
		jdbcTemplate.update("delete from orderdb.order where id="+id);
	}

	@Override
	public Order find(int id) {
		
		Order order=(Order)jdbcTemplate.queryForObject("select * from orderdb.order where id="+id, new OrderRowMapper());
		return order;
	}
	
	
	
}