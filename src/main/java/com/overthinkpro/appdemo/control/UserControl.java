package com.overthinkpro.appdemo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.overthinkpro.appdemo.common.Response;
import com.overthinkpro.appdemo.common.UUIDUtil;
import com.overthinkpro.appdemo.po.User;
import com.overthinkpro.appdemo.server.UserServer;

@RestController
@RequestMapping("/account")
public class UserControl {

	@Autowired
	private UserServer userServer;

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public Response findUser(@RequestBody User user) {
		if (!user.getIdCard().equals("") && !user.getPassword().equals("")) {
			User currentUser = userServer.findUser(user);
			if (currentUser.getId() != null || currentUser.getId() != "") {
				return new Response().success(currentUser);
			}
		}
		return new Response().failure("用户名密码错误");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Response regist(@RequestBody User user) {
		if (!user.getIdCard().equals("") && !user.getPassword().equals("")) {
			user.setId(UUIDUtil.getUUID());
			int registResult = userServer.addUser(user);
			if (registResult >= 1) {
				return new Response().success(user);
			}
		}
		return new Response().failure();
	}

	@RequestMapping(value = "/updateBalance", method = RequestMethod.PUT)
	public Response addBalance(@RequestBody User user) {
		boolean isChange = userServer.updateBalance(user);
		if(isChange){
			return new Response().success(isChange);
		}
		return new Response().failure();
	}
	
}
