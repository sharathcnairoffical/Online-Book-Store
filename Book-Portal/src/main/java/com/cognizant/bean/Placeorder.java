package com.cognizant.bean;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Placeorder {
	
	
	private long porder_id;
	
	@NotNull
	private int book_id;
	
	@NotNull
	private String userid;
	
	
	private int quantity;
	
	
	private long total_price;
	
	
	
	public Placeorder(String userid,int book_id, int quantity) {
		super();
		this.userid=userid;
		this.book_id = book_id;
		this.quantity = quantity;
	}
}
