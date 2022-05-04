package com.cognizant.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.dto.PlaceOrderResponseDto;
import com.cognizant.bean.Placeorder;
//import com.placeorder.model.Placeorder;
import com.cognizant.dto.PlaceOrderRequestDto;

//@FeignClient(name = "cart-rest-api",url="http://54.67.94.211:8083")
@FeignClient(name = "cart-rest-api", url = "http://localhost:8083/ord-ms")
public interface OrderFeignClient {

	@PostMapping("/order/placeorder")
	public String placeOrder(@RequestHeader(name = "Authorization") String token,
			@RequestBody PlaceOrderRequestDto placeOrderRequestDto);

	@GetMapping("/order/{userId}")
	public List<PlaceOrderResponseDto> viewOrder(@PathVariable String userId);

	@DeleteMapping("/order/{userId}/{bookId}")
	public String deleteFromOrder(@PathVariable String userId, @PathVariable int bookId);
	
	@GetMapping("/orderdetails")
	public List<Placeorder> getOrderDetailsAdmin();

//
//@DeleteMapping("/order/{userId}/{bookId}")
//public String deleteFromOrder(@RequestHeader(name = "Authorization") String token, @PathVariable String userId,
//		@PathVariable int bookId);

//
//@GetMapping("/order/{userId}")
//public List<PlaceOrderResponseDto> viewOrder(@RequestHeader(name = "Authorization") String token,
//		@PathVariable String userId);

}