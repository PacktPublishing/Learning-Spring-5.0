package com.packt.ch07.unit_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;


public class Spring_Mokito_TestBookDAO_JdbcTemplate {

	@Mock
	BookDAO bookDAO_JdbcTemplate;
	  
	@Before
	public void setUp()throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void testAddBook() {
		Book book = new Book("Book_Test", 909090L, "Test Publication", 1000, "Test Book description", "Test author");
		
		Mockito.when(bookDAO_JdbcTemplate.addBook(book)).thenReturn(1);
		int rows_insert = bookDAO_JdbcTemplate.addBook(book);
		assertEquals(1, rows_insert);
	}

	@Test
	public void testUpdateBook() {
      //with ISBN which does exit in the table Book
		long ISBN = 909090L;
		int updated_price = 1000;
		Mockito.when(bookDAO_JdbcTemplate.updateBook(ISBN, updated_price)).thenReturn(1);
		int rows_insert = bookDAO_JdbcTemplate.updateBook(ISBN, updated_price);
		assertEquals(1, rows_insert);
	}

	
	@Test
	public void testDeleteBook() {
//		with ISBN which does exit in the table Book
		long ISBN = 909090L;
		Mockito.when(bookDAO_JdbcTemplate.deleteBook(ISBN)).thenReturn(true);
		
		boolean deleted = bookDAO_JdbcTemplate.deleteBook(ISBN);
		assertTrue(deleted);
	}

	public void testFindAllBooks() {
		List<Book> books=new ArrayList();
		books.add(new Book("Book_Test", 909090L, "Test Publication", 1000, "Test Book description", "Test author") );
		Mockito.when(bookDAO_JdbcTemplate.findAllBooks()).thenReturn(books);
		assertTrue(books.size()>0);
		assertEquals(1, books.size());
		assertEquals("Book_Test",books.get(0).getBookName());
		
	}

	@Test
	public void testFindAllBooks_Author() {
		List<Book> books=new ArrayList();
		books.add(new Book("Book_Test", 909090L, "Test Publication", 1000, "Test Book description", "Test author") );
		Mockito.when(bookDAO_JdbcTemplate.findAllBooks("Test author")).thenReturn(books);
		assertTrue(books.size()>0);
		assertEquals(1, books.size());
		assertEquals("Book_Test",books.get(0).getBookName());
		
	}
	
	
	
}


//
