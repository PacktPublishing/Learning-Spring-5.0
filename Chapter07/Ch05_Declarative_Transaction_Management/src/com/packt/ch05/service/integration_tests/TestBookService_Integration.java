package com.packt.ch05.service.integration_tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.packt.ch03.beans.Book;
import com.packt.ch05.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:connection_new.xml")
public class TestBookService_Integration {

	@Autowired
	BookService bookService;
	
	
	@Test
	public void testAddBook() {
		// Choose ISBN which is not there in book table
		Book book = new Book("Book_Test", 909098L, "Test Publication", 1000, "Test Book description", "Test author");
		boolean flag=bookService.addBook(book);
		assertEquals(true, flag);
	}
	
	@Test
	public void testSearchBook() {
		// Choose ISBN which is present there in book table
		long ISBN=909098L;
		Book book=bookService.searchBook(ISBN);
		assertEquals(ISBN, book.getISBN());
		assertEquals("Book_Test",book.getBookName());
		assertEquals("Test Publication",book.getPublication());
		assertEquals("Book_Test",book.getBookName());
		assertEquals("Test Book description",book.getDescription());
		assertEquals("Test author",book.getAuthor());
	}


	@Test
	public void testUpdateBook() {
		long ISBN=909098L;
		int price=9090;
		boolean inserted=bookService.updateBook(ISBN, price);
		assertEquals(true, inserted);

	}
	
	@Test
	public void testUpdateBook_negative() {
		long ISBN=90L;
		int price=9090;
		boolean inserted=bookService.updateBook(ISBN, price);
		assertEquals(false, inserted);

	}

	@Test
	public void testDeleteBook() {
		long ISBN=909098L;
		boolean deleted=bookService.deleteBook(ISBN);
		assertEquals(true, deleted);
	}

	@Test
	public void testDeleteBook_negative() {
		long ISBN=90L;
		boolean deleted=bookService.deleteBook(ISBN);
		assertEquals(false, deleted);
	}

	@Test
	public void testFindAllBooks() {
		// with ISBN which does exit in the table Book
		
		List<Book>books = bookService.findAllBooks();
		assertTrue(books.size()>0);
		assertEquals(4, books.size());
		assertEquals("Learning Modular Java Programming",books.get(3).getBookName());
		
	}

	@Test
	public void testFindAllBooks_Author() {
		// with ISBN which does exit in the table Book
		
		List<Book>books = bookService.findAllBooks("T.M.Jog");
		assertEquals("Learning Modular Java Programming",books.get(1).getBookName());
		
	}

	
}
