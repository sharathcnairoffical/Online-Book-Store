package com.cts.inventory.dto;

import java.util.List;

import com.cts.inventory.model.Book;
//import com.cts.inventory.model.BookDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

	private List<Book> book;
	
	//private List<BookDetails> bookDetails;
}
