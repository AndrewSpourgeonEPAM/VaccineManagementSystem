package com.epam.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.AdminDto;
import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
     
	@Autowired
	UserMapper userMapper;

	@GetMapping
	public ModelAndView getUserDetails() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Registration");
		modelAndView.addObject("title","=======REGISTARTION======");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView checksUser(@Valid @ModelAttribute UserDto userDto,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			modelAndView.setViewName("Registration");
			modelAndView.addObject("title","=======REGISTARTION======");	
		}
		else {
			
		
			if(userMapper.getAdhaarList().contains(userDto.getAadhaarNumber()) || userMapper.getUserList().contains(userDto.getUsername())) {
				
				modelAndView.setViewName("Registration");
				modelAndView.addObject("title","=======REGISTARTION======");
				modelAndView.addObject("message","User Already Exists");
				
			
			}
			else {
		    userMapper.addUser(userDto);
			modelAndView.setViewName("UserLogin");
			modelAndView.addObject("title","=======LOGIN PAGE======");
		
			}
		}
		return modelAndView;	
	}
}
