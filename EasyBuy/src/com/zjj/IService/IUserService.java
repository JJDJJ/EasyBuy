package com.zjj.IService;

import com.zjj.entity.User;

/**
 *�û�ҵ���߼��ӿ� 
 * @author ZJJ-PC
 *
 */
public interface IUserService {

	/**
	 * ����user�����¼
	 * @param user
	 * @return
	 */
	public User Login(User user);
	
	/**
	 * �ж��û��Ƿ����
	 * @param name
	 * @return
	 */
	public int CheckUname(String name);
	
	/**
	 * ע��
	 * @param user
	 * @return
	 */
	public int insert(User user);
	
	public int insertuserinfo(User user);
	/**
	 * �����û�����ȡ�û�����
	 * @param name
	 * @return
	 */
	public User getUserInfoByName(String name);
	
}
