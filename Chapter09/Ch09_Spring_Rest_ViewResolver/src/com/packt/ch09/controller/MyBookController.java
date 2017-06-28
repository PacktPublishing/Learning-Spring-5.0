package com.packt.ch09.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.packt.ch03.beans.Book;

@RestController
public class MyBookController {


	@RequestMapping(value="/books/{author}", method = RequestMethod.GET)
	public String getBook(@PathVariable String author, ModelMap model) {
 
		List<Book> books=new ArrayList<>();
		books.add(new Book("Book1",10l,"publication1",100,"description","auuthor1"));
		books.add(new Book("Book2",11l,"publication1",200,"description","auuthor1"));
		books.add(new Book("Book3",12l,"publication1",500,"description","auuthor1"));
		
		model.addAttribute("book", books);
 
		return "book";
 
	}
	
}
