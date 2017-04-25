package com.zjj.entity;

import java.io.Serializable;

public class ShoppingCar implements Serializable{
	
	private static final long serialVersionUID = 2640702124929293227L;
	private int id;
	private String goodsname;
	private String shopuser;
	private int goods_id;
	private int goods_num;	
	private String goods_img;
	private String goods_introduce;
	/**
	 * 商品单价
	 */
	private double goods_money;
	/**
	 * 小计
	 */
	private double goods_subtotal;
	private int stock;
	
	public int getId() {
		return id;
	}
	

	public ShoppingCar(String shopuser, int goods_id, int goods_num) {	
		super();
		this.shopuser = shopuser;
		this.goods_id = goods_id;
		this.goods_num = goods_num;
		
	}

	public ShoppingCar(String shopuser, int goods_id, int goods_num,
			double goods_subtotal) {
		super();
		this.shopuser = shopuser;
		this.goods_id = goods_id;
		this.goods_num = goods_num;
		this.goods_subtotal = goods_subtotal;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getGoodsname() {
		return goodsname;
	}


	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getShopuser() {
		return shopuser;
	}
	public void setShopuser(String shopuser) {
		this.shopuser = shopuser;
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
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	public String getGoods_introduce() {
		return goods_introduce;
	}
	public void setGoods_introduce(String goods_introduce) {
		this.goods_introduce = goods_introduce;
	}
	public double getGoods_money() {
		return goods_money;
	}
	public void setGoods_money(double goods_money) {
		this.goods_money = goods_money;
	}

	public double getGoods_subtotal() {
		return goods_subtotal;
	}


	public void setGoods_subtotal(double goods_subtotal) {
		this.goods_subtotal = goods_subtotal;
	}


	public ShoppingCar() {
		// TODO Auto-generated constructor stub
	}


	public ShoppingCar(int id, String goodsname, String shopuser, int goods_id,
			int goods_num, String goods_img, String goods_introduce,
			double goods_money, double goods_subtotal, int stock) {
		super();
		this.id = id;
		this.goodsname = goodsname;
		this.shopuser = shopuser;
		this.goods_id = goods_id;
		this.goods_num = goods_num;
		this.goods_img = goods_img;
		this.goods_introduce = goods_introduce;
		this.goods_money = goods_money;
		this.goods_subtotal = goods_subtotal;
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "ShoppingCar [id=" + id + ", goodsname=" + goodsname
				+ ", shopuser=" + shopuser + ", goods_id=" + goods_id
				+ ", goods_num=" + goods_num + ", goods_img=" + goods_img
				+ ", goods_introduce=" + goods_introduce + ", goods_money="
				+ goods_money + ", goods_subtotal=" + goods_subtotal
				+ ", stock=" + stock + "]";
	}

}
