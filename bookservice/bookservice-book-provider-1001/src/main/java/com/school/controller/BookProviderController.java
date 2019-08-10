package com.school.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.entity.Book;
import com.school.service.BookService;

@Controller
@RequestMapping("/book")
public class BookProviderController {
	
	
	@Resource
	private BookService bookService;
	
	@RequestMapping(value="/list",produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object queryList(){
		System.out.println("===============provider 1001==================");
		List<Book>  booklist=bookService.findBookInfos();
		
         Map<String,Object>  jsonmap=new HashMap<>();
		
		jsonmap.put("code", 0);
			
		jsonmap.put("msg", "ok");
			
		jsonmap.put("data", booklist);
		
		return jsonmap;
		
	}
	
	 // 排序分页显示数据
    @GetMapping("/pagelist")
    @ResponseBody
    public Object showSortPage(@RequestParam(value = "page",defaultValue="1") Integer page, 
    		@RequestParam(value = "size",required=false,defaultValue="5") Integer size){
        System.out.println("排序分页： page:"+page+"; size:"+size);

        if(page==0){
        	
        	page=1;
        }
        Page<Book>  pagelist= bookService.getPageSort(page, size);
        
        Map<String,Object>  jsonmap=new HashMap<>();
		
      		jsonmap.put("code", 0);
      			
      		jsonmap.put("msg", "ok");
      			
      		jsonmap.put("data", pagelist);
      		return jsonmap;
    }

	@RequestMapping("/ajaxlist")
	@ResponseBody
	public List<Book> queryListname(String name){

		
		return bookService.findByLikeName(name);
		
	}
	
	
	@RequestMapping("/ajaxnameauthor")
	@ResponseBody
	public Object  querybynameauthor(@RequestParam(value = "page",defaultValue="1") Integer page, 
    		@RequestParam(value = "size",required=false,defaultValue="5") Integer size,
    		@RequestParam(value = "name",required=false) String name,
    		@RequestParam(value = "author",required=false) String author){
      
		Book book=new Book();
		
		book.setAuthor(author);
		book.setName(name);
		System.out.println(author+"================="+name);
		 Page<Book>  pagelist=  bookService.findByNameOfAuthor(book,page,size);
	        
	        Map<String,Object>  jsonmap=new HashMap<>();
			
	      		jsonmap.put("code", 0);
	      			
	      		jsonmap.put("msg", "ok");
	      			
	      		jsonmap.put("data", pagelist);
	      		
	      		return jsonmap;
		
	}
	
	
	
	@PostMapping("/add")
	public String  add(Book book){
      
		 bookService.addBookInfo(book);
		 return "forword:/book/pagelist";
		
	}
	
	@PostMapping("/modify")
	public String  modify(Book book){
      
		 bookService.modifyBookInfo(book);
		 return "forword:/book/pagelist";
		
	}
	

	@RequestMapping(value="/querybyid/{id}",produces="application/json;charset=UTF-8")
	@ResponseBody
	public  Object queryByid(@PathVariable("id")Integer id){
      
      
		
		Book  booklist=bookService.findByid(id);
		
		 Map<String,Object>  jsonmap=new HashMap<>();
			
    		jsonmap.put("code", 0);
    			
    		jsonmap.put("msg", "ok");
    			
    		jsonmap.put("data", booklist);
		return jsonmap;
		
	}
	
	@GetMapping("/del")
	public String  del(Integer id){
      
		 bookService.delBookInfo(id);
		 return "forword:/book/pagelist";
		
	}

}
