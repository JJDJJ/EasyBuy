package com.zjj.entity;

/**
 * 订单详情实体类
 * @author ZJJ-PC
 *
 */
public class OrdersInfo {

	private int id;
	private String order_id;
	private String username;
	private String orderstatus;
	private String paystatus;
	private String method;
	private String ordertime;
	private int addressid;
	private double orderprice;
	
	public OrdersInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	
	public OrdersInfo(int id, String order_id, String username,
			String orderstatus, String paystatus, String method,
			String ordertime, int addressid, double orderprice) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.username = username;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.method = method;
		this.ordertime = ordertime;
		this.addressid = addressid;
		this.orderprice = orderprice;
	}
	
	
	@Override
	public String toString() {
		return "OrdersInfo [id=" + id + ", order_id=" + order_id
				+ ", username=" + username + ", orderstatus=" + orderstatus
				+ ", paystatus=" + paystatus + ", method=" + method
				+ ", ordertime=" + ordertime + ", addressid=" + addressid
				+ ", orderprice=" + orderprice + "]";
	}
	
	
}
