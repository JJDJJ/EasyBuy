package com.zjj.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	public static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
	}
	public static void close(ResultSet rs, Statement stmt) {
		close(rs);
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
			}
		
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs,stmt);
		// if(pstmt != null) try{ pstmt.close(); }catch(Exception e){}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}
	}
}
