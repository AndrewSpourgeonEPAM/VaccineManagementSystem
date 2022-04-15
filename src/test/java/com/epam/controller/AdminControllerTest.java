package com.epam.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.epam.dto.AdminDto;
import com.epam.service.AuthenticateAdmin;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
	
	@MockBean
	AuthenticateAdmin authenticateAdmin;
	
	@Autowired
	private MockMvc mockMvc;
	

	@Test
	void testgetAdminDetails() throws Exception {
		mockMvc.perform(get("/adminlogin")).andExpect(view().name("AdminLogin"));
	}
	
	@Test
	public void testchecksAdmin() throws Exception {
		AdminDto adminDto = new AdminDto();
		verify(authenticateAdmin,times(0)).checkAdmin(adminDto);
	}

}
