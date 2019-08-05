package com.school.service.book.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.school.dao.BookMapper;
import com.school.pojo.Book;
import com.school.pojo.BookExample;
import com.school.service.book.BookService;


@Service("bookService")
@Transactional(rollbackFor=Exception.class)
public class BookServiceImpl    implements BookService {
	
	@Resource
	private BookMapper bookMapper;

	public Book findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return bookMapper.selectByPrimaryKey(id);
	}

	public List<Book> findAllBooks() throws Exception {
		// TODO Auto-generated method stub
	BookExample example =new BookExample();
		
		example.setOrderByClause("id desc");
		return bookMapper.selectByExample(example);
	}

	public int addBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		return bookMapper.insert(book);
	}

	public int modifyBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		return bookMapper.updateByPrimaryKeySelective(book);
	}

	public int delBook(int id) throws Exception {
		// TODO Auto-generated method stub
		return bookMapper.deleteByPrimaryKey(id);
	}
	

	


	
	
	

}
