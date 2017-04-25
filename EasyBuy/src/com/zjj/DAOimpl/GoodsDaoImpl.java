package com.zjj.DAOimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjj.IDAO.GenericCommon;
import com.zjj.entity.Goods;
import com.zjj.util.JdbcTemplate;
import com.zjj.util.PreparedStatementSetter;
import com.zjj.util.RowBackHandler;
import com.zjj.util.RowCallBackHandler;
	
public class GoodsDaoImpl extends GenericCommon<Goods> {

	@Override
	public Goods findByID(final int id) {
		String sql = "select  G1.ID, G1.GOODS_NAME,G1.GOODS_PRICE,G2.GOODS_INTRODUCE,G2.IMG,G1.STOCK from Goods G1,Goods_Info G2 where G1.ID = G2.Goods_ID and G1.ID = ? ";
		
		return JdbcTemplate.query(sql, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1,id);		
			}
		}, createHandler());
	}

	private RowCallBackHandler<Goods> createHandler() {
		return new RowCallBackHandler<Goods>() {			
			@Override
			public Goods processRow(ResultSet rs) throws SQLException {
			   Goods goods = new Goods();
			   while(rs.next()){
				   goods.setGoodsimg(rs.getString("IMG"));
				   goods.setGoodsintroduce(rs.getString("GOODS_INTRODUCE"));
				   goods.setGoodsname(rs.getString("GOODS_NAME"));
				   goods.setGoodsprice(rs.getFloat("GOODS_PRICE"));
				   goods.setGoods_stock(rs.getInt("STOCK"));
				   goods.setGoodsid(rs.getInt("ID"));
//				   goods.setUptime(rs.getTimestamp("UpTime"));
			   }
			   return goods;				
			}
		};
	}

	@Override
	public List<Goods> findAll() {
		String sql = "select  G1.ID, G1.GOODS_NAME,G1.GOODS_PRICE,G2.GOODS_INTRODUCE,G2.IMG "
				+ "from Goods G1,Goods_Info G2 "
				+ "where G1.ID = G2.Goods_ID";
		return JdbcTemplate.queryList(sql, createHandler());
	}

	@Override
	public List<Goods> GetList() {
		String sql = "select  G1.ID, G1.GOODS_NAME,G1.GOODS_PRICE,G2.GOODS_INTRODUCE,G2.IMG "
				+ "from Goods G1,Goods_Info G2 "
				+ "where G1.ID = G2.Goods_ID";
		final List<Goods> GoodsList = new ArrayList<Goods>();
		JdbcTemplate.GetQuery(sql, new RowBackHandler() {		
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				while(rs.next()){
					   Goods goods = new Goods();			   
					   goods.setGoodsimg(rs.getString("IMG"));
					   goods.setGoodsintroduce(rs.getString("GOODS_INTRODUCE"));
					   goods.setGoodsname(rs.getString("GOODS_NAME"));
					   goods.setGoodsprice(rs.getDouble("GOODS_PRICE"));
					   goods.setGoodsid(rs.getInt("ID"));
					   GoodsList.add(goods);
				}
			}
		});
		return GoodsList;
	}
	
	
}
