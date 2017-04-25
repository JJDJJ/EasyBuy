package com.zjj.Serviceimpl;

import java.io.Serializable;
import java.util.List;

import com.zjj.IService.ICommonService;
import com.zjj.entity.Goods;

public abstract class CommonServiceImpl<T extends Serializable>implements ICommonService<T> {

	@Override
	public List<T> findAll() {
		
		return null;
	}

	@Override
	public Goods findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}	

}
