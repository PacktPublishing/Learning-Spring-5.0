package com.packt.ch06.controllers;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch06.beans.Hobby;
import com.packt.ch06.beans.Person;

@Controller
public class AddAttributeController {
	
	@ModelAttribute("hobbies")
	public List<Hobby> addAttribute() {
         List<Hobby> hobbies=new ArrayList<Hobby>();
          hobbies.add(new Hobby("reading",1));
          hobbies.add(new Hobby("swimming",2));
          hobbies.add(new Hobby("dancing",3));
          hobbies.add(new Hobby("paining",4));
		return hobbies;
	}

	
	@RequestMapping("/showPersonForm.htm")
	public ModelAndView showBookForm(ModelMap map) throws Exception {

		Person person=new Person();
		map.addAttribute("myPerson",person);
		return new ModelAndView("personForm");
	}
	
	@RequestMapping("/addPerson.htm")
	public ModelAndView addBook(@ModelAttribute("myPerson") Person person)
			throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");

		return modelAndView;
	}



}
