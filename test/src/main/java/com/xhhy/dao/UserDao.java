package com.xhhy.dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.xhhy.bean.UserBean;

@Repository("ud")
public interface UserDao {

	public UserBean login(@Param("ln")String loginName,@Param("ps")String password);
}
