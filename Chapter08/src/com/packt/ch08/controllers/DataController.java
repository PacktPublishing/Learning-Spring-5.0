package com.packt.ch08.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch08.service.SecurityService;

@Controller
public class DataController {

	@Autowired
	SecurityService securityService;

	@RequestMapping("/add.htm")
	public ModelAndView add() {
		return new ModelAndView("home", "message", securityService.message());
	}

	@RequestMapping("/welcome.htm")
	public ModelAndView welcome() {
		return new ModelAndView("home", "message", "Welcome to the Spring security application");
	}

	@RequestMapping("/data.htm")
	public ModelAndView show() {
		return new ModelAndView("data", "message", "CLICK THE LINKS TO READ THE data !!!!");
	}

	@RequestMapping("/mylogin.htm")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/error.htm")
	public ModelAndView login_fail() {
		return new ModelAndView("login", "error", "please provide correct credentials");
	}

}
