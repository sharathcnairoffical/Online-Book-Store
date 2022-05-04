package com.cognizant.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class AuthenticationResponseDTO {
	@JsonProperty
    private String username;
    @JsonProperty
    private String jwtAuthToken;
    @JsonProperty
    private String role;

}
