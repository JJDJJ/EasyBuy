package com.zjj.IDAO;

import com.zjj.entity.User;

/**
 * User数据库接口
 * @author ZJJ-PC
 *
 */
public interface IUserDAO {

	/**
	 * 查找相关用户
	 * @param name
	 * @return
	 */
	public int findUsername(String name);
	
	public int insertuserinfo(User user);
	
}
