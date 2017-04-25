package com.zjj.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowBackHandler {
	//处理结果集
	void processRow(ResultSet rs) throws SQLException;
}
