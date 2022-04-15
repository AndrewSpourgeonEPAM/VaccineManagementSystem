package com.epam.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;





@SpringBootTest
@AutoConfigureMockMvc
public class UserDashboardControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@Test
	void testuserProfile() throws Exception {
		//mockMvc.perform(get("/userprofile")).andExpect(view().name("UserProfile"));
	}
	
	@Test
	public void testdeletesUser() throws Exception {
		//mockMvc.perform(get("/deleteuser")).andExpect(view().name("Dashboard"));
	}

}

