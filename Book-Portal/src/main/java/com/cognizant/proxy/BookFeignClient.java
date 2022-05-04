package com.cognizant.proxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.bean.Book;


@FeignClient(name = "inventory-ms", url="http://localhost:8082/inv-ms")
public interface BookFeignClient {

	@GetMapping("/book")
	public List<Book> getAllBooks();
	
	@GetMapping("/book/searchBookById/{bookid}")
	public Book getBookById(@PathVariable int bookid);
	

	@GetMapping("/book/searchBookByName/{searchBook}")
	public List<Book>searchBookByname(@PathVariable String searchBook);
	

	
	@DeleteMapping("/book/delete/{id}")
	public boolean deleteBook(@PathVariable int id);
	
	@PostMapping("/book/update")
	public boolean updateBook(@RequestBody @Valid Book book);
	
	@PostMapping("/book/add")
	public boolean addBook(@RequestBody @Valid  Book book);
	
//	@PutMapping("/book/update")
//	public boolean updateBook(@RequestHeader("Authorization") String token,@RequestBody @Valid Book book);
//	
//	@PostMapping("/book/add")
//	public boolean addBook(@RequestHeader("Authorization") String token,@RequestBody @Valid  Book book);
//	
//	@GetMapping("book/searchBookByName/{searchBook}")
//	public ResponseEntity<List<Book>>searchBookByname(@PathVariable String searchBook);
//	
//	@DeleteMapping("book/delete/{bookId}")
//	public boolean deleteBook(@RequestHeader("Authorization") String token,@PathVariable int id);
}
