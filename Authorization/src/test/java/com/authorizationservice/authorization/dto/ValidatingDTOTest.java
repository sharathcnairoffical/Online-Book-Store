package com.authorizationservice.authorization.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidatingDTOTest {

	VaildatingDTO validatingDTO= new VaildatingDTO();
	
	@Test
    @DisplayName("Checking if [ValidatingDTO] is loading or not.")
    void ValidatingDTOIsLoaded(){
        assertThat(validatingDTO).isNotNull();    
    }
	
	@Test
	 void testPackagingAndDeliveryPositive() {
		validatingDTO = new VaildatingDTO(true);
		validatingDTO.setValidStatus(true);
		assertEquals(true,validatingDTO.isValidStatus());
		assertFalse(validatingDTO.toString().isEmpty());
		
	}

	@Test
	 void testPackagingAndDeliveryNegative() {
		validatingDTO = new VaildatingDTO(true);
		validatingDTO.setValidStatus(true);
		assertNotEquals(false,validatingDTO.isValidStatus());
		assertFalse(validatingDTO.toString().isEmpty());
	}
}
