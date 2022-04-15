package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.dto.AdminDto;
import com.epam.service.AuthenticateAdmin;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AdminRestControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AuthenticateAdmin authenticateAdmin;
	
	
	protected String convertToJson(Object obj) throws JsonProcessingException
	{
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(obj);
	}
	
	
	@Test
	void testChecksAdmin() throws Exception {
		AdminDto adminDto=new AdminDto();
		adminDto.setUserId("999900005555");
		adminDto.setPassword("epam@369");
		
		when(authenticateAdmin.checkAdmin(any())).thenReturn(true);  
		MvcResult mvcResult=mockMvc.perform(post("/admin_login").contentType(MediaType.APPLICATION_JSON_VALUE).content(convertToJson(adminDto))).andReturn();
		
		
		
		  String content=mvcResult.getResponse().getContentAsString();
		  assertEquals("WELCOME ADMIN",content);
		 
		 
		 
		
		 int status = mvcResult.getResponse().getStatus();
		 assertEquals(200, status);
		 
	}
	
	

}
