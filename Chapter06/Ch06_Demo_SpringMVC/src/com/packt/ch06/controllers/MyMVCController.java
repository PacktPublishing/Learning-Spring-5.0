package com.packt.ch06.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyMVCController {
	@RequestMapping(value="welcomeController.htm",method=RequestMethod.GET)
	public ModelAndView welcome()
	{
		String welcome_message="Welcome to the wonderful world of Books!!!";
		return new ModelAndView("welcome","message",welcome_message);
	}
}
