package com.zjj.IDAO;

import java.util.List;

import com.zjj.entity.Address;

public interface IAddress {

	
	/**
	 * 根据用户名查处所有地址
	 * @param uid
	 * @return
	 */
	public List<Address> GetAllAddress(String uid);
	
	
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	public int insertAddress(Address address);
	
	/**
	 * 根据ID获取地址
	 * @param id
	 * @return
	 */
	public Address GetAddressByID(int id);
	
	public Address GetAddressByUser_ID(String uid,int id);
}
