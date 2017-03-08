package com.overthinkpro.appdemo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.overthinkpro.appdemo.common.Response;
import com.overthinkpro.appdemo.common.UUIDUtil;
import com.overthinkpro.appdemo.po.User;
import com.overthinkpro.appdemo.server.UserServer;

@Controller
@RequestMapping("/account")
public class UserControl {

	@Autowired
	private UserServer userServer;
	private Response result = new Response();

	@RequestMapping(value = "/findUser")
	public @ResponseBody Response findUser(@RequestBody User user) {
		if (!user.getIdCard().equals("") && !user.getPassword().equals("")) {
			User currentUser = userServer.findUser(user);
			if (currentUser.getId() != null || currentUser.getId() != "") {
				return result.success(currentUser);
			}
		}
		return result.failure("用户名密码错误");
	}

	@RequestMapping(value = "/register")
	public @ResponseBody Response regist(@RequestBody User user) {
		if (!user.getIdCard().equals("") && !user.getPassword().equals("")) {
			user.setId(UUIDUtil.getUUID());
			int registResult = userServer.addUser(user);
			if (registResult >= 1) {
				return result.success(user);
			}
		}
		return result.failure();
	}

	@RequestMapping(value = "/updateBalance")
	public @ResponseBody Response addBalance(@RequestBody User user) {
		boolean isChange = userServer.updateBalance(user);
		if(isChange){
			return result.success(isChange);
		}
		return result.failure();
	}
	
}
