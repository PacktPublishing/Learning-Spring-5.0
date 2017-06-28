package com.packt.ch06.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch06.beans.Book;

@Controller
public class SearchBookController {
	@RequestMapping(value = "searchBooks.htm")
	public ModelAndView searchBookByAuthor(@RequestParam("author") String author_name) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", author_name));
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", author_name));
		return new ModelAndView("display", "book_list", books);
	}
	
/* without @RequestParam */
	/*
	@RequestMapping(value = "searchBooks.htm")
	public ModelAndView searchBookByAuthor( String author) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", author));
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", author));
		ModelAndView mv=new ModelAndView("display", "book_list", books);
		mv.addObject("auth_name",author);
		return mv;
	}
	*/
}
