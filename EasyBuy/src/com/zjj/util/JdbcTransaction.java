package com.zjj.util;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransaction {
	// 事务的开始
		public static void beginTransaction(Connection conn) {

			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("beginTransaction failed");
			}
		}

		// 事务的提交
		public static void commitTransaction(Connection conn) {

			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("commitTransaction failed");
			}
		}

		// 事务的回滚
		public static void rollBackTransaction(Connection conn) {

			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("rollBackTransaction failed");
			}
		}

}
