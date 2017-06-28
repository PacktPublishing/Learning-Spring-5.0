package com.packt.ch07.unit_tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO_JdbcTemplate;

import junit.framework.Assert;

public class TestBookDAO_JdbcTemplate {

	BookDAO_JdbcTemplate bookDAO_JdbcTemplate;

	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("connection_new.xml");
		bookDAO_JdbcTemplate = (BookDAO_JdbcTemplate) applicationContext.getBean("bookDAO_jdbcTemplate");
	}

	@After
	public void tearDown() throws Exception {
		bookDAO_JdbcTemplate = null;
	}

	@Test
	public void testAddBook() {
		Book book = new Book("Book_Test", 909090L, "Test Publication", 1000, "Test Book description", "Test author");
		int rows_insert = bookDAO_JdbcTemplate.addBook(book);
		assertEquals(1, rows_insert);

	}

	@Test(expected = DuplicateKeyException.class)
	public void testAddBook_Negative() {
		Book book = new Book("Book_Test", 909090L, "Test Publication", 1000, "Test Book description", "Test author");
		int rows_insert = bookDAO_JdbcTemplate.addBook(book);
		assertEquals(0, rows_insert);

	}

//	@Test
//	public void testSearchBook() {
//		// with ISBN which does not exit in the table Book
//		long ISBN = 909090L;
//		Book book = bookDAO_JdbcTemplate.serachBook(ISBN);
//		assertEquals(ISBN, book.getISBN());
//		assertEquals("Book_Test", book.getBookName());
//		assertEquals("Test Publication", book.getPublication());
//		assertEquals("Book_Test", book.getBookName());
//		assertEquals("Test Book description", book.getDescription());
//		assertEquals("Test author", book.getAuthor());
//	}

	@Test
	public void testUpdateBook() {
		// with ISBN which does exit in the table Book
		long ISBN = 909090L;
		int updated_price = 1000;
		int rows_insert = bookDAO_JdbcTemplate.updateBook(ISBN, updated_price);
		assertEquals(1, rows_insert);
	}

	@Test
	public void testUpdateBook_Negative() {
		// with ISBN which doesnot exit in the table Book
		long ISBN = 9090L;
		int updated_price = 1000;
		int rows_insert = bookDAO_JdbcTemplate.updateBook(ISBN, updated_price);
		// No rows found with ISBN specified which returns 0 to rows_insert
		assertEquals(0, rows_insert);
	}

	@Test
	public void testDeleteBook() {
		// with ISBN which does exit in the table Book
		long ISBN = 909090L;
		boolean deleted = bookDAO_JdbcTemplate.deleteBook(ISBN);
		assertTrue(deleted);
	}

	@Test
	public void testDeleteBook_negative() {
		// with ISBN which does not exit in the table Book
		long ISBN = 90909L;
		boolean deleted = bookDAO_JdbcTemplate.deleteBook(ISBN);
		assertFalse(deleted);
	}
	
	@Test
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
