package com.xhhy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xhhy.bean.UserBean;
import com.xhhy.dao.UserDao;

@Service("us")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao ud;
	
	public UserBean login(String loginName, String password) {
		// TODO Auto-generated method stub
		return ud.login(loginName, password);
	}

}
