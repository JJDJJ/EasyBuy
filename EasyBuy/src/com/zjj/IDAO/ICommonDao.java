package com.zjj.IDAO;

import java.io.Serializable;
import java.util.List;

import com.zjj.entity.Goods;

/**
 * ���ýӿ�
 * @author ZJJ-PC
 *
 */
public interface ICommonDao<T extends Serializable> {
		
		/**
		 * ����һ���������һ����¼
		 * @param obj
		 * @return
		 */
		public int insert(T obj);
		
		public int update(T obj);
		
		int delete(int id);
		
		int deleet(T obj);
		
		/**
		 * ����һ�������ѯ����һ����¼
		 * @param obj
		 * @return
		 */
		public T query(T obj);
		
		public Goods findByID(int id);
		
		/**
		 * ����name��ѯ����һ������
		 * @param name
		 * @return
		 */
		public T queryByName(String name);
		
		List<T> findAll();
		List<T> findByIntstance(T obj);
		List<T> find(int start,int count,String order);
		
		/**
		 * ��ѯ����
		 * @return
		 */
		public List<T> GetList(); 
		
		
}
