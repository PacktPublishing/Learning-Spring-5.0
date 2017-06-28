package com.packt.ch06.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch03.beans.Book;
import com.packt.ch05.service.BookService;

@Controller
public class DeleteBookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/deleteBook.htm")
	public ModelAndView searchBookByAuthor(@RequestParam("ISBN") int ISBN) {

		if (bookService.deleteBook(ISBN)) {
			List<Book> books = bookService.findAllBooks();
			return new ModelAndView("display", "book_list", books);
		}
		     return new ModelAndView("display", "book_list", new ArrayList<Book>());
	}

}
