package com.zjj.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public  interface RowCallBackHandler<T> {
	//��������
		public T processRow(ResultSet rs) throws SQLException;
}
