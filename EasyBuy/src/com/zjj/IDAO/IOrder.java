package com.zjj.IDAO;

import java.util.List;

import com.zjj.entity.OrderList;
import com.zjj.entity.OrdersInfo;
import com.zjj.entity.Oredrs;

/**
 * 订单操作相关接口
 * @author ZJJ-PC
 *
 */
public interface IOrder {
	
	/**
	 * 插入订单
	 * @param oredrs
	 * @return
	 */
	public int InsertOrders(Oredrs oredrs);
	
	/**
	 * 插入订单详情
	 * @param ordersInfo
	 * @return
	 */
	public int InsertOrdersinfo(OrdersInfo ordersInfo);
	
	/**
	 * 获取所有订单
	 * @param orderList
	 * @return
	 */
//	public List<OrderList> GetAllOrderList(String uid);
	
	/**
	 * 获取订单详情
	 * @param uid
	 * @param orderid
	 * @return
	 */
	public List<OrderList> GetOrdersInfo(String uid,String orderid);
	
	/**
	 * 获取Orders_INFO
	 * @param orderList
	 * @return
	 */
	public  List<OrdersInfo> GetOrders(String uid);
	
	/**
	 * 根据ID获取订单详细
	 * @param uid
	 * @param orderid
	 * @return
	 */
	public OrderList GetOrdersInfoByID(String uid,String orderid);
	
	/**
	 * 检查订单是否存在
	 * @param orderid
	 * @return
	 */
	public int CheckOrder(String orderid);
}
