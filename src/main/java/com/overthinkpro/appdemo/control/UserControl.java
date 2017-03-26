package com.overthinkpro.appdemo.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.overthinkpro.appdemo.po.User;
import com.overthinkpro.appdemo.server.UserServer;
import com.overthinkpro.appdemo.util.ErrorMsg;
import com.overthinkpro.appdemo.util.Response;

@RestController
@RequestMapping("/user")
public class UserControl {

	@Autowired
	private UserServer userServer;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public Map<Object, Object> findUser(@RequestBody User user) {
		if (!user.getIdCard().equals("") && !user.getPassword().equals("")) {
			User currentUser = userServer.findUser(user);
			if (currentUser.getIdCard() != null || currentUser.getIdCard() != "") {
				
				List<User> users = new ArrayList<User>();
				User u1 = new User();
				u1.setBalance(100);
				User u2 = new User();
				u2.setBalance(200);
				
				users.add(u1);
				users.add(u2);
				
				return new Response().failure(ErrorMsg.LOGIN_FAIL).toSimpleResult();
			}
		}
		return new Response().failure("用户名密码错误").toSimpleResult();
	}

//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public Map<Object, Object> regist(@RequestBody User user) {
//		if (!user.getIdCard().equals("") && !user.getPassword().equals("")) {
//			user.setId(UUIDUtil.getUUID());
//			int registResult = userServer.addUser(user);
//			if (registResult >= 1) {
//				return new Response2().success(user);
//			}
//		}
//		return new Response2().failure();
//	}
//
//	@RequestMapping(value = "/updateBalance", method = RequestMethod.PUT)
//	public Map<Object, Object> addBalance(@RequestBody User user) {
//		boolean isChange = userServer.updateBalance(user);
//		if(isChange){
//			return new Response2().success(isChange);
//		}
//		return new Response2().failure();
//	}
//	
//	@RequestMapping(value = "/aaa", method = RequestMethod.PUT)
//	public Map<Object, Object> addBalance() {
//		System.out.println("fdsfs");
//		return new Response2().failure();
//	}
	
}
