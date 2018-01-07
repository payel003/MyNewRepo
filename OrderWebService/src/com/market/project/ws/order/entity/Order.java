package com.market.project.ws.order.entity;

public class Order {
	
	private int id;
	private String orderDetails;
	private String billingInfo;
	private String paymentInfo;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getBillingInfo() {
		return billingInfo;
	}
	public void setBillingInfo(String billingInfo) {
		this.billingInfo = billingInfo;
	}
	public String getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
