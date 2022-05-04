package com.cognizant.dto;

import com.cognizant.bean.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderResponseDto {

	private long order_id;
	private String user_id;
	
	private Book book;
	private int quantity;
}
