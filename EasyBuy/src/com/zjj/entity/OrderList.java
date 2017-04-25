package com.zjj.entity;

/**
 * 订单列表实体类
 * @author ZJJ-PC
 *
 */
public class OrderList {
	private String username;
	private String order_id;
	private String orderstatus;
	private String paystatus;
	private String method;
	private String ordertime;
	private double orderprice;
	private String getusername;
	private String province;
	private String city;
	private String area;
	private String addressinfo;
	private String phone;
	private int goodsid;
	private String goodsname;
	private double goodsprice;
	private int goodsnum;
	private double goods_subtotal;
	private String goodsimg;
	private String goodsintrouce;
	private String zipcode;
	
	public OrderList() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public String getZipcode() {
		return zipcode;
	}





	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}





	public int getGoodsid() {
		return goodsid;
	}



	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}



	public String getGoodsimg() {
		return goodsimg;
	}



	public void setGoodsimg(String goodsimg) {
		this.goodsimg = goodsimg;
	}



	public String getGoodsintrouce() {
		return goodsintrouce;
	}



	public void setGoodsintrouce(String goodsintrouce) {
		this.goodsintrouce = goodsintrouce;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public String getGetusername() {
		return getusername;
	}
	public void setGetusername(String getusername) {
		this.getusername = getusername;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddressinfo() {
		return addressinfo;
	}
	public void setAddressinfo(String addressinfo) {
		this.addressinfo = addressinfo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	public double getGoods_subtotal() {
		return goods_subtotal;
	}
	public void setGoods_subtotal(double goods_subtotal) {
		this.goods_subtotal = goods_subtotal;
	}

	public OrderList(String username, String order_id, String orderstatus,
			String paystatus, String method, String ordertime,
			double orderprice, String getusername, String province,
			String city, String area, String addressinfo, String phone,
			int goodsid, String goodsname, double goodsprice, int goodsnum,
			double goods_subtotal, String goodsimg, String goodsintrouce,
			String zipcode) {
		super();
		this.username = username;
		this.order_id = order_id;
		this.orderstatus = orderstatus;
		this.paystatus = paystatus;
		this.method = method;
		this.ordertime = ordertime;
		this.orderprice = orderprice;
		this.getusername = getusername;
		this.province = province;
		this.city = city;
		this.area = area;
		this.addressinfo = addressinfo;
		this.phone = phone;
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
		this.goodsnum = goodsnum;
		this.goods_subtotal = goods_subtotal;
		this.goodsimg = goodsimg;
		this.goodsintrouce = goodsintrouce;
		this.zipcode = zipcode;
	}





	@Override
	public String toString() {
		return "OrderList [username=" + username + ", order_id=" + order_id
				+ ", orderstatus=" + orderstatus + ", paystatus=" + paystatus
				+ ", method=" + method + ", ordertime=" + ordertime
				+ ", orderprice=" + orderprice + ", getusername=" + getusername
				+ ", province=" + province + ", city=" + city + ", area="
				+ area + ", addressinfo=" + addressinfo + ", phone=" + phone
				+ ", goodsid=" + goodsid + ", goodsname=" + goodsname
				+ ", goodsprice=" + goodsprice + ", goodsnum=" + goodsnum
				+ ", goods_subtotal=" + goods_subtotal + ", goodsimg="
				+ goodsimg + ", goodsintrouce=" + goodsintrouce + ", zipcode="
				+ zipcode + "]";
	}

	
}
