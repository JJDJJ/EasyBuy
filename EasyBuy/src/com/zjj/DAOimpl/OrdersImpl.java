package com.zjj.DAOimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjj.IDAO.IOrder;
import com.zjj.entity.OrderList;
import com.zjj.entity.OrdersInfo;
import com.zjj.entity.Oredrs;
import com.zjj.util.JdbcTemplate;
import com.zjj.util.PreparedStatementSetter;
import com.zjj.util.RowBackHandler;
import com.zjj.util.RowCallBackHandler;

public class OrdersImpl implements IOrder {

	@Override
	public int InsertOrders(final Oredrs oredrs) {
		String sql = "insert into ORDERS values(ORDERS_SEQ.nextval,?,?,?)";
		return JdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, oredrs.getOrder_id());
				ps.setInt(2, oredrs.getGoods_id());
				ps.setInt(3, oredrs.getGoods_num());
			}
		});
	}

	@Override
	public int InsertOrdersinfo(final OrdersInfo ordersInfo) {
	    String sql  = "insert into ORDERS_INFO values(ORDERS_INFO_SEQ.nextval,?,?,'已提交','未付款',?,?,?,?);";
	    return JdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, ordersInfo.getOrder_id());
				ps.setString(2, ordersInfo.getUsername());
				ps.setString(3, ordersInfo.getMethod());
				ps.setString(4, ordersInfo.getOrdertime());
				ps.setInt(5, ordersInfo.getAddressid());
				ps.setDouble(6, ordersInfo.getOrderprice());
			}
		});
	}

	
	
	
//	@Override
//	public List<OrderList> GetAllOrderList(final String uid) {
//		String sql = "select O1.ACCOUNT_ID,O1.ORDER_ID,O1.ORDER_STATUS,O1.PAY_STATUS,O1.METHOD,O1.ORDER_TIME,O1.ORDER_PRICE,O4.GOODS_NAME,O4.GOODS_PRICE,O3.GOODS_NUM FROM ORDERS_INFO O1,ORDERS O3,GOODS O4 WHERE O1.ORDER_ID = O3.ORDER_ID AND O1.ACCOUNT_ID = ? AND O3.GOODS_ID  = O4.ID";
//	
//		final List<OrderList> orderLists = new ArrayList<OrderList>();
//		JdbcTemplate.query(sql, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, uid);	
//			}
//		}, new RowBackHandler() {		
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				while(rs.next()){
//					OrderList orderList = new OrderList();
//					orderList.setUsername(rs.getString("ACCOUNT_ID"));
//					orderList.setOrder_id(rs.getString("ORDER_ID"));
//					orderList.setOrderstatus(rs.getString("ORDER_STATUS"));
//					orderList.setPaystatus(rs.getString("PAY_STATUS"));
//					orderList.setMethod(rs.getString("METHOD"));
//					orderList.setOrdertime(rs.getString("ORDER_TIME"));
//					orderList.setOrderprice(rs.getDouble("ORDER_PRICE"));
//					orderList.setGoodsname(rs.getString("GOODS_NAME"));
//					orderList.setGoodsprice(rs.getDouble("GOODS_PRICE"));
//					orderList.setGoodsnum(rs.getInt("GOODS_NUM"));
//					orderLists.add(orderList);
//				}			
//			}
//		});
//		return orderLists;
//	}
	
	
	@Override
	public List<OrderList> GetOrdersInfo(final String uid,final String orderid) {
		String sql = "select O1.ACCOUNT_ID,O1.ORDER_ID,O1.ORDER_STATUS,O1.PAY_STATUS,O1.METHOD,O1.ORDER_TIME,O1.ORDER_PRICE,O2.GET_USERNAME,O2.PROVINCE,O2.CITY,O2.AREA,O2.ADDRESS_INFO,O2.PHONE,O4.ID,O4.GOODS_NAME,O4.GOODS_PRICE,O3.GOODS_NUM,O5.IMG,O5.GOODS_INTRODUCE FROM ORDERS_INFO O1,ADDRESS O2,ORDERS O3,GOODS O4,GOODS_INFO O5 WHERE O1.ORDER_ID = O3.ORDER_ID AND O1.ORDER_ID = ? AND O1.ACCOUNT_ID = ?  AND O1.ADDRESS_ID = O2.ID AND O3.GOODS_ID  = O4.ID AND O4.ID = O5.GOODS_ID";	
		 final List<OrderList> orderLists = new ArrayList<OrderList>();	
		 JdbcTemplate.query(sql, new PreparedStatementSetter() {		
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, orderid);
				ps.setString(2, uid);		
			}
		}, new RowBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				 while(rs.next()){
					 OrderList orderList = new OrderList();
					 orderList.setUsername(rs.getString("ACCOUNT_ID"));
					 orderList.setOrder_id(rs.getString("ORDER_ID"));
					 orderList.setOrderstatus(rs.getString("ORDER_STATUS"));
					 orderList.setPaystatus(rs.getString("PAY_STATUS"));
					 orderList.setMethod(rs.getString("METHOD"));
					 orderList.setOrdertime(rs.getString("ORDER_TIME"));
					 orderList.setOrderprice(rs.getDouble("ORDER_PRICE"));
					 orderList.setGetusername(rs.getString("GET_USERNAME"));
					 orderList.setProvince(rs.getString("PROVINCE"));
					 orderList.setCity(rs.getString("CITY"));
					 orderList.setArea(rs.getString("AREA"));
					 orderList.setAddressinfo(rs.getString("ADDRESS_INFO"));
					 orderList.setPhone(rs.getString("PHONE"));
					 orderList.setGoodsid(rs.getInt("ID"));
					 orderList.setGoodsname(rs.getString("GOODS_NAME"));
					 orderList.setGoodsprice(rs.getDouble("GOODS_PRICE"));
					 orderList.setGoodsnum(rs.getInt("GOODS_NUM"));
					 orderList.setGoodsimg(rs.getString("IMG"));
					 orderList.setGoodsintrouce(rs.getString("GOODS_INTRODUCE"));
					 orderLists.add(orderList);
				 }
			}
		});
			return orderLists;
	}

	@Override
	public List<OrdersInfo> GetOrders(final String uid) {
		String sql = "select * from ORDERS_INFO WHERE ACCOUNT_ID = ?";
		final List<OrdersInfo> list = new ArrayList<OrdersInfo>();
		 JdbcTemplate.query(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, uid);			
			}
		}, new RowBackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while(rs.next()){
					OrdersInfo orderinfo = new OrdersInfo();
					orderinfo.setOrder_id(rs.getString("ORDER_ID"));
					orderinfo.setUsername(rs.getString("ACCOUNT_ID"));
					orderinfo.setOrderstatus(rs.getString("ORDER_STATUS"));
					orderinfo.setPaystatus(rs.getString("PAY_STATUS"));
					orderinfo.setMethod(rs.getString("METHOD"));
					orderinfo.setOrdertime(rs.getString("ORDER_TIME"));
					orderinfo.setAddressid(rs.getInt("ADDRESS_ID"));
					orderinfo.setOrderprice(rs.getDouble("ORDER_PRICE"));
					list.add(orderinfo);
				}
			}
		});
		 return list;
	}

	@Override
	public OrderList GetOrdersInfoByID(final String uid,final String orderid) {
		String sql = "select O1.ACCOUNT_ID,O1.ORDER_ID,O1.ORDER_STATUS,O1.PAY_STATUS,O1.METHOD,O1.ORDER_TIME,O1.ORDER_PRICE,O2.GET_USERNAME,O2.PROVINCE,O2.CITY,O2.AREA,O2.ADDRESS_INFO,O2.ZIPCODE,O2.PHONE,O4.ID,O4.GOODS_NAME,O4.GOODS_PRICE,O3.GOODS_NUM,O5.IMG,O5.GOODS_INTRODUCE FROM ORDERS_INFO O1,ADDRESS O2,ORDERS O3,GOODS O4,GOODS_INFO O5 WHERE O1.ORDER_ID = O3.ORDER_ID AND O1.ORDER_ID = ? AND O1.ACCOUNT_ID = ?  AND O1.ADDRESS_ID = O2.ID AND O3.GOODS_ID  = O4.ID AND O4.ID = O5.GOODS_ID";	
		return JdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, orderid);
				ps.setString(2, uid);					
			}
		}, new RowCallBackHandler<OrderList>() {
			@Override
			public OrderList processRow(ResultSet rs) throws SQLException {
				OrderList orderinfo = new OrderList();
				 while(rs.next()){
					 orderinfo.setUsername(rs.getString("ACCOUNT_ID"));
					 orderinfo.setOrder_id(rs.getString("ORDER_ID"));
					 orderinfo.setOrderstatus(rs.getString("ORDER_STATUS"));
					 orderinfo.setPaystatus(rs.getString("PAY_STATUS"));
					 orderinfo.setMethod(rs.getString("METHOD"));
					 orderinfo.setOrdertime(rs.getString("ORDER_TIME"));
					 orderinfo.setOrderprice(rs.getDouble("ORDER_PRICE"));
					 orderinfo.setGetusername(rs.getString("GET_USERNAME"));
					 orderinfo.setProvince(rs.getString("PROVINCE"));
					 orderinfo.setCity(rs.getString("CITY"));
					 orderinfo.setArea(rs.getString("AREA"));
					 orderinfo.setAddressinfo(rs.getString("ADDRESS_INFO"));
					 orderinfo.setZipcode(rs.getString("ZIPCODE"));
					 orderinfo.setPhone(rs.getString("PHONE"));
					 orderinfo.setGoodsid(rs.getInt("ID"));
					 orderinfo.setGoodsname(rs.getString("GOODS_NAME"));
					 orderinfo.setGoodsprice(rs.getDouble("GOODS_PRICE"));
					 orderinfo.setGoodsnum(rs.getInt("GOODS_NUM"));
					 orderinfo.setGoodsimg(rs.getString("IMG"));
					 orderinfo.setGoodsintrouce(rs.getString("GOODS_INTRODUCE"));
				 }
				return orderinfo;
			}
		});		
	}

	@Override
	public int CheckOrder(final String orderid) {
		String sql  = "select  ORDER_ID  from ORDERS_INFO where ORDER_ID = ?";
		return JdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, orderid);	
			}
		}, new RowCallBackHandler<Integer>() {

			@Override
			public Integer processRow(ResultSet rs) throws SQLException {
				if(rs.next()){
					return 1;
				}
				return 0;
			}
		});
	}
}
