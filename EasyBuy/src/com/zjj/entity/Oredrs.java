package com.zjj.entity;

/**
 * 订单实体类
 * @author ZJJ-PC
 *
 */
public class Oredrs {
	private int id;
	private int goods_id;
	private int goods_num;
	private String order_id;
	public int getId() {
		return id;
	}
	
	
	public Oredrs() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Oredrs(int id, int goods_id, int goods_num, String order_id) {
		super();
		this.id = id;
		this.goods_id = goods_id;
		this.goods_num = goods_num;
		this.order_id = order_id;
	}
	
	
	@Override
	public String toString() {
		return "Oredrs [id=" + id + ", goods_id=" + goods_id + ", goods_num="
				+ goods_num + ", order_id=" + order_id + "]";
	}
	
	
}
