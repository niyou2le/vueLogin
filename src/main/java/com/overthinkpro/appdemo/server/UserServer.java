package com.overthinkpro.appdemo.server;

import com.overthinkpro.appdemo.po.User;

public interface UserServer {

	public User findUser(User user);

	public int addUser(User user);

	public int deleteUser(User user);
	
	public boolean addBalance(User user);

	public boolean reduceBalance(User user);
}
