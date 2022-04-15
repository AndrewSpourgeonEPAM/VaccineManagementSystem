package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.UserDto;
import com.epam.mapper.UserMapper;

@Controller
public class UserDashboardController {
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("/userprofile")
	public ModelAndView userProfile() {
		UserDto userDto=userMapper.getUser(UserController.username);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserProfile");
		modelAndView.addObject("user",userDto);
		return modelAndView;
		
	}
	@RequestMapping("/deleteuser")
	public ModelAndView deleteUser() {
		userMapper.deleteUser(UserController.username);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Dashboard");
		return modelAndView;
		
	}
	

}
