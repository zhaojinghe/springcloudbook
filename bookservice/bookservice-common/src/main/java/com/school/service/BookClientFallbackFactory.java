package com.school.service;



import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.school.entity.Book;

import feign.hystrix.FallbackFactory;

@Component
public class BookClientFallbackFactory  implements FallbackFactory<BookClientService>{

	@Override
	public BookClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new BookClientService() {
			
			@Override
			public boolean save(Book book) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean modify(Book book) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Map<String, Object> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map<String, Object> getInfo() {
				// TODO Auto-generated method stub
				 Map<String,Object> map=new HashMap<String,Object>();
	                map.put("code", 500);
	                map.put("msg", "系统出错，稍后重试");
	                map.put("data", null);
	                return map;
			}
			
			@Override
			public Map<String, Object> get(Integer id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean delete(Integer id) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
