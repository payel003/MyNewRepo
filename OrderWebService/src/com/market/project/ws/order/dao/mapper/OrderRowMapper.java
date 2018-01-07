package com.market.project.ws.order.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.market.project.ws.order.entity.Order;

public class OrderRowMapper implements RowMapper {

	@Override
	public Order mapRow(ResultSet rs, int rownum) throws SQLException {
		Order order=new Order();	
		order.setId(rs.getInt(1));
		order.setOrderDetails(rs.getString(2));
		order.setBillingInfo(rs.getString(3));
		order.setPaymentInfo(rs.getString(4));
		order.setStatus(rs.getString(5));
		return order;
	}

}
