package com.overthinkpro.appdemo.server.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.overthinkpro.appdemo.dao.UserMapper;
import com.overthinkpro.appdemo.po.User;
import com.overthinkpro.appdemo.server.UserServer;

@Service("userServer")
public class UserServerImpl implements UserServer {

	@Resource
	private UserMapper userMapper;

	@Override
	public User findUser(User user) {
		return userMapper.findUser(user);
	}

	@Override
	public int addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return userMapper.deleteUser(user);
	}

	@Override
	public boolean updateBalance(User user) {
		return userMapper.updateBalance(user);
	}

}
