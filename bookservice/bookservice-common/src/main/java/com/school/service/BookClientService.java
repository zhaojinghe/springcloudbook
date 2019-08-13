package com.school.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.entity.Book;

//@FeignClient(value="BOOKSERVICE-BOOK")
@FeignClient(value = "MICROSERVICE-STUDENT",fallbackFactory = BookClientFallbackFactory.class)
public interface BookClientService {

	/**
	 * 添加或者修改信息
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping(value = "/book/add")
	public boolean save(Book book);

	/**
	 * 添加或者修改信息
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping(value = "/book/modify")
	public boolean modify(Book book);

	/**
	 * 查询学生信息
	 * 
	 * @return
	 */

	@GetMapping(value = "/book/list")
	public Map<String, Object> list();

	/**
	 * 根据id查询学生信息
	 * 
	 * @return
	 */

	@GetMapping(value = "/book/querybyid/{id}")
	public Map<String, Object> get(@PathVariable("id") Integer id);

	/**
	 * 根据id删除学生信息
	 * 
	 * @return
	 */
	@GetMapping(value = "/book/del/{id}")
	public boolean delete(@PathVariable("id") Integer id);

	@GetMapping(value = "/book/getInfo")
	public Map<String, Object> getInfo();

}
