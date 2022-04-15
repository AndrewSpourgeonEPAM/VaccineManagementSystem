package com.epam.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class VaccineRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	VaccineMapper vaccineMapper;
	
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
	void testgetVaccineData() throws Exception {
		List<VaccineDto> locationslist=new ArrayList<VaccineDto> ();
		VaccineDto vd=new VaccineDto();
		vd.setLocation("Chennai");
		vd.setVaccineCount(25);
		locationslist.add(vd);
		when(vaccineMapper.getVaccineList()).thenReturn(locationslist);   
		
		MvcResult mvcResult=mockMvc.perform(get("/vaccinesdata").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		List<VaccineDto> temp = mapFromJson(content, ArrayList.class);
		assertEquals(1,temp.size());
	}
	
	@Test
	void testgetVaccineDetails() throws Exception {
		VaccineDto vd=new VaccineDto();
		vd.setLocation("Chennai");
		vd.setVaccineCount(25);
		
		when(vaccineMapper.getVaccineDto(anyString())).thenReturn(vd);   
		
		MvcResult mvcResult=mockMvc.perform(get("/vaccinesdata/Chennai").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		VaccineDto temp = mapFromJson(content, VaccineDto.class);
		assertEquals(25,temp.getVaccineCount());
	}

	@Test
	void testgetLocations() throws Exception {
		List<String> locationslist=new ArrayList<String> ();
		locationslist.add("Chennai");
		locationslist.add("Vizag");
		when(vaccineMapper.getVaccineLocations()).thenReturn(locationslist);   
		
		MvcResult mvcResult=mockMvc.perform(get("/vaccinesdata/locations").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		List<String> temp = mapFromJson(content, ArrayList.class);
		assertEquals(2,temp.size());
	}
	@Test
	void testInsertsVaccineData() throws Exception {
		VaccineDto vd=new VaccineDto();
		vd.setLocation("Guntur");
		vd.setVaccineCount(45);
		
		when(vaccineMapper.updateVaccineCount(any())).thenReturn(vd);   
		
		MvcResult mvcResult=mockMvc.perform(post("/vaccinesdata/updatedata").contentType(MediaType.APPLICATION_JSON_VALUE).content(convertToJson(vd))).andReturn();
		String content=mvcResult.getResponse().getContentAsString();
		VaccineDto temp = mapFromJson(content, VaccineDto.class);
		assertEquals(45,temp.getVaccineCount());
	}
	
}
