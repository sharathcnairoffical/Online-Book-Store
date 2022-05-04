package com.placeorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placeorder.Exception.BookNotFoundException;
import com.placeorder.Exception.InvalidTokenException;
import com.placeorder.FeignClient.AuthenticationFeignClient;
import com.placeorder.dto.PlaceOrderRequestDto;
import com.placeorder.dto.PlaceOrderResponseDto;
import com.placeorder.model.Placeorder;
import com.placeorder.service.PlaceorderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/order")
public class PlaceOrderController {

	@Autowired
	private PlaceorderService placeorderService;
	
	@Autowired
	private AuthenticationFeignClient authFeignClient;
	
	
//	@PostMapping("/placeorder")
//	public String placeOrder(@RequestHeader(name = "Authorization") String token,
//			@RequestBody PlaceOrderRequestDto placeOrderRequestDto) throws InvalidTokenException  {
//		log.info("Add product to cart service started");
//		if (!authFeignClient.getsValidity(token).isValidStatus()) {
//			log.info("Book added for Order");
//			return placeorderService.addToOrders(placeOrderRequestDto);
//		}else {
//			throw new InvalidTokenException("You are not Logged In!!!");
//		}
//	}
//
//	
//	@GetMapping("/{userId}")
//	public List<PlaceOrderResponseDto> viewOrder(@RequestHeader(name = "Authorization") String token,
//			@PathVariable String userId) throws  BookNotFoundException, InvalidTokenException{
//		System.out.println(authFeignClient.getsValidity(token).isValidStatus());
//		
//		if (!authFeignClient.getsValidity(token).isValidStatus()) {
//			log.info("Fetch All Book Orders");
//			return placeorderService.getAllOrders(userId);
//		}else {
//			throw new InvalidTokenException("You are not Logged In!!!");
//		}
//	}
//	
	@PostMapping("/placeorder")
	public String placeOrder(
			@RequestBody PlaceOrderRequestDto placeOrderRequestDto) throws InvalidTokenException  {
			log.info("Add product to cart service started");
			return placeorderService.addToOrders(placeOrderRequestDto);
	}
	
	
	@GetMapping("/{userId}")
	public List<PlaceOrderResponseDto> viewOrder(
			@PathVariable String userId) throws  BookNotFoundException, InvalidTokenException{
			log.info("Inside Controller");
			return placeorderService.getAllOrders(userId);
		
	}
	
	@GetMapping("/orderdetails")
	public List<Placeorder> getOrderDetailsAdmin(){
		log.info("Inside Controller layer for Admin Order details");
		return placeorderService.getOrderDetailsAdmin() ;
		
	}
	
	@DeleteMapping("/{userId}/{bookId}")
	public String deleteFromOrder(@PathVariable String userId,
			@PathVariable int bookId) throws InvalidTokenException {
		log.info("delete cart service started");
//		if (authFeignClient.getsValidity(token) != null) {
			log.info("delete cart service by customer id and product id executed successfuly");
			return placeorderService.removeOrder(userId, bookId);
//		}else {
//			throw new InvalidTokenException("You are not Logged In!!!");
//		}
}
}