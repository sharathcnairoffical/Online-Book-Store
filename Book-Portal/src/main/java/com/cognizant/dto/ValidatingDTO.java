package com.cognizant.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class ValidatingDTO {
	 @JsonProperty
	    private boolean validStatus;
}
