package com.zjj.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public  interface RowCallBackHandler<T> {
	//处理结果集
		public T processRow(ResultSet rs) throws SQLException;
}
