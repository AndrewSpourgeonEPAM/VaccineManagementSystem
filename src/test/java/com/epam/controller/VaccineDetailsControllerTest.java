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
import com.epam.dto.AdminDto;
import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;
import com.epam.service.AuthenticateAdmin;

@SpringBootTest
@AutoConfigureMockMvc
public class VaccineDetailsControllerTest {
	
	@MockBean
	VaccineMapper vaccineMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
//	@MockBean
//	BindingResult bindingResult;

	@Test
	public void testgetVaccineDetails() throws Exception {
		
		VaccineDto vaccineDto1=new VaccineDto();
		vaccineDto1.setLocation("Chennai");
		vaccineDto1.setVaccineCount(20);
		VaccineDto vaccineDto2=new VaccineDto(); 
		vaccineDto2.setLocation("Pune");
		vaccineDto2.setVaccineCount(30);
		
		List<VaccineDto> vaccineList=new ArrayList<>();
		vaccineList.add(vaccineDto2);
		vaccineList.add(vaccineDto1);
	
		given(vaccineMapper.getVaccineList()).willReturn(vaccineList);
		mockMvc.perform(get("/vaccinedata")).andExpect(view().name("VaccineData"))
		.andExpect(model().attribute("vaccineData",hasSize(2)))
		.andExpect(model().attribute("vaccineData",hasItem(allOf(hasProperty("location",is("Chennai")),hasProperty("vaccineCount",is(20))))));
	}

}
