package com.zjj.IService;

import java.io.Serializable;
import java.util.List;

import com.zjj.entity.Goods;

public interface ICommonService <T extends Serializable> {
		List<T> findAll();
		
		Goods findByID(int id);
}
