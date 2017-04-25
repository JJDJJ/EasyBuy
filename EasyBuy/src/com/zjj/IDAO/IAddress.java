package com.zjj.IDAO;

import java.util.List;

import com.zjj.entity.Address;

public interface IAddress {

	
	/**
	 * �����û����鴦���е�ַ
	 * @param uid
	 * @return
	 */
	public List<Address> GetAllAddress(String uid);
	
	
	/**
	 * ��ӵ�ַ
	 * @param address
	 * @return
	 */
	public int insertAddress(Address address);
	
	/**
	 * ����ID��ȡ��ַ
	 * @param id
	 * @return
	 */
	public Address GetAddressByID(int id);
	
	public Address GetAddressByUser_ID(String uid,int id);
}
