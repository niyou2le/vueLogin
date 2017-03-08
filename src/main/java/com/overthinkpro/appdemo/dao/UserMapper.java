package com.overthinkpro.appdemo.dao;

import com.overthinkpro.appdemo.po.User;

public interface UserMapper {
	
	public User findUser(User user);
	
	public int addUser(User user);
	
	public int deleteUser(User user);
	
	public boolean updateBalance(User user);
}
