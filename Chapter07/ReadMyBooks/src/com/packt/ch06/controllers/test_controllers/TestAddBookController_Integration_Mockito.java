package com.packt.ch06.controllers.test_controllers;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.packt.ch03.beans.Book;
import com.packt.ch05.service.BookService;
import com.packt.ch06.controllers.AddBookController;

public class TestAddBookController_Integration_Mockito {

	MockMvc mockMvc;

	
	@InjectMocks
	AddBookController addController;

	@Mock
	BeanPropertyBindingResult bindingResult;
	@Mock
	BookService bussinessImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testAddBook() {

		Book book = new Book("Book_Test", 909098L, "Test Publication", 1000, "Test Book description", "Test author");
		Mockito.when(bussinessImpl.addBook(book)).thenReturn(true);

		try {
			ModelAndView modelAndView=addController.addBook(book, bindingResult);
			Set<Map.Entry<String,Object>> entries=modelAndView.getModel().entrySet();
			Iterator iterator=entries.iterator();
		    List<Book> val=null;
			while (iterator.hasNext()) {
				Map.Entry entry=(Map.Entry)iterator.next();
				val=(List)entry.getValue();
				break;
			}
			assertEquals(2,entries.size());
			assertEquals("Book_Test",val.get(0).getBookName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}

		
	}

}
