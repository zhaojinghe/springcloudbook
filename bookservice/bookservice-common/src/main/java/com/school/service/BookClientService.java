package com.school.service;


import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.school.entity.Book;
@FeignClient(value="BOOKSERVICE-BOOK")
public interface BookClientService {
	
	
	 /**
    * 添加或者修改信息
    * @param student
    * @return
    */
   @PostMapping(value="/add")
   public boolean save(Book book);
    
   
   /**
    * 添加或者修改信息
    * @param student
    * @return
    */
   @PostMapping(value="/modify")
   public boolean modify(Book book);
   /**
   * 查询学生信息
   * @return
   */
 
  @GetMapping(value="/list")
  public Object list();
   
  /**
   * 根据id查询学生信息
   * @return
   */
 
  @GetMapping(value="/querybyid/{id}")
  public Object get(@PathVariable("id") Integer id);
  /**
   * 根据id删除学生信息
   * @return
   */
  @GetMapping(value="/del/{id}")
  public boolean delete(@PathVariable("id") Integer id);



}
