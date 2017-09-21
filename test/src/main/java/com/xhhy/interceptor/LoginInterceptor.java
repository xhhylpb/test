package com.xhhy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xhhy.bean.UserBean;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		// 获取Session
		String uri = arg0.getRequestURI();
		System.out.println(uri);
		String path =arg0.getContextPath();
		System.out.println(path);
		if(uri.equals(path+"/login.jsp") || uri.equals(path+"/login")){
			return true;
		}else{
			HttpSession session = arg0.getSession();
			UserBean ub = (UserBean) session.getAttribute("u");
			if (ub != null) {
				return true;
			}else{
				// 不符合条件的，跳转到登录界面
				arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
				return false;
			}
		}
	}

}
