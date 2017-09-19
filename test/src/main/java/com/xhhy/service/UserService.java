package com.xhhy.service;


import org.springframework.stereotype.Service;

import com.xhhy.bean.UserBean;


public interface UserService {

	public UserBean login(String loginName,String password);
}
