package com.zjj.IDAO;

import java.util.List;

import com.zjj.entity.ShoppingCar;

/**
 * @author ZJJ-PC
 *
 */
public interface IShopCar {

	/**
	 * ����ID�жϹ��ﳵ���Ƿ�����ͬ��Ʒ
	 * @param id
	 * @return
	 */
	public int CheckGoodsById(int goodsid,String uid);
	
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * @param goodsid
	 * @param uid
	 * @return
	 */
	public int GetShopCarGoodsNum(int goodsid,String uid);
	
	
	/**
	 * �����û���鹺�ﳵ��Ʒ����
	 * @param uid
	 * @return
	 */
	public int CheckGoodsRowsById(String uid);
	
	
	/**
	 * �����û�����ȡ���ﳵ����Ʒ
	 * @param uid
	 * @return
	 */
	public List<ShoppingCar> GetGoodsByUser(String uid);
	
	
	/**
	 * ������ƷIDɾ�����ﳵ
	 * @param goodsid
	 * @return
	 */
	public int DeleteGodosById(int goodsid,String uid);
	
	public double GetShopCarGoodsPrice(int goodsid,  String uid);
}
