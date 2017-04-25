package com.zjj.IService;

import com.zjj.entity.User;

/**
 *用户业务逻辑接口 
 * @author ZJJ-PC
 *
 */
public interface IUserService {

	/**
	 * 根据user对象登录
	 * @param user
	 * @return
	 */
	public User Login(User user);
	
	/**
	 * 判断用户是否存在
	 * @param name
	 * @return
	 */
	public int CheckUname(String name);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public int insert(User user);
	
	public int insertuserinfo(User user);
	/**
	 * 根据用户名获取用户对象
	 * @param name
	 * @return
	 */
	public User getUserInfoByName(String name);
	
}
