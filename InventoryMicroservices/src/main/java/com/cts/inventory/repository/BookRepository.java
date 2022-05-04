package com.cts.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.inventory.model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query(value="from Book b where b.book_title=?1")
	public List<Book> searchBooksByBookName(String searchBook);
	
	
}
