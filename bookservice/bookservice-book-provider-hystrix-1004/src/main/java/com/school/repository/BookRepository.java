package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.school.entity.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>,JpaSpecificationExecutor<Book>{

	
	@Query("select t from Book t where t.name like %?1% ")
	public List<Book>  findByName (String name);
	
	
	@Query(value="select *from t_book t order by RAND() limit ?1 ",nativeQuery=true)
	public List<Book>  randomlist (Integer  n);
}
