package com.placeorder.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placeorder.Exception.BookNotFoundException;
import com.placeorder.FeignClient.InventoryFeign;
import com.placeorder.dto.PlaceOrderRequestDto;
import com.placeorder.dto.PlaceOrderResponseDto;
import com.placeorder.model.Book;
import com.placeorder.model.Placeorder;
import com.placeorder.repository.PlaceorderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlaceorderService {

	@Autowired
	PlaceorderRepository placeorderRepository;
	
	@Autowired
	InventoryFeign inventoryFeign;
	
	
	public String addToOrders(PlaceOrderRequestDto placeOrderRequestDto) {
		// TODO Auto-generated method stub
		Placeorder orderExists = placeorderRepository.exists(placeOrderRequestDto.getUser_id(),placeOrderRequestDto.getBook_id());
		if(orderExists !=null) {
			orderExists.setQuantity(orderExists.getQuantity()+placeOrderRequestDto.getQuantity());
			placeorderRepository.saveAndFlush(orderExists);
			log.info("Order Successfully placed ");
			return "Order Successfully placed ";
		}
		Placeorder newOrder= new Placeorder(placeOrderRequestDto.getUser_id(),placeOrderRequestDto.getBook_id(),placeOrderRequestDto.getQuantity());
		placeorderRepository.saveAndFlush(newOrder);
		return "Order Successfully placed";
		
		
	}

	public List<Placeorder> getOrderDetailsAdmin(){
		log.info("Inside Placeorder service layer ");
		return placeorderRepository.findAll();
		
	}
	
	public List<PlaceOrderResponseDto> getAllOrders(String userId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		List<PlaceOrderResponseDto> orderResponseList=new ArrayList<>();
		List<Placeorder> orderList=placeorderRepository.findByUserId(userId);
		for(Placeorder placeorder: orderList) {
			Book book= inventoryFeign.getBookById(placeorder.getBook_id());
			orderResponseList.add(new PlaceOrderResponseDto(placeorder.getPorder_id(),placeorder.getUserid(),book,placeorder.getQuantity()));
		}
		return orderResponseList;
	}

	
	public String removeOrder(String userId,int bookId) {
		log.info("get customer wishlist method started execution");
		Placeorder orderExists = placeorderRepository.exists(userId, bookId);
		placeorderRepository.deleteById(orderExists.getPorder_id());
		return "Book removed from Order";
	}

	
}
