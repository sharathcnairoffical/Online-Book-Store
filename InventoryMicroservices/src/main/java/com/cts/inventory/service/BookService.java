package com.cts.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cts.inventory.exception.AccessDeniedException;
import com.cts.inventory.exception.BookAlreadyExistException;
import com.cts.inventory.exception.BookNotFoundException;
//import com.cts.inventory.feignclient.AuthenticationFeignClient;
//import com.cts.inventory.model.AuthenticationResponse;
import com.cts.inventory.model.Book;
//import com.cts.inventory.model.BookDetails;
//import com.cts.inventory.repository.BookDetailsRepository;
import com.cts.inventory.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;

@Slf4j
@Service
public class BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CacheManager cacheManager;
	



	public Boolean addBook(Book book) throws BookAlreadyExistException {
		Book checkbook =bookRepository.findById(book.getBook_id()).orElse(null); /// findByname
		if(checkbook == null) {
			//date is needed to be saved!
			book.setCreatedDate(LocalDate.now());
			bookRepository.saveAndFlush(book);
			log.info("Book Added Succesfully!");
			clearCache("AllBooks");
			return true;
		}else {
			log.info("Book Already Exist");
			throw new BookAlreadyExistException("Book with" + book.getBook_title()+ "already present");
		}		
	}

	@Transactional
	public Boolean updateBook(int bookId,Book book) throws BookNotFoundException { //,String key
		boolean returnVal = false;
		Book bookexist=bookRepository.findById(bookId).orElse(null);
		if(bookexist !=null) {
			
			book.setModifyDate(LocalDate.now());
			book.setModify_Date(LocalDate.now());
			bookRepository.save(book);
			clearCache("AllBooks");

				
			returnVal = true;	
		}else {
			log.info("Book Not Found!");
			throw new BookNotFoundException("Book Not Found");
		}
		return returnVal;
	}

	@Cacheable(value="BookCache", key = "#key")
	public List<Book> getAllBook(String key) { //fetch all books  String key
		log.info("Retreiving all Books");
		List<Book> books=new ArrayList<Book>();
		System.out.println("Inside Book Service Db called!");
		books.addAll(bookRepository.findAll());
		return books;
	}
	

	
	
	public Book getBookById(int bookId) throws BookNotFoundException {
		Book book =bookRepository.findById(bookId).orElse(null);
		if(book !=null) {
			log.info("Returning Book");
			return book;
		}
		else {
			throw new BookNotFoundException("Book Not Found");
		}
	}


	@Transactional
	public boolean deleteBook(int bookId) throws BookNotFoundException { //admin  ,String key

			bookRepository.deleteById(bookId);
			log.info("Book Deleted Successfully!");
			clearCache("AllBooks");
			
			return true;

	}
	
	
	@Cacheable(value="BookCache", key = "#searchBook")
	public List<Book> searchBooksbyname(String searchBook) throws BookNotFoundException { //response-book and bookdetails
		List<Book> books=bookRepository.searchBooksByBookName(searchBook);
		if(books.size()==0) {
			log.info("Book with"+searchBook+"not found");
			throw new BookNotFoundException("Book not found");
		}else {
			log.info("Book with bookname:{}",books);
			return books;
		}
		
		
	}
	 public void clearCache(String key){
	        System.out.println("Inside BookService refreshCache");
	        CacheManager.getInstance().getEhcache("BookCache").remove(key);
	    }

	
}