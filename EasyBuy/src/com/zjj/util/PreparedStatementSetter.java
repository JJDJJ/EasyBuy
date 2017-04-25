package com.zjj.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {

	//通过PreparedStatement来设置一些值替换占位符
	void setValues(PreparedStatement ps) throws SQLException;
}
