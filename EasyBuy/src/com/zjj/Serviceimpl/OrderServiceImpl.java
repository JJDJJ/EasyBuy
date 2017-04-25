package com.zjj.Serviceimpl;

import java.util.List;

import com.zjj.DAOimpl.OrdersImpl;
import com.zjj.IService.IOrdersService;
import com.zjj.entity.OrderList;
import com.zjj.entity.OrdersInfo;
import com.zjj.entity.Oredrs;

public class OrderServiceImpl implements IOrdersService {

	@Override
	public int InsertOrders(Oredrs oredrs) {
		OrdersImpl oImpl = new OrdersImpl();
		return oImpl.InsertOrders(oredrs);
	}

	@Override
	public int InsertOrdersinfo(OrdersInfo ordersInfo) {
		OrdersImpl oImpl = new OrdersImpl();
		return oImpl.InsertOrdersinfo(ordersInfo);
	}

//	@Override
//	public List<OrderList> GetAllOrderList(String uid) {
//		OrdersImpl oImpl = new OrdersImpl();
//		return oImpl.GetAllOrderList(uid);
//	}

	@Override
	public List<OrderList> GetOrdersInfo(String uid, String orderid) {
		OrdersImpl oImpl = new OrdersImpl();
		return oImpl.GetOrdersInfo(uid, orderid);
	}

	@Override
	public List<OrdersInfo> GetOrders(String uid) {
		OrdersImpl oImpl = new OrdersImpl();
		return oImpl.GetOrders(uid);
	}

	@Override
	public OrderList GetOrdersInfoByID(String uid, String orderid) {
		OrdersImpl oImpl = new OrdersImpl();
		return oImpl.GetOrdersInfoByID(uid, orderid);
	}

	@Override
	public int CheckOrder(String orderid) {
		OrdersImpl oImpl = new OrdersImpl();
		return oImpl.CheckOrder(orderid);
	}
	
	
}
