package com.school.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.school.entity.Book;

public interface BookService {

	List<Book> findBookInfos();

	List<Book> findByLikeName(String name);

	Book findByid(Integer id);

	void addBookInfo(Book book);

	void modifyBookInfo(Book book);

	void delBookInfo(Integer id);

	Page<Book> getPageSort(Integer pageNum, Integer pageLimit);

	Page<Book> findByNameOfAuthor(Book book, Integer pageNum, Integer pageLimit);

	public Map<String, Object> getInfo();
}
