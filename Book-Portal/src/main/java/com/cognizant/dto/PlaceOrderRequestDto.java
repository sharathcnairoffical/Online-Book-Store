package com.cognizant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequestDto {

	
	private String user_id;
	 
	private int book_id;
	
	private int quantity;
}
