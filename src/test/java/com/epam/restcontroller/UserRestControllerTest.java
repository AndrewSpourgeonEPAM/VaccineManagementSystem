package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.epam.dto.UserDto;
import com.epam.dto.VaccineDto;
import com.epam.mapper.UserMapper;
import com.epam.service.AuthenticateUser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {
	

	@Autowired
	MockMvc mockMvc;
	@MockBean
	UserMapper userMapper;
	@MockBean
	AuthenticateUser authenticateUser;
	
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
	void testChecksUser() throws JsonProcessingException, Exception {
		UserDto userDto = new UserDto();
		userDto.setUsername("Taylor");
		userDto.setPassword("Marie");
		when(authenticateUser.authenticateUser(any())).thenReturn(1);
		MvcResult mvcResult=mockMvc.perform(post("/user_login").contentType(MediaType.APPLICATION_JSON_VALUE).content(convertToJson(userDto))).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		assertEquals("WELCOME Taylor",content);
	}
	
	@Test
	void testgetUser() throws Exception {
		UserDto userDto=new UserDto();
		userDto.setUsername("Brooke");
		userDto.setPassword("Marie");
		when(userMapper.getUser(anyString())).thenReturn(userDto);
		MvcResult mvcResult=mockMvc.perform(get("/user_login/user_profile/Brooke").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();
		String content=mvcResult.getResponse().getContentAsString();

		  UserDto temp = mapFromJson(content, UserDto.class);
		  assertEquals("Marie",temp.getPassword());
		 
		 int status = mvcResult.getResponse().getStatus();
		 assertEquals(200, status);
	}
	
	@Test
	void testDeletesUser() throws Exception {
		doNothing().when(userMapper).deleteUser(anyString());
		MvcResult mvcResult=mockMvc.perform(delete("/user_login/delete_user/Brooke").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		 assertEquals("User accounr with id "+"Brooke"+" deleted successfulyy",content);
	}

}
