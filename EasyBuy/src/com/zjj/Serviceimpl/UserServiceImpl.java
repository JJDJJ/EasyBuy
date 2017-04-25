package com.zjj.Serviceimpl;

import com.zjj.DAOimpl.UserDaoImpl;
import com.zjj.IDAO.ICommonDao;
import com.zjj.IDAO.IUserDAO;
import com.zjj.IService.IUserService;
import com.zjj.entity.User;

public class UserServiceImpl implements IUserService {

	ICommonDao<User> commonDao = null;
	IUserDAO iUserDAO = null;
	@Override
	public User Login(User user) {
		commonDao = new UserDaoImpl();
		return  commonDao.query(user);
	}
	@Override
	public int CheckUname(String name) {
		iUserDAO = new UserDaoImpl();	
		return iUserDAO.findUsername(name);
	}
	
	@Override
	public int insert(User user) {
		commonDao = new UserDaoImpl();
		return commonDao.insert(user);
	}
	@Override
	public User getUserInfoByName(String name) {
	  commonDao = new UserDaoImpl();
	  return commonDao.queryByName(name);
	}
	@Override
	public int insertuserinfo(User user) {
		UserDaoImpl udImpl = new UserDaoImpl();
		return udImpl.insertuserinfo(user);
	}
}
