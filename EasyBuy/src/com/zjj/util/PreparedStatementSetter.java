package com.zjj.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {

	//ͨ��PreparedStatement������һЩֵ�滻ռλ��
	void setValues(PreparedStatement ps) throws SQLException;
}
