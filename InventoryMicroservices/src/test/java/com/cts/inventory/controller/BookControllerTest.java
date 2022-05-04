package com.cts.inventory.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import com.cts.inventory.model.AuthenticationResponse;
import com.cts.inventory.model.Book;
import com.cts.inventory.repository.BookRepository;
import com.cts.inventory.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest({BookController.class})
public class BookControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepo;
	
	static ObjectMapper MAPPER = new ObjectMapper();
	
	@Test
	public void testGetBookByName() throws Exception {
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		Book book = new Book(001,"HalfGirlFriend","image" ,100,"Chetan Bhagat", "couple relationship", "Romance",4,LocalDate.parse("2011-09-01"),LocalDate.parse("2011-09-01"),"Sharath","yash");
		Book book2 = new Book(002, "HalfGirlFriend","image" ,100,"Chetan Bhagat", "couple relationship", "Romance",4,LocalDate.parse("2011-09-01"),LocalDate.parse("2011-09-01"),"Sharath","yash");
		List<Book> bookList = new ArrayList<>();
		bookList.add(book2);
		bookList.add(book);
		doReturn(bookList).when(bookService).searchBooksbyname("HalfGirlFriend");
		mvc.perform(get("/book/searchBookByName/HalfGirlFriend").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
		MvcResult mvcResult = mvc.perform(get("/book/searchBookByName/HalfGirlFriend").header("Authorization", "token")).andReturn();
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("Romance"));
		assertEquals(true, mvcResult.getResponse().getContentAsString().contains("HalfGirlFriend"));
//		.header("Authorization", "token")
	}
	
	

	@Test
	public void testGetBookByNameException() throws Exception {
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		mvc.perform(get("/book/searchBookByName/hello-11").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isNotFound());
//		.header("Authorization", "token")
	}
	
	@Test
	public void testGetBookById() throws Exception {
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		Book book = new Book(001,"HalfGirlFriend","image" ,100,"Chetan Bhagat", "couple relationship", "Romance",4,LocalDate.parse("2011-09-01"),LocalDate.parse("2011-09-01"),"Sharath","yash");
		doReturn(book).when(bookService).getBookById(001);
		mvc.perform(get("/book/searchBookById/{bookId}", 001).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.book_title", is("HalfGirlFriend")));
//		.header("Authorization", "token")
	}
	
	@Test
	public void testGetProductByIdNotPresent() throws Exception {
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		mvc.perform(get("/book/searchBookById/010").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isNotFound());
//		.header("Authorization", "token")
	}
	
	@Test
	public void testGetAllBooks() throws Exception {
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		mvc.perform(get("/book/").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
//		.header("Authorization", "token")
	}
	
	@Test
	public void testAddBook() throws Exception {
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		mvc.perform(post("/book/add").content(convertObjectToJsonString(new Book(001,"HalfGirlFriend","image" ,100,"Chetan Bhagat", "couple relationship", "Romance",4,null,null,"Sharath","yash")))
//				.header("Authorization", "token")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void updateBook() throws   Exception{
//		when(bookService.hasPermission("token")).thenReturn(new AuthenticationResponse("", "", true));
		Book book=new Book(001,"HalfGirlFriend","image" ,200,"Chetan Bhagat", "couple relationship", "Romance",4,null,null,"Sharath","yash");
		mvc.perform(post("/book/update").content(convertObjectToJsonString(book))
//				.header("Authorization", "token")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andReturn();

		
		
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String convertObjectToJsonString(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
