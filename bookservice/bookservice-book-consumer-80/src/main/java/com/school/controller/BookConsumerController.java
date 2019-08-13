package com.school.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.school.entity.Book;

@RestController
@RequestMapping("/book")
public class BookConsumerController {
	
	@Resource
	private RestTemplate restTemplate;
	
	private final static String PRE_HOST="http://BOOKSERVICE-BOOK";
	
	
	 /**
     * 添加或者修改信息
     * @param student
     * @return
     */
    @PostMapping(value="/add")
    private boolean save(Book book){
        return restTemplate.postForObject(PRE_HOST+"/book/add", book, Boolean.class);
    }
     
    
    /**
     * 添加或者修改信息
     * @param student
     * @return
     */
    @PostMapping(value="/modify")
    private boolean modify(Book book){
        return restTemplate.postForObject(PRE_HOST+"/book/modify", book, Boolean.class);
    }
    /**
    * 查询学生信息
    * @return
    */
   @SuppressWarnings("unchecked")
   @GetMapping(value="/list")
   public Object list(){
       return restTemplate.getForObject(PRE_HOST+"/book/list", Object.class);
   }
    
   /**
    * 根据id查询学生信息
    * @return
    */
   @SuppressWarnings("unchecked")
   @GetMapping(value="/querybyid/{id}")
   public Object get(@PathVariable("id") Integer id){
       return restTemplate.getForObject(PRE_HOST+"/book/querybyid/"+id, Object.class);
   }
    
   /**
    * 根据id删除学生信息
    * @return
    */
   @GetMapping(value="/del/{id}")
   public boolean delete(@PathVariable("id") Integer id){
       try{
           restTemplate.getForObject(PRE_HOST+"/book/del/"+id, Boolean.class);
           return true;
       }catch(Exception e){
           return false;
       }
   }
   
   /**
    * 根据id删除学生信息
    * @return
    */
   @SuppressWarnings("unchecked")
   @GetMapping(value="/getInfo")
   @ResponseBody
   public Map<String,Object> getInfo(){
       return restTemplate.getForObject(PRE_HOST+"/book/getInfo/", Map.class);
   }

}
