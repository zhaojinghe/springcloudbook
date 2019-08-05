package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.common.exception.BizException;
import com.school.common.web.BaseController;
import com.school.pojo.User;
import com.school.service.user.UserService;

@Controller
public class UserController extends BaseController {
	
	@Resource
	private UserService userService;
	
	
	
	@RequestMapping("/welcome")
	public String welocme() {
		
	
		return "login";
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET,produces=HTML_PRODUCE_TYPE)
	@ResponseBody
	public String  login(@RequestParam("name")String name
			,@RequestParam("password") String password) throws BizException {
		
		try {
			User result=userService.login(name, password);
			List<User>  resultlist=new ArrayList<User>();
		//	resultlist.add(result);
			return  dealQueryResult(result, result);
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			return dealException(2000, "系统错误", e);
		}
		
	}
	

}
