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
import com.epam.mapper.VaccineMapper;
import com.epam.service.AuthenticateAdmin;

@Controller
@RequestMapping("/adminlogin")
public class AdminController {
	
	@Autowired
	AuthenticateAdmin authenticateAdmin;
	
	@Autowired
	VaccineMapper vaccineMapper;
	
	@GetMapping
	public ModelAndView getAdminDetails() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AdminLogin");
		modelAndView.addObject("title","=======ADMIN LOGIN======");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView checksAdmin(@Valid @ModelAttribute AdminDto adminDto,BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		if(!result.hasErrors()) { 
			boolean res=authenticateAdmin.checkAdmin(adminDto);
		if(res) {
			
			modelAndView.setViewName("AdminDashboard");
			modelAndView.addObject("title","=======ADMIN DASHBOARD======");
		
		}
		else {
			
			modelAndView.setViewName("AdminLogin");
			modelAndView.addObject("message","Invalid Credentials");
			
		}
		}
		else {
			
			modelAndView.setViewName("AdminLogin");
			modelAndView.addObject("message","Invalid Credentials");
			
		}
	return modelAndView;
	
	}
}
