package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserMapper userMapper;
	
	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException
	{
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(json, clazz);
	}
	
	protected String convertToJson(Object obj) throws JsonProcessingException
	{
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(obj);
	}
	
	@Test
	void testRegisterUser() throws JsonProcessingException, Exception {
		UserDto userDto = new UserDto();
		userDto.setUsername("Me");
		userDto.setPassword("you");
		userDto.setAadhaarNumber("000000009999");
		when(userMapper.addUser(any())).thenReturn(userDto); 
		MvcResult mvcResult=mockMvc.perform(put("/register_user").contentType(MediaType.APPLICATION_JSON_VALUE).content(convertToJson(userDto))).andReturn();
		  String content=mvcResult.getResponse().getContentAsString();
		  UserDto temp = mapFromJson(content, UserDto.class);
		  assertEquals("Me",temp.getUsername());
	}

}
