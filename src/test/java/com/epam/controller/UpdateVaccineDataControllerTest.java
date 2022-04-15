package com.epam.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.error.ShouldNotBeEqualIgnoringWhitespace;
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
import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;
import com.epam.service.AuthenticateAdmin;

@SpringBootTest
@AutoConfigureMockMvc
public class UpdateVaccineDataControllerTest {
	
	@MockBean
	VaccineMapper vaccineMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@Test
	void testgetDetails() throws Exception {
		mockMvc.perform(get("/updatevaccinedata")).andExpect(view().name("UpdateVaccineData"));
	}

	@Test
	public void testUpdatesVaccine() throws Exception {
		VaccineDto vaccineDto = new VaccineDto();
		verify(vaccineMapper,times(0)).updateVaccineCount(vaccineDto);
	}

}
