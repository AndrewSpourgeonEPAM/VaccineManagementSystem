package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.VaccineDto;
import com.epam.factsAPI.FactsAPI;

@Controller
public class FunFactController {

	@Autowired
	FactsAPI factsApi;
	
	@RequestMapping("/funfact")
	public ModelAndView getFacts() {
	    String fact=factsApi.fetchFacts();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("fact",fact);
		modelAndView.setViewName("FunFact");
		return modelAndView;
	}
	
}
