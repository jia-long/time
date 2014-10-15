package dao;

import common.dao.BaseDao;
import common.model.User;

public interface UserDao extends BaseDao<User, Integer> {
	public User findByName(String name);
}
