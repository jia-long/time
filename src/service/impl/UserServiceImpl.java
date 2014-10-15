package service.impl;

import service.UserService;
import common.model.User;
import common.service.impl.BaseServiceImpl;
import dao.UserDao;

public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
	
	UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	public User findByName(String name){
		return userDao.findByName(name);
	}
}
