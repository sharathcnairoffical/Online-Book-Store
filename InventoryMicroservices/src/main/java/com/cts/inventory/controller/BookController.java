package com.cts.inventory.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.inventory.exception.BookAlreadyExistException;
import com.cts.inventory.exception.BookNotFoundException;
import com.cts.inventory.model.Book;
//import com.cts.inventory.model.BookDetails;
import com.cts.inventory.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBook("AllBooks");
		
	}


	
	@PostMapping("/add")
	public boolean addBook(@RequestBody @Valid  Book book) throws BookAlreadyExistException {
				return bookService.addBook(book);
	}
	
	@PostMapping("/update")
	public boolean updateBook(@RequestBody @Valid Book book) throws BookNotFoundException {
		return bookService.updateBook(book.getBook_id(),book);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public boolean deleteBook(@PathVariable int bookId) throws BookNotFoundException {
		log.info("Inside Controller");
		return bookService.deleteBook(bookId);
	}

	
	@GetMapping("/searchBookByName/{searchBook}")
	public List<Book> searchBookByname(@PathVariable String searchBook) throws BookNotFoundException{
		List<Book> bookList = bookService.searchBooksbyname(searchBook);
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Book Not Found");
		}
		return bookList;
	}
	

	
	@GetMapping("/searchBookById/{bookId}")
	public Book getBookById(@PathVariable int bookId) throws BookNotFoundException{
		Book book=bookService.getBookById(bookId);
		if(book!=null) {
			return book;
		}else {
			throw new BookNotFoundException("Book Not Found");
		}
		//return book;
	}
	

}
