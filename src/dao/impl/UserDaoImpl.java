package dao.impl;

import java.util.List;

import common.dao.impl.BaseDaoImpl;
import common.model.User;
import dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {
	
	@Override
	public User findByName(String name){
		List<User> users = getHibernateTemplate().find("from User where name=?", name);
		if(users.isEmpty()){
			return null;
		}
		return users.get(0);
	}
}
