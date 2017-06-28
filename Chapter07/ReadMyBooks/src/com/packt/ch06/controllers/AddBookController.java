package com.packt.ch06.controllers;

//hibernate -api
//jboss
//classmate

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch03.beans.Book;
import com.packt.ch05.service.BookService;

@Controller
public class AddBookController {

	@Autowired
	BookService bookService;

	@Autowired
	Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setValidator(validator);
	}

	@ModelAttribute("priceList")
	public List<Integer> addPrices() {

		List<Integer> prices = new ArrayList<Integer>();
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

		Book book = new Book();
		map.addAttribute(book);
		return new ModelAndView("bookForm");
	}

	@RequestMapping("/addBook.htm")
	public ModelAndView addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult)
			throws Exception {

		// validator.validate(book, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getAllErrors());
			return new ModelAndView("bookForm");
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		// later on the list will be fetched from the table
		List<Book> books = new ArrayList();

		if (bookService.addBook(book)) {
			System.out.println("book added");
			books.add(book);
		}		
		modelAndView.addObject("book_list", books);
		modelAndView.addObject("auth_name", book.getAuthor());
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateBook.htm")
	public ModelAndView updateBook(@RequestParam("ISBN")long ISBN,@RequestParam("price")int price) {
	 bookService.updateBook(ISBN, price);
	 List<Book> books=bookService.findAllBooks();
	return new ModelAndView("display", "book_list", books);
	}
}
