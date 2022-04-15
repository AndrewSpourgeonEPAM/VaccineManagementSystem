package com.epam.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.epam.exception.LocationNotFoundException;
import com.epam.exception.UserNotFoundException;

@ControllerAdvice
public class MVCExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(Exception exception) {
		
		ModelAndView mv = new ModelAndView();
	mv.addObject("message", exception.getMessage());
		mv.setViewName("UserError");
		return mv;
	}
	
	@ExceptionHandler(value = LocationNotFoundException.class)
	public ModelAndView handleLocationNotFoundException(Exception exception) {
		ModelAndView mv = new ModelAndView();
	    mv.addObject("message", exception.getMessage());
		mv.setViewName("UserError");
		return mv;
	}
}