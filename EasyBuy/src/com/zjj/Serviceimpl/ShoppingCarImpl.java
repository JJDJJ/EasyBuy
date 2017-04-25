package com.zjj.Serviceimpl;

import java.util.List;

import com.zjj.DAOimpl.ShopCarDaoImpl;
import com.zjj.IService.IShopCar;
import com.zjj.entity.ShoppingCar;

/**
 * @author ZJJ-PC
 *
 */
public class ShoppingCarImpl implements IShopCar {

	@Override
	public int insert(ShoppingCar shoppingCar) {
		ShopCarDaoImpl shoImpl = new ShopCarDaoImpl();
		return shoImpl.insert(shoppingCar);
	}

	@Override
	public int CheckGoodsById(int goodsid, String uid) {
		ShopCarDaoImpl shoImpl = new ShopCarDaoImpl();
		return shoImpl.CheckGoodsById(goodsid, uid);
	}

	@Override
	public int GetGoodsNum(int goodsid, String uid) {
		ShopCarDaoImpl shoImpl = new ShopCarDaoImpl();
		return shoImpl.GetShopCarGoodsNum(goodsid, uid);
	}

	@Override
	public int update(ShoppingCar shoppingCar) {
		ShopCarDaoImpl shoImpl = new ShopCarDaoImpl();
		return shoImpl.update(shoppingCar);
	}

	@Override
	public int GetGoodsNumberByUser(String uid) {
		ShopCarDaoImpl shoImpl = new ShopCarDaoImpl();
		return shoImpl.CheckGoodsRowsById(uid);
	}

	@Override
	public List<ShoppingCar> GetGoodsByUser(String uid) {
		ShopCarDaoImpl shoImpl = new ShopCarDaoImpl();
		return shoImpl.GetGoodsByUser(uid);
	}

	@Override
	public int DeleteGoodsByID(int goodsid, String uid) {
		ShopCarDaoImpl sImpl = new ShopCarDaoImpl();
		return sImpl.DeleteGodosById(goodsid, uid);
	}

	@Override
	public double GetShopCarGoodsPrice(int goodsid, String uid) {
		ShopCarDaoImpl sImpl = new ShopCarDaoImpl();
		return sImpl.GetShopCarGoodsPrice(goodsid, uid);
	}
	
	

	
}
