package com.zjj.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class JdbcTemplate {
	private static Connection conn;

	// R(retrieve)
	public static <T> T query(String sql, RowCallBackHandler<T> handler) {
		Statement stmt = null;   //设置参数
		ResultSet rs = null;		//结果集
		T data = null;	
		conn = ConnectionFactory.getConnection();   //连接jdbc
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (handler != null) {
				data = handler.processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt);
		}
		return data;
	}

	public static <T> List<T> queryList(String sql,
			RowCallBackHandler<T> handler) {
		Statement stmt = null;
		ResultSet rs = null;
		List<T> dataList = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (handler != null) {
				dataList = new ArrayList<T>();
				while (rs.next()) {
					dataList.add(handler.processRow(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt);
		}
		return dataList;
	}

	// R(retrieve)
	public static <T> T query(String sql, PreparedStatementSetter setter,
			RowCallBackHandler<T> handler) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T data = null;
		conn = ConnectionFactory.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);
			}
			rs = pstmt.executeQuery();
			if (handler != null) {
				data = handler.processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}
		return data;
	}

	// R(retrieve)
	public static void query(String sql, PreparedStatementSetter setter,
			RowBackHandler handler) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = ConnectionFactory.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);
			}
			rs = pstmt.executeQuery();
			if (handler != null) {
				 handler.processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}
	}
	
	public static void GetQuery(String sql, RowBackHandler rowBackHandler) {
		Statement stmt = null;
		ResultSet rs = null;
		conn = ConnectionFactory.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rowBackHandler != null) {
				rowBackHandler.processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, stmt);
		}
	}

	public static void GetNum(String sql, PreparedStatementSetter setter,
			RowBackHandler handler) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = ConnectionFactory.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);
			}
			rs = pstmt.executeQuery();
			if (handler != null) {
				handler.processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}
	}

	// c(create) u(update) d(delete)
	/**
	 * @param sql
	 * @param setter
	 * @throws DataAccessException
	 *             不需要处理结果集
	 */
	public static int update(String sql, PreparedStatementSetter setter) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = ConnectionFactory.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);
			}
			pstmt.executeQuery();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt);
		}
		return -1;
	}
}
