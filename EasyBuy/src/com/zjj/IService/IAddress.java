package com.zjj.IService;

import java.util.List;

import com.zjj.entity.Address;

public interface IAddress {

	public List<Address> GetAllAddress(String uid);
	
	public int insertAddress(Address address);
	
	public Address GetAddressByID(int id);
	
	public Address GetAddressByUser_ID(String uid,int id);
}
