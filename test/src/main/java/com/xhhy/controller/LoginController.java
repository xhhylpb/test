package com.xhhy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xhhy.bean.UserBean;
import com.xhhy.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService us ;
	
	@RequestMapping("/login")
	public String login(String loginName,String password,Model m){
		UserBean ub = us.login(loginName, password);
		m.addAttribute("u", ub);
		return "/index.jsp";
	}
}
