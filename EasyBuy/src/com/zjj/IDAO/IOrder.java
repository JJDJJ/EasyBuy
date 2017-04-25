package com.zjj.IDAO;

import java.util.List;

import com.zjj.entity.OrderList;
import com.zjj.entity.OrdersInfo;
import com.zjj.entity.Oredrs;

/**
 * ����������ؽӿ�
 * @author ZJJ-PC
 *
 */
public interface IOrder {
	
	/**
	 * ���붩��
	 * @param oredrs
	 * @return
	 */
	public int InsertOrders(Oredrs oredrs);
	
	/**
	 * ���붩������
	 * @param ordersInfo
	 * @return
	 */
	public int InsertOrdersinfo(OrdersInfo ordersInfo);
	
	/**
	 * ��ȡ���ж���
	 * @param orderList
	 * @return
	 */
//	public List<OrderList> GetAllOrderList(String uid);
	
	/**
	 * ��ȡ��������
	 * @param uid
	 * @param orderid
	 * @return
	 */
	public List<OrderList> GetOrdersInfo(String uid,String orderid);
	
	/**
	 * ��ȡOrders_INFO
	 * @param orderList
	 * @return
	 */
	public  List<OrdersInfo> GetOrders(String uid);
	
	/**
	 * ����ID��ȡ������ϸ
	 * @param uid
	 * @param orderid
	 * @return
	 */
	public OrderList GetOrdersInfoByID(String uid,String orderid);
	
	/**
	 * ��鶩���Ƿ����
	 * @param orderid
	 * @return
	 */
	public int CheckOrder(String orderid);
}
