package com.placeorder.FeignClient;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.placeorder.Exception.BookNotFoundException;
import com.placeorder.model.Book;



@FeignClient(name="inventory-ms",url="${feign.url-inventory-microservices}")
public interface InventoryFeign {
	
	@GetMapping("book/searchBookById/{bookId}")
	public Book getBookById(@PathVariable int bookId) throws BookNotFoundException;
	
	@GetMapping("book/books")
	public Set<Book> getAllBooks();
}
