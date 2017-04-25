package com.zjj.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Goods implements Serializable {

	private static final long serialVersionUID = 2014583385308660248L;
	
	private int goodsid;
	private String goodsname;

	/**
	 * 商品单价
	 */
	private double goodsprice;
	private int goods_stock;
	private Date uptime;
	private int goodssort;
	private String goodsintroduce;
	private String goodsimg;
	
	private List<Goods> goods = new ArrayList<Goods>();
	
	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}



	public double getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}

	public int getGoods_stock() {
		return goods_stock;
	}

	public void setGoods_stock(int goods_stock) {
		this.goods_stock = goods_stock;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public int getGoodssort() {
		return goodssort;
	}

	public void setGoodssort(int goodssort) {
		this.goodssort = goodssort;
	}

	public String getGoodsintroduce() {
		return goodsintroduce;
	}

	public void setGoodsintroduce(String goodsintroduce) {
		this.goodsintroduce = goodsintroduce;
	}

	public String getGoodsimg() {
		return goodsimg;
	}

	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}

	public Goods(int goodsid, String goodsname, double goodsprice,
			int goodsstock, Date uptime, int goodssort, String goodsintroduce,
			String goodsimg, List<Goods> goods) {
		super();
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
		this.goods_stock = goodsstock;
		this.uptime = uptime;
		this.goodssort = goodssort;
		this.goodsintroduce = goodsintroduce;
		this.goodsimg = goodsimg;
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", goodsname=" + goodsname
				+ ", goodsprice=" + goodsprice + ", goodsstock=" + goods_stock
				+ ", uptime=" + uptime + ", goodssort=" + goodssort
				+ ", goodsintroduce=" + goodsintroduce + ", goodsimg="
				+ goodsimg + ", goods=" + goods + "]";
	}

}
