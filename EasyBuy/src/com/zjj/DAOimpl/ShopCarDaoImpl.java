package com.zjj.DAOimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

import com.zjj.IDAO.GenericCommon;
import com.zjj.IDAO.IShopCar;
import com.zjj.entity.ShoppingCar;
import com.zjj.util.JdbcTemplate;
import com.zjj.util.PreparedStatementSetter;
import com.zjj.util.RowBackHandler;
import com.zjj.util.RowCallBackHandler;

public class ShopCarDaoImpl extends GenericCommon<ShoppingCar> implements
		IShopCar {

	@Override
	public int insert(final ShoppingCar shopCar) {
		String sql = "INSERT INTO SHOPCAR VALUES(ShopCar_SEQ.nextval,?,?,?,?)";	
		return JdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				try {
					ps.setString(1, shopCar.getShopuser());
					ps.setInt(2, shopCar.getGoods_id());
					ps.setInt(3, shopCar.getGoods_num());
					ps.setDouble(4, shopCar.getGoods_subtotal());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
	}

	public int update(final ShoppingCar shopCar) {
		String sql = "UPDATE SHOPCAR SET GOODS_NUM = ?, PRICE = ?  WHERE SHOPUSER = ? AND Goods_ID = ?";
		return JdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, shopCar.getGoods_num());
				ps.setDouble(2, shopCar.getGoods_subtotal());
				ps.setString(3, shopCar.getShopuser());
				ps.setInt(4, shopCar.getGoods_id());
			}
		});
	}

	private int cgid = -1;

	@Override
	public int CheckGoodsById(final int goodsid, final String uid) {
		String sql = "SELECT COUNT(*) GOODSNUM FROM GOODS G1,GOODS_INFO G2,SHOPCAR G3  WHERE G1.ID = G2.GOODS_ID AND G3.GOODS_ID = G2.GOODS_ID AND G3.GOODS_ID = ? AND G3.SHOPUSER =?";
		JdbcTemplate.GetNum(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, goodsid);
				ps.setString(2, uid);
			}
		}, new RowBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					cgid = rs.getInt(1);
				}
			}
		});
		return cgid;
	}

	private int goodsrow = -1;

	@Override
	public int CheckGoodsRowsById(final String uid) {
		String sql = "SELECT COUNT(*) GOODSNUM FROM GOODS G1,GOODS_INFO G2,SHOPCAR G3  WHERE G1.ID = G2.GOODS_ID AND G3.GOODS_ID = G2.GOODS_ID  AND G3.SHOPUSER =?";
		JdbcTemplate.GetNum(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, uid);
			}
		}, new RowBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					goodsrow = rs.getInt(1);
				}
			}
		});
		return goodsrow;
	}

	private int num = -1;

	@Override
	public int GetShopCarGoodsNum(final int goodsid, final String uid) {
		String sql = "SELECT G3.GOODS_NUM FROM GOODS G1,GOODS_INFO G2,SHOPCAR G3 WHERE G1.ID = G2.GOODS_ID AND G3.GOODS_ID = G2.GOODS_ID AND G3.GOODS_ID = ? AND G3.SHOPUSER = ?";
		JdbcTemplate.GetNum(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, goodsid);
				ps.setString(2, uid);
			}
		}, new RowBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					num = rs.getInt(1);
				}
			}
		});
		return num;
	}
	
	
	private double price = -1;
	@Override
	public double GetShopCarGoodsPrice(final int goodsid, final String uid) {
		String sql = "SELECT G3.PRICE FROM GOODS G1,GOODS_INFO G2,SHOPCAR G3 WHERE G1.ID = G2.GOODS_ID AND G3.GOODS_ID = G2.GOODS_ID AND G3.GOODS_ID = ? AND G3.SHOPUSER = ?";
		JdbcTemplate.GetNum(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, goodsid);
				ps.setString(2, uid);
			}
		}, new RowBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					price = rs.getDouble("PRICE");
				}
			}
		});
		return price;
	}

	@Override
	public List<ShoppingCar> GetGoodsByUser(final String uid) {
		String sql = "SELECT G1.ID,G1.GOODS_NAME,G2.IMG,G1.GOODS_PRICE,G3.GOODS_NUM,G2.GOODS_INTRODUCE,G1.STOCK,G3.PRICE  FROM GOODS G1,Goods_Info G2,SHOPCAR G3  WHERE G1.ID = G2.GOODS_ID AND G3.GOODS_ID = G2.GOODS_ID  AND SHOPUSER = ?";
		final List<ShoppingCar> ShopCarList = new ArrayList<ShoppingCar>();
		JdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, uid);
			}
		}, new RowBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {			
				while (rs.next()) {
					ShoppingCar shoppingCar = new ShoppingCar();
					shoppingCar.setGoods_id(rs.getInt("ID"));
					shoppingCar.setGoodsname(rs.getString("GOODS_NAME"));
					shoppingCar.setGoods_img(rs.getString("IMG"));
					shoppingCar.setGoods_money(rs.getDouble("GOODS_PRICE"));
					shoppingCar.setGoods_num(rs.getInt("GOODS_NUM"));
					shoppingCar.setGoods_introduce(rs.getString("GOODS_INTRODUCE"));			
					shoppingCar.setStock(rs.getInt("STOCK"));
					shoppingCar.setGoods_subtotal(rs.getDouble("PRICE"));
					ShopCarList.add(shoppingCar);					
				}
			}
		});
		return ShopCarList;
	}

	@Override
	public int DeleteGodosById(final int goodsid,final String uid) {
		String sql = "DELETE SHOPCAR WHERE GOODS_ID = ? AND SHOPUSER = ?";
		final int rows = -1;
		 JdbcTemplate.update(sql, new PreparedStatementSetter() {		
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, goodsid);
				ps.setString(2, uid);		
			}
		});
		return rows;
	}
}
