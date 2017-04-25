package com.zjj.IService;

import java.util.List;

import com.zjj.entity.ShoppingCar;

public interface IShopCar {

	public int insert(ShoppingCar shoppingCar);
	
	public int CheckGoodsById(int goodsid,String uid);
	
	public int GetGoodsNum(int goodsid,String uid);
	
	public int update(ShoppingCar shoppingCar);
	
	public int GetGoodsNumberByUser(String uid);
	
	public List<ShoppingCar> GetGoodsByUser(String uid);
	
	public int DeleteGoodsByID(int goodsid,String uid);
	
	public double GetShopCarGoodsPrice(int goodsid,  String uid);
}
