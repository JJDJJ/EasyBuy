package com.zjj.Serviceimpl;

import java.util.List;

import com.zjj.DAOimpl.AddressImpl;
import com.zjj.IService.IAddress;
import com.zjj.entity.Address;

public class AddressServiceImpl implements IAddress {

	@Override
	public List<Address> GetAllAddress(String uid) {
		AddressImpl aImpl = new AddressImpl();
		return aImpl.GetAllAddress(uid);
	}

	@Override
	public int insertAddress(Address address) {
		AddressImpl aImpl = new AddressImpl();
		return aImpl.insertAddress(address);
	}

	@Override
	public Address GetAddressByID(int id) {
		AddressImpl aImpl =new AddressImpl();
		return aImpl.GetAddressByID(id) ;
	}

	@Override
	public Address GetAddressByUser_ID(String uid, int id) {
		AddressImpl aImpl =new AddressImpl();
		return aImpl.GetAddressByUser_ID(uid, id);
	}
	
	

}
