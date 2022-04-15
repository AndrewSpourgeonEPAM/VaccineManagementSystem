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

import com.epam.dto.UserDto;
import com.epam.service.AuthenticateUser;

@Controller
@RequestMapping("/userlogin")
public class UserController {
	
	public static String username;
	
	@Autowired
	AuthenticateUser authenticateUser;
	
	@GetMapping
	public ModelAndView getUserDetails() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserLogin");
		modelAndView.addObject("title","=======LOGIN PAGE======");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView checksUser(@Valid @ModelAttribute UserDto userDto,BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView();
		if(!result.hasErrors()) {
			int res=authenticateUser.authenticateUser(userDto);
			if(res==1) {
			username=userDto.getUsername();
		
			modelAndView.setViewName("UserDashboard");
			modelAndView.addObject("title","=======USER DASHBOARD======");
			}
			else {
				
				modelAndView.setViewName("UserLogin");
				modelAndView.addObject("title","=======LOGIN PAGE======");
				modelAndView.addObject("message","Invalid Password");
			
			}
		}
		else {
		
			modelAndView.setViewName("UserLogin");
			modelAndView.addObject("title","=======LOGIN PAGE======");
			
		}
		return modelAndView;
	}
}
