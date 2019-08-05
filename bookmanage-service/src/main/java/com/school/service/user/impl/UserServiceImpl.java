package com.school.service.user.impl;


import javax.annotation.Resource;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.UserMapper;
import com.school.pojo.User;
import com.school.pojo.UserExample;
import com.school.pojo.UserExample.Criteria;
import com.school.service.user.UserService;
@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl  implements UserService {
     @Resource
	 private UserMapper userMapper;

	public User login(String name, String password) {
		// TODO Auto-generated method stub
		
		UserExample  example=new UserExample();
		Criteria  criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		
		criteria.andPasswordEqualTo(password);
		User user=DataAccessUtils.uniqueResult(userMapper.selectByExample(example));
		/*if(user==null) {
			throw new  BizException(FastJsonUtil.getResponseJson(2000, "用户名和密码错误！！", null));
		}*/
		return user;
	}
     
	

}
