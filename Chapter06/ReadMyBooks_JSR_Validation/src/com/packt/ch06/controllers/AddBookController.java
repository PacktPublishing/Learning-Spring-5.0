package com.packt.ch06.controllers;

//hibernate -api
//jboss
//classmate

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch06.beans.Book;

@Controller
public class AddBookController {

	@ModelAttribute("priceList")
	public List<Integer> addPrices() {

		List<Integer> prices=new ArrayList<Integer>();
		prices.add(300);
		prices.add(350);
		prices.add(400);
		prices.add(500);
		prices.add(550);
		prices.add(600);

		return prices;
	}
	@RequestMapping("/showBookForm.htm")
	public ModelAndView showBookForm(ModelMap map) throws Exception {

		Book book=new Book();
		map.addAttribute(book);
		return new ModelAndView("bookForm");
	}
	
	@RequestMapping("/addBook.htm")
	public ModelAndView addBook(@Valid @ModelAttribute("book") Book book,BindingResult bindingResult)
			throws Exception {

//		validator.validate(book, bindingResult);
		if(bindingResult.hasErrors())
		{
			return new ModelAndView("bookForm");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		//later on the list will be fetched from the table
		List<Book>books=new ArrayList();
		books.add(book);
		modelAndView.addObject("book_list",books);
		modelAndView.addObject("auth_name",book.getAuthor());
		return modelAndView;
	}



}
