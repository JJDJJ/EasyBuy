package com.zjj.IDAO;

import com.zjj.entity.User;

/**
 * User���ݿ�ӿ�
 * @author ZJJ-PC
 *
 */
public interface IUserDAO {

	/**
	 * ��������û�
	 * @param name
	 * @return
	 */
	public int findUsername(String name);
	
	public int insertuserinfo(User user);
	
}
