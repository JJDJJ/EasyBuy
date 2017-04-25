package com.zjj.IDAO;

import java.util.List;

import com.zjj.entity.ShoppingCar;

/**
 * @author ZJJ-PC
 *
 */
public interface IShopCar {

	/**
	 * 根据ID判断购物车内是否有相同商品
	 * @param id
	 * @return
	 */
	public int CheckGoodsById(int goodsid,String uid);
	
	/**
	 * 获取购物车中商品数量
	 * @param goodsid
	 * @param uid
	 * @return
	 */
	public int GetShopCarGoodsNum(int goodsid,String uid);
	
	
	/**
	 * 根据用户检查购物车商品数量
	 * @param uid
	 * @return
	 */
	public int CheckGoodsRowsById(String uid);
	
	
	/**
	 * 根据用户名获取购物车中商品
	 * @param uid
	 * @return
	 */
	public List<ShoppingCar> GetGoodsByUser(String uid);
	
	
	/**
	 * 根据商品ID删除购物车
	 * @param goodsid
	 * @return
	 */
	public int DeleteGodosById(int goodsid,String uid);
	
	public double GetShopCarGoodsPrice(int goodsid,  String uid);
}
