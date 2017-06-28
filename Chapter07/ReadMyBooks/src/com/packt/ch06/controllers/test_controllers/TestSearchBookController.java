package com.packt.ch06.controllers.test_controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch03.beans.Book;
import com.packt.ch06.controllers.SearchBookController;

@WebAppConfiguration
@ContextConfiguration({ "file:WebContent/WEB-INF/books-servlet.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestSearchBookController {

	
	@Autowired
	SearchBookController searchBookController;
	
	
	@Test
	public void testSearchBookByAuthor() {
		
		String author_name="T.M.Jog";
		ModelAndView modelAndView=searchBookController.searchBookByAuthor(author_name);
		assertEquals("display",modelAndView.getViewName());
	}
	
	@Test
	public void testSerachBookByAuthor_New()
	{
		String author_name="T.M.Jog";
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", author_name));
		books.add(new Book("Learning Modular Java Programming", 9781235, "packt pub publication", 800,
				"explore the power of modular Programming ", author_name));
		ModelAndView modelAndView=searchBookController.searchBookByAuthor(author_name);
		ModelAndViewAssert.assertModelAttributeAvailable(modelAndView, "book_list");
	}

}
