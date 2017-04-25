package com.zjj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	// ��ʹ��������ʱ�����þ�̬�飬ֻ��ִ��һ�Σ������Ծ�̬��������ʼ��
	static {
		Properties props = new Properties();
		InputStream is = ConnectionFactory.class.getResourceAsStream("jdbcinfo.properties");
		// ������������ʽ��ȡ�����ļ�
		try {
			props.load(is);
			driver = props.getProperty("oracle.driver");
			url = props.getProperty("oracle.url");
			username = props.getProperty("oracle.user");
			password = props.getProperty("oracle.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
