package com.zjj.IDAO;

import java.io.Serializable;
import java.util.List;

import com.zjj.entity.Goods;

/**
 * 常用接口实现类
 * @author ZJJ-PC
 *
 * @param <T>
 */
public class GenericCommon<T extends Serializable> implements ICommonDao<T> {

	@Override
	public int insert(T obj) {
		
		return 0;
	}

	@Override
	public T query(T obj) {
		
		return null;
	}

	@Override
	public T queryByName(String name) {
		
		return null;
	}

	@Override
	public int update(T obj) {
	
		return 0;
	}

	@Override
	public int delete(int id) {
		
		return 0;
	}

	@Override
	public int deleet(T obj) {
		
		return 0;
	}

	@Override
	public Goods findByID(int id) {
		
		return null;
	}

	@Override
	public List<T> findAll() {
	
		return null;
	}

	@Override
	public List<T> findByIntstance(T obj) {
		
		return null;
	}

	@Override
	public List<T> find(int start, int count, String order) {
	
		return null;
	}

	@Override
	public List<T> GetList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
