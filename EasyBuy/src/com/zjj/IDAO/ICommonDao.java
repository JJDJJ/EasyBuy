package com.zjj.IDAO;

import java.io.Serializable;
import java.util.List;

import com.zjj.entity.Goods;

/**
 * 常用接口
 * @author ZJJ-PC
 *
 */
public interface ICommonDao<T extends Serializable> {
		
		/**
		 * 根据一个对象添加一条记录
		 * @param obj
		 * @return
		 */
		public int insert(T obj);
		
		public int update(T obj);
		
		int delete(int id);
		
		int deleet(T obj);
		
		/**
		 * 根据一个对象查询返回一条记录
		 * @param obj
		 * @return
		 */
		public T query(T obj);
		
		public Goods findByID(int id);
		
		/**
		 * 根据name查询返回一个对象
		 * @param name
		 * @return
		 */
		public T queryByName(String name);
		
		List<T> findAll();
		List<T> findByIntstance(T obj);
		List<T> find(int start,int count,String order);
		
		/**
		 * 查询所有
		 * @return
		 */
		public List<T> GetList(); 
		
		
}
