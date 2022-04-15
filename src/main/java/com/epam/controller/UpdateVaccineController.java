package com.epam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AdminDto;
import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;

@Controller
@RequestMapping("/updatevaccinedata")
public class UpdateVaccineController {
	
	@Autowired
	VaccineMapper vaccineMapper;
	
	@GetMapping
	public ModelAndView getDetails() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateVaccineData");
		modelAndView.addObject("title","=======UPDATE VACCINE DATA======");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView updatesVaccine(@Valid @ModelAttribute VaccineDto vaccineDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			
			modelAndView.setViewName("UpdateVaccineData");
			modelAndView.addObject("title","=======UPDATE VACCINE DATA======");
		
		}
		else {
		    vaccineMapper.updateVaccineCount(vaccineDto);
			
			modelAndView.setViewName("AdminDashboard");
			modelAndView.addObject("title","=======ADMIN DASHBOARD======");
		
			
		}
		return modelAndView;
		
	}
	

}
