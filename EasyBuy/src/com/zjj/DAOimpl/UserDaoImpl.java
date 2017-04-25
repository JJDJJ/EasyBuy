package com.zjj.DAOimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zjj.IDAO.GenericCommon;
import com.zjj.IDAO.IUserDAO;
import com.zjj.entity.User;
import com.zjj.util.JdbcTemplate;
import com.zjj.util.PreparedStatementSetter;
import com.zjj.util.RowCallBackHandler;

/**
 * 用户数据实现
 * @author ZJJ-PC
 *
 */
public class UserDaoImpl extends GenericCommon<User> implements IUserDAO {

	@Override
	public User query(final User users) {
		String sql = "select  * from Accounts where account = ? and password = ?";
		return JdbcTemplate.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, users.getUsername());
				ps.setString(2, users.getUserpwd());
			}
		}, new RowCallBackHandler<User>() {
			
			@Override
			public User processRow(ResultSet rs) throws SQLException {
				User u  = new User();
				if(rs.next()){
					u.setUsername(rs.getString(1));
					u.setUserpwd(rs.getString(2));
				}
				return u;				
			}
		});
	}
	
	@Override
	public int findUsername(final String name) {
	    String sql = "select * from Accounts where account = ? ";    
	    return  JdbcTemplate.query(sql, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
			}
		},createHandler());
	}	
	
	private RowCallBackHandler<Integer> createHandler(){
		return new RowCallBackHandler<Integer>() {
			@Override
			public Integer processRow(ResultSet rs) throws SQLException {
				int rows = -1;
				if(rs.next()){
					rows = 1;
				}
				return rows;
			}
		};		
	}
	
	
	
	@Override
	public int insert(final User users) {
		String sql = "insert into Accounts values(ACCOUNTS_SEQ.nextval,?,?)";
		int rows = JdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			 ps.setString(1, users.getUsername());
			 ps.setString(2, users.getUserpwd());
			}
		});
		return rows;
	}

	public User queryByName(final String name){
		String sql ="select A1.ACCOUNT,A2.SEX,A2.BIRTHDAY,A2.IDENTITY,A2.EMAIL,A2.PHONE,A2.HEADPIC from ACCOUNTS A1 ,Userinfo A2 where A2.ACCOUNT_ID = A1.ACCOUNT and A1.ACCOUNT = ?";
		User users  = new User();
		
		users=  JdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			    ps.setString(1, name);
				
			}
		}, new RowCallBackHandler<User>() {

			@Override
			public User processRow(ResultSet rs) throws SQLException {
				User user = new User();
				if(rs.next()){		
					user.setUsername(rs.getString("ACCOUNT")); 	
					user.setSex(rs.getInt("SEX"));
					user.setBirthday(rs.getString("BIRTHDAY"));
					user.setIdentity(rs.getString("IDENTITY"));
					user.setEmail(rs.getString("EMAIL"));
					user.setPhone(rs.getString("PHONE"));					
					user.setHeadpic(rs.getString("HEADPIC"));		
				}	
				return user;
			}			
		});
		return users;
	}

	@Override
	public int insertuserinfo(final User user) {
		String sql = "insert into USERINFO values(USERINFO_SEQ.nextval,?,?,?,?,?,?,?,?)";
		int rows = JdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			 ps.setString(1, user.getUsername());
			 ps.setInt(2, 0);
			ps.setString(3, " ");
			ps.setString(4, " ");
			ps.setString(5, " ");
			ps.setString(6, " ");
			ps.setInt(7, 0);
			ps.setString(8, "Aetly.jpg");
			}
		});
		return rows;
	}
}
