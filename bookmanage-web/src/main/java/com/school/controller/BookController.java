package com.school.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.common.exception.BizException;
import com.school.common.web.BaseController;
import com.school.common.web.Pager;
import com.school.pojo.Book;
import com.school.service.book.BookService;

@Controller
public class BookController  extends BaseController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("/index")
	public String index() {
	
		return "index";
	}
	@RequestMapping("/modify.html")
	public String update() {
	
		return "modify";
	}
	
	@RequestMapping("/add.html")
	public String add() {
	
		return "add";
	}
	@RequestMapping(value="/main",method=RequestMethod.GET,produces=HTML_PRODUCE_TYPE)
	@ResponseBody
	public String main(@RequestParam(required=true,defaultValue="1")Integer page) throws BizException {
		
		PageHelper.startPage(page,5);
		try {
			List<Book>   booklist=bookService.findAllBooks();
			
			PageInfo<Book> result=new PageInfo<Book>(booklist);
			
			return dealQueryResult(booklist,result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return dealException(2000, "系统错误！", e);
		}
		
	}
	
	
	
	
	@RequestMapping(value="/doadd",produces=HTML_PRODUCE_TYPE)
	@ResponseBody
	public String doadd(Book book) throws BizException {
		

		try {
			int result=bookService.addBook(book);
			
			return dealQueryResult(result, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return dealException(2000, "添加失败！！！", e);
		}
	}
	
	
	@RequestMapping(value="/find",produces=HTML_PRODUCE_TYPE)
	@ResponseBody
	public String find(@RequestParam("id")Integer id) throws BizException {
		
		try {
			 
			Book result=bookService.findById(id);
			
			return dealQueryResult(result, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return dealException(2000, "查询失败！！！", e);
		}
	}
	
	
	@RequestMapping(value="/modify",produces=HTML_PRODUCE_TYPE)
	@ResponseBody
	public String modify(Book book) throws BizException {
	
		
		try {
			int result=bookService.modifyBook(book);
			
			return dealQueryResult(result, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return dealException(2000, "修改失败！！！", e);
		}
	}
	@RequestMapping(value="/del",produces=HTML_PRODUCE_TYPE)
	@ResponseBody
	public String del(@RequestParam("id")Integer id ) throws BizException {
	
		
		try {
			int result=bookService.delBook(id);
			
			return dealQueryResult(result, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return dealException(2000, "失败！！！", e);
		}
	}

}
