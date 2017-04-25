package com.zjj.IService;

import java.util.List;

import com.zjj.entity.OrderList;
import com.zjj.entity.OrdersInfo;
import com.zjj.entity.Oredrs;

public interface IOrdersService {

	
	public int InsertOrders( Oredrs oredrs);
	
	public int InsertOrdersinfo( OrdersInfo ordersInfo);
	
//	public List<OrderList> GetAllOrderList(String uid);
	
	public List<OrderList>  GetOrdersInfo(String uid,String orderid);
	
	public List<OrdersInfo> GetOrders(String uid);
	
	public OrderList GetOrdersInfoByID(String uid,String orderid);
	
	public int CheckOrder(String orderid);
}
