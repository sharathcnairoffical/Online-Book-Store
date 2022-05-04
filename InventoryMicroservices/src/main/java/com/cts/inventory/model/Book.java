package com.cts.inventory.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Table(name="book")
@SecondaryTable(name="book_details")
public class Book implements Serializable{	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid") ---system generated auto ids
    @Column(updatable = false, nullable = false)
	private int book_id;
	
	
	@NotNull
	private String book_title;
	
	private String book_image;
	
	
	@NotNull
	@Column(table = "book_details")
	private int price;
	
	@NotNull
	@Column(table = "book_details")
	private String author;
	@Column(table = "book_details")
	private String summary;
	@Column(table = "book_details")
	private String category;
	@NotNull
	
	private int stockcount;
	
	@Column(name = "createdDate",table = "book_details")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate created_Date;
	@Column(name = "modifyDate",table = "book_details")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate modify_Date;
	@Column(name = "createdBy",table = "book_details")
	private String created_By;
	@Column(name="modifyBy",table = "book_details")
	private String modify_By;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate modifyDate;
	
	private String createdBy;
	private String modifyBy;
	
	public Book(int book_id,  String book_title, String book_image,  int price,
			 String author, String summary, String category,  int stockcount, LocalDate createdDate,
			LocalDate modifyDate, String createdBy, String modifyBy) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_image = book_image;
		this.price = price;
		this.author = author;
		this.summary = summary;
		this.category = category;
		this.stockcount = stockcount;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.createdBy = createdBy;
		this.modifyBy = modifyBy;
	}

	public Book(@NotNull String book_title, String book_image, @NotNull int price, @NotNull String author,
			String summary, String category, @NotNull int stockcount, LocalDate createdDate, LocalDate modifyDate,
			String createdBy, String modifyBy) {
		super();
		this.book_title = book_title;
		this.book_image = book_image;
		this.price = price;
		this.author = author;
		this.summary = summary;
		this.category = category;
		this.stockcount = stockcount;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.createdBy = createdBy;
		this.modifyBy = modifyBy;
	}
	
	
	
}
