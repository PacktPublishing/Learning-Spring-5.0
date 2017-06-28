package com.packt.ch06.controllers.test_controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.packt.ch03.beans.Book;
import com.packt.ch06.controllers.AddBookController;

@WebAppConfiguration
@ContextConfiguration({ "file:WebContent/WEB-INF/books-servlet.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestAddBookController {
	MockMvc mockMVC;
	
	@Autowired
	AddBookController addBookController;
	
	@Before
	public void setUp() throws Exception {
		mockMVC=MockMvcBuilders.standaloneSetup(addBookController).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMVC=null;
	}

	@Test
	public void testAddBook() {
		try {
			mockMVC.perform(MockMvcRequestBuilders.post("/addBook.htm")
					
							.contentType(MediaType.APPLICATION_FORM_URLENCODED)
							.param("bookName", "Book_test")
							.param("author", "author_test")
							.param("description", "adding book for test")
							.param("ISBN", "1234")
							.param("price", "9191")
							.param("publication", "This is the test publication")
							.requestAttr("book", new Book()))
					.andExpect(MockMvcResultMatchers.view().name("display"))
					.andExpect(MockMvcResultMatchers.model().attribute("auth_name","author_test"))
					.andDo(MockMvcResultHandlers.print());
			;
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());

		}

	}
	
	
	@Test
	public void testAddBook_Form_validation() {
		try {

			mockMVC.perform(MockMvcRequestBuilders.post("/addBook.htm")
					
					.contentType(MediaType.APPLICATION_FORM_URLENCODED)
					.param("bookName", "Book_test")
					.param("author", "author_test")
					.param("description", "adding book for test")
					.param("ISBN", "1234")
					.param("price", "9191")
					.param("publication", "This is the test publication")
					.requestAttr("book", new Book()))
					.andExpect(MockMvcResultMatchers.view().name("bookForm"))
					.andExpect(
							MockMvcResultMatchers
									.model()
									.attributeHasErrors("book"))
					
					.andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	@Test
	public void testAddBook_Form_Field_Validation()
	{
		try {
			mockMVC.perform(MockMvcRequestBuilders.post("/addBook.htm")
					.param("bookName", "")
					.param("author", "author_test")
					.param("description"," no desc")
					.param("ISBN", "123")
					.param("price", "9191")
				.param("publication", " ")
				.requestAttr("book", new Book()))
				.andExpect(MockMvcResultMatchers.view().name("bookForm"))	
            	.andExpect(
			         MockMvcResultMatchers.model()
					.attributeHasFieldErrors("book", "description")).
            	andExpect(
   			         MockMvcResultMatchers.model()
   					.attributeHasFieldErrors("book", "ISBN"))
   	                .andExpect(
   				         MockMvcResultMatchers.model()
   						.attributeHasFieldErrors("book", "bookName")).
	                andDo(MockMvcResultHandlers.print());
	}catch(Exception ex)
	{
		fail(ex.getMessage());
	}
}


}
