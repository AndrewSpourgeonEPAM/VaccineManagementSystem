package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.epam.dto.UserDto;
import com.epam.service.Builder.UserBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class DoseTwoRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserBuilder userBuilder;
	
	protected String convertToJson(Object obj) throws JsonProcessingException
	{
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(obj);
	}
	
	@Test
	void testupdateUserDetails() throws JsonProcessingException, Exception {
		UserDto userDto=new UserDto();
		userDto.setSecondDoseDate("2022-08-12");
		userDto.setSecondDoseLocation("Chennai");
		when(userBuilder.isValidLocation(anyString())).thenReturn(true);
		when(userBuilder.setSecondDoseDate(anyString(),anyString())).thenReturn(true);
		
		MvcResult mvcResult=mockMvc.perform(post("/book_dose_two/Brooke").contentType(MediaType.APPLICATION_JSON_VALUE).content(convertToJson(userDto))).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		assertEquals("DoseTwo Booked Successfulyy",content);
	}

}

