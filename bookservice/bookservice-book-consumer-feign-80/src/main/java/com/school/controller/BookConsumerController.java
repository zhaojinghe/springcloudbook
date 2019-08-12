package com.school.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Book;
import com.school.service.BookClientService;

@RestController
@RequestMapping(value="/book")
public class BookConsumerController {
	
	@Resource
	private BookClientService bookClientService;
	

	 /**
     * 添加或者修改信息
     * @param student
     * @return
     */
    @PostMapping(value="/add")
    private boolean save(Book book){
        return bookClientService.save(book);
    }
     
    
    /**
     * 添加或者修改信息
     * @param student
     * @return
     */
    @PostMapping(value="/modify")
    private boolean modify(Book book){
      return bookClientService.modify(book);
    }
    /**
    * 查询学生信息
    * @return
    */
   @RequestMapping(value="list")
   public Object list(){
     return bookClientService.list();
   }
    
   /**
    * 根据id查询学生信息
    * @return
    */
   @GetMapping(value="/querybyid/{id}")
   public Object get(@PathVariable("id") Integer id){
            return bookClientService.get(id);
   }
    
   /**
    * 根据id删除学生信息
    * @return
    */
   @GetMapping(value="/del/{id}")
   public boolean delete(@PathVariable("id") Integer id){
       try{
           bookClientService.delete(id);
    	   return true;
       }catch(Exception e){
           return false;
       }
   }

}
