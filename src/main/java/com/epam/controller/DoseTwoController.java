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
import com.epam.dto.VaccineDto;
import com.epam.mapper.UserMapper;
import com.epam.mapper.VaccineMapper;
import com.epam.service.Builder.UserBuilder;

@Controller
@RequestMapping("/bookdosetwo")
public class DoseTwoController {
	@Autowired
	UserMapper userMapper;
	@Autowired
	VaccineMapper vaccineMapper;
	@Autowired
	UserBuilder userBuilder;
	@GetMapping
	public ModelAndView getDosetwoDetails() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("BookDoseTwo");
		modelAndView.addObject("title","=======DOSE ONE BOOKING======");
		return modelAndView;
	}
	
	
	@PostMapping
	public ModelAndView updateUserDetails(UserDto userDto) {
		ModelAndView modelAndView = new ModelAndView();
		boolean isValid=userBuilder.isValidLocation(userDto.getSecondDoseLocation());
		UserDto dto1=userMapper.getUser(UserController.username);
		if(isValid && dto1.isBookedFirstDose() && !dto1.isBookedSecondDose() && userBuilder.setSecondDoseDate(userDto.getSecondDoseDate(),UserController.username)) {
	        UserDto dto=userMapper.getUser(UserController.username);
		    dto.setSecondDoseDate(userDto.getSecondDoseDate());
		    dto.setSecondDoseLocation(userDto.getSecondDoseLocation());
		    dto.setBookedSecondDose(true);
		    userMapper.updateUser(dto);
		    VaccineDto vaccineDto=vaccineMapper.getVaccineDto(userDto.getSecondDoseLocation());
		    vaccineDto.setLocation(userDto.getSecondDoseLocation());
		    vaccineDto.setVaccineCount(vaccineDto.getVaccineCount()-1);
		    vaccineMapper.updateVaccineCount(vaccineDto);
			modelAndView.setViewName("UserDashboard");
			modelAndView.addObject("title","=======USER DASHBOARD======");
		}
		else {
			modelAndView.setViewName("BookDoseTwo");
			modelAndView.addObject("title","=======DOSE ONE BOOKING======");
			modelAndView.addObject("message","Sorry! Booking failed");
		}
		return modelAndView;
	}
	
}
