package com.placeorder.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book")
@SecondaryTable(name="book_details")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
	private int book_id;
	
	
	@NotNull
	private String book_title;
	
	private String book_image;
	
	
	@NotNull
	@Column(table = "book_details")
	private Long price;
	
	@NotNull
	@Column(table = "book_details")
	private String author;
	@Column(table = "book_details")
	private String summary;
	@Column(table = "book_details")
	private String category;
	@NotNull
	
	private int stockcount;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate modifyDate;
	
	private String createdBy;
	private String modifyBy;
}
