package com.zjj.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowBackHandler {
	//��������
	void processRow(ResultSet rs) throws SQLException;
}
