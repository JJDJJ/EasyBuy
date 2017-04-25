package com.zjj.entity;

public class Address {
	private int id;
	private String account_id;
	private String get_username;
	private String zipcode;
	private String province;
	private String city;
	private String area;
	private String address_info;
	private String phone;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Address(String account_id, String get_username, String province,
			String city, String area, String address_info) {
		super();
		this.account_id = account_id;
		this.get_username = get_username;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address_info = address_info;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAccount_id() {
		return account_id;
	}



	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}



	public String getGet_username() {
		return get_username;
	}



	public void setGet_username(String get_username) {
		this.get_username = get_username;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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



	public String getAddress_info() {
		return address_info;
	}



	public void setAddress_info(String address_info) {
		this.address_info = address_info;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Address(int id, String account_id, String get_username,
			String zipcode, String province, String city, String area,
			String address_info, String phone) {
		super();
		this.id = id;
		this.account_id = account_id;
		this.get_username = get_username;
		this.zipcode = zipcode;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address_info = address_info;
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", account_id=" + account_id
				+ ", get_username=" + get_username + ", zipcode=" + zipcode
				+ ", province=" + province + ", city=" + city + ", area="
				+ area + ", address_info=" + address_info + ", phone=" + phone
				+ "]";
	} 
	
	
	
}
