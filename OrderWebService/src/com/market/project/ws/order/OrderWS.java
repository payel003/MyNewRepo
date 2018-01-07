package com.market.project.ws.order;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.market.project.ws.order.dto.Order;

@Produces({ "application/xml", "application/json" })
public interface OrderWS {
	
	@POST
	@Path("/orders")
	Response add(Order order);
	
	@PUT
	@Path("/orders")
	Response update(Order order);
	
	
	@DELETE
	@Path("/orders/{id}")
	Response delete(@PathParam ("id")int id);
	
	
	@GET
	@Path("/orders/{id}")
	Order find(@PathParam ("id")int id);
	

}
