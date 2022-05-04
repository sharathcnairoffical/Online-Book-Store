package com.cognizant.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable{
	
	
	private int book_id;
	
	
	@NotNull
	private String book_title;
	
	private String book_image;
	
	
	@NotNull
	private int price;
	
	@NotNull
	private String author;
	
	private String summary;
	
	private String category;
	
	@NotNull
	private int stockcount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate created_Date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate modify_Date;

	private String created_By;

	private String modify_By;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate modifyDate;
	
	private String createdBy;
	private String modifyBy;
	
}
