package com.epam.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.VaccineDto;
import com.epam.mapper.VaccineMapper;

@Controller
public class VaccineDetailsController {
	
	@Autowired
	VaccineMapper vaccineMapper;
	
	@RequestMapping("/vaccinedata")
	public ModelAndView getVaccineDetails() {
	    List<VaccineDto> vaccineData=vaccineMapper.getVaccineList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("vaccineData",vaccineData);
		modelAndView.setViewName("VaccineData");
		return modelAndView;
	}

}
