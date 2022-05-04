package com.placeorder.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placeorder.FeignClient.AuthenticationFeignClient;
import com.placeorder.controller.PlaceOrderController;
import com.placeorder.dto.PlaceOrderRequestDto;
import com.placeorder.dto.PlaceOrderResponseDto;
import com.placeorder.dto.ValidatingDTO;
import com.placeorder.model.AuthenticationResponse;
import com.placeorder.service.PlaceorderService;

@RunWith(SpringRunner.class)
@WebMvcTest(PlaceOrderController.class)
public class PlaceOrderControllerTest {

	@MockBean
	private PlaceorderService orderService;
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private AuthenticationFeignClient authenticationFeignClient;
	
	@Test
	public void contextLoads() {

	}
	
	@BeforeEach()
	public void setUp() {
		when(authenticationFeignClient.getsValidity("user1")).thenReturn(new ValidatingDTO(true));
	}
	
	@Test
	public void testAddProductToCart() throws Exception {
		PlaceOrderRequestDto placeOrderRequestDto = new PlaceOrderRequestDto("Cust101",101,5);
		when(orderService.addToOrders(placeOrderRequestDto)).thenReturn("Successfully added to Cart");
		MvcResult mvcResult = mock.perform(post("/order/placeorder").header("Authorization", "user1")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonString(placeOrderRequestDto))).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	void testViewOrder() throws Exception {
		List<PlaceOrderResponseDto> orderlist = new ArrayList<PlaceOrderResponseDto>();	
		when(orderService.getAllOrders("Cust101")).thenReturn(orderlist);
		MvcResult mvcResult = mock.perform(get("/order/{userId}/", "Cust101")
				.header("Authorization", "user1")).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());	
	}
	
	
	
	public static String convertObjectToJsonString(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}