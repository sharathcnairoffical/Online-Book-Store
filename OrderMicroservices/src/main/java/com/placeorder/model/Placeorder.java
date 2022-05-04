package com.placeorder.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="placeorder")
@Entity
public class Placeorder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long porder_id;
	
	@NotNull
	private int book_id;
	
	@NotNull
	private String userid;
	
	@Column
	private int quantity;
	
	
	private long total_price;
	
	
	
	public Placeorder(String userid,int book_id, int quantity) {
		super();
		this.userid=userid;
		this.book_id = book_id;
		this.quantity = quantity;
	}
}
