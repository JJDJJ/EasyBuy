package com.zjj.DAOimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zjj.IDAO.IAddress;
import com.zjj.entity.Address;
import com.zjj.util.JdbcTemplate;
import com.zjj.util.PreparedStatementSetter;
import com.zjj.util.RowBackHandler;
import com.zjj.util.RowCallBackHandler;

public class AddressImpl implements IAddress {

	@Override
	public List<Address> GetAllAddress(final String uid) {
		String sql = "select * from ADDRESS where ACCOUNT_ID =?";
		final List<Address> addresslist = new ArrayList<Address>();
		 JdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, uid);				
			}
		},new RowBackHandler() {	
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while(rs.next()){
					Address address = new Address();
					address.setId(rs.getInt("ID"));
					address.setAddress_info(rs.getString("ADDRESS_INFO"));
					address.setZipcode(rs.getString("ZIPCODE"));
					address.setPhone(rs.getString("PHONE"));
					address.setArea(rs.getString("AREA"));
					address.setCity(rs.getString("CITY"));
					address.setGet_username(rs.getString("GET_USERNAME"));
					address.setProvince(rs.getString("PROVINCE"));
					addresslist.add(address);
				}		
			}
		});
		 return addresslist;
	}

	@Override
	public int insertAddress(final Address address) {
		String sql = "insert into ADDRESS values(ADDRESS_SEQ.nextval,?,?,?,?,?,?,?,?);";
		return JdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, address.getAccount_id());
				ps.setString(2, address.getGet_username());
				if(address.getZipcode() == null){
					ps.setString(3, "000000");				
				}else{
					ps.setString(3, address.getZipcode());
				}
				ps.setString(4, address.getProvince());
				ps.setString(5, address.getCity());
				ps.setString(6, address.getArea());
				ps.setString(7, address.getAddress_info());
				ps.setInt(8,Integer.parseInt(address.getPhone()));
			}
		});
	}

	@Override
	public Address GetAddressByID(final int id) {
		String sql = "select * from ADDRESS where ID = ?";
		return JdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);				
			}
		}, new RowCallBackHandler<Address>() {

			@Override
			public Address processRow(ResultSet rs) throws SQLException {
				Address address = new Address();
				if (rs.next()) {
					address.setProvince(rs.getString("PROVINCE"));
					address.setCity(rs.getString("CITY"));
					address.setArea(rs.getString("AREA"));
					address.setGet_username(rs.getString("GET_USERNAME"));
					address.setAddress_info(rs.getString("ADDRESS_INFO"));
					address.setAccount_id(rs.getString("ACCOUNT_ID"));
					address.setPhone(rs.getString("PHONE"));
					address.setZipcode(rs.getString("ZIPCODE"));
				}
				return address;
			}
		});
	}

	@Override
	public Address GetAddressByUser_ID(final String uid,final int id) {
		String sql = "select * from ADDRESS where ID = ? AND ACCOUNT_ID = ?";
		return JdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);		
				ps.setString(2, "ACCOUNT_ID");
			}
		}, new RowCallBackHandler<Address>() {

			@Override
			public Address processRow(ResultSet rs) throws SQLException {
				Address address = new Address();
				if (rs.next()) {
					address.setProvince(rs.getString("PROVINCE"));
					address.setCity(rs.getString("CITY"));
					address.setArea(rs.getString("AREA"));
					address.setGet_username(rs.getString("GET_USERNAME"));
					address.setAddress_info(rs.getString("ADDRESS_INFO"));
					address.setAccount_id(rs.getString("ACCOUNT_ID"));
					address.setPhone(rs.getString("PHONE"));
					address.setZipcode(rs.getString("ZIPCODE"));
				}
				return address;
			}
		});
	}
}
