package com.school.service.book;

import java.util.List;


import com.school.pojo.Book;

public interface BookService {
	
	Book findById(int id)  throws Exception;
	
	List<Book>  findAllBooks()  throws Exception;
	
	int addBook(Book book)  throws Exception;
	
	int modifyBook(Book book)  throws Exception;
	
	int delBook(int id)  throws Exception;
	
}
