package com.school.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.school.entity.Book;
import com.school.repository.BookRepository;
import com.school.service.BookService;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Resource
	private BookRepository bookDao;

	@Override
	public List<Book> findBookInfos() {
		// TODO Auto-generated method stub
		return bookDao.findAll();

	}

	@Override
	public List<Book> findByLikeName(String name) {
		// TODO Auto-generated method stub
		return bookDao.findByName(name);
	}

	@Override
	public Book findByid(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.getOne(id);
	}

	@Override
	public void addBookInfo(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);
	}

	@Override
	public void modifyBookInfo(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);
	}

	@Override
	public void delBookInfo(Integer id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
	}

	@Override
	public Page<Book> getPageSort(Integer pageNum, Integer pageLimit) {
		// TODO Auto-generated method stub

		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(pageNum - 1, pageLimit, sort);
		return bookDao.findAll(pageable);

	}

	@Override
	public Page<Book> findByNameOfAuthor(Book book, Integer pageNum, Integer pageLimit) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(pageNum - 1, pageLimit, sort);
		System.out.println(book.getName() + "========///////////=========" + book.getAuthor());
		return bookDao.findAll(new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> arg1, CriteriaBuilder cb) {
				// TODO Auto-generated method stub

				Predicate predicate = cb.conjunction();

				if (book != null) {

					if (book.getName() != null && !"".equals(book.getName())) {

						predicate.getExpressions().add(cb.like(root.get("name"), "%" + book.getName() + "%"));
					}

					if (book.getAuthor() != null && !"".equals(book.getAuthor())) {

						predicate.getExpressions().add(cb.like(root.get("author"), "%" + book.getAuthor() + "%"));
					}
				}
				return predicate;
			}
		}, pageable);

	}

	@Override
	public Map<String, Object> getInfo() {
		// TODO Auto-generated method stub
		List<Book> booklist = bookDao.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "业务数据1005");
		map.put("data", booklist);

		return map;
	}
}
