package com.placeorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {


	private String userid;
	private String name;
	private boolean isValid;
}
