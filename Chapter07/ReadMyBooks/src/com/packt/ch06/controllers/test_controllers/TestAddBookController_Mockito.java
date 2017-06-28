package com.packt.ch06.controllers.test_controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BeanPropertyBindingResult;

import com.packt.ch03.beans.Book;
import com.packt.ch06.controllers.AddBookController;

public class TestAddBookController_Mockito {

	MockMvc mockMvc;
	
	@InjectMocks
	AddBookController addController;

	@Mock
	BeanPropertyBindingResult bindingResult;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddBook() {

		Book book=new Book("test_book",12345l,"test publication", 900,"test description","test author");
		try {
//			Mockito.when(addController.addBook(book, bindingResult))
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
