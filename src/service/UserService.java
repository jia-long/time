package service;

import common.model.User;
import common.service.BaseService;

public interface UserService extends BaseService<User, Integer>{
	public User findByName(String name);
}
