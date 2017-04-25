package com.zjj.Serviceimpl;

import java.util.List;

import com.zjj.IDAO.DaoFactory;
import com.zjj.IService.ServiceFactory;
import com.zjj.entity.Goods;

@SuppressWarnings("unchecked")
public class GoodsServiceImpl extends CommonServiceImpl<Goods>{

	
	@Override
	public List<Goods> findAll() {
		return DaoFactory.getDao("Goods").GetList();
	}

	@Override
	public Goods findByID(int id) {
		return DaoFactory.getDao("Goods").findByID(id);
	}	
}
