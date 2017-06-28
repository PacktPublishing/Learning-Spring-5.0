package com.packt.ch07.unit_tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:connection_new.xml")
public class SpringRunner_TestBookDAO_JdbcTemplate {

	@Autowired
	@Qualifier("bookDAO_jdbcTemplate")
	BookDAO bookDAO_JdbcTemplate;
  

	@Test
	public void testAddBook() {
		Book book = new Book("Book_Test", 909090L, "Test Publication", 1000, "Test Book description", "Test author");
		int rows_insert = bookDAO_JdbcTemplate.addBook(book);
		assertEquals(1, rows_insert);
	}

	@Test
	public void testUpdateBook() {
      //with ISBN which does exit in the table Book
		long ISBN = 909090L;
		int updated_price = 1000;
		int rows_insert = bookDAO_JdbcTemplate.updateBook(ISBN, updated_price);
		assertEquals(1, rows_insert);
	}

	
	@Test
	public void testDeleteBook() {
//		with ISBN which does exit in the table Book
		long ISBN = 909090L;
		boolean deleted = bookDAO_JdbcTemplate.deleteBook(ISBN);
		assertTrue(deleted);
	}
	
	public void testFindAllBooks() {
		
		List<Book>books = bookDAO_JdbcTemplate.findAllBooks();
		assertTrue(books.size()>0);
		assertEquals(4, books.size());
		assertEquals("Learning Modular Java Programming",books.get(3).getBookName());
		
	}

	@Test
	public void testFindAllBooks_Author() {
		
		List<Book>books = bookDAO_JdbcTemplate.findAllBooks("T.M.Jog");
		assertEquals("Learning Modular Java Programming",books.get(1).getBookName());
		
	}



}
