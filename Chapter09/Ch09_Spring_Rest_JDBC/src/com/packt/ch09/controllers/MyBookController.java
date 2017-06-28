package com.packt.ch09.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

@RestController
@EnableWebMvc
public class MyBookController {

	@Autowired
	BookDAO bookDAO;

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		System.out.println("book added" + book.getDescription());
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		int data = bookDAO.addBook(book);
		if (data > 0)
			return new ResponseEntity(book, HttpStatus.OK);
		return new ResponseEntity(book, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/books")
	public ResponseEntity getAllBooks() {

		List<Book> books = bookDAO.findAllBooks();
		return new ResponseEntity(books, HttpStatus.OK);
	}

	@PutMapping("/books/{ISBN}")
	public ResponseEntity<Book> updateBook(@PathVariable long ISBN, @RequestBody Book book) {

		// search for the book

		System.out.println("request reached");
		Book book_searched = bookDAO.getBook(ISBN);
		if (book_searched == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		bookDAO.updateBook(ISBN, book.getPrice());
		
		book_searched.setPrice(book.getPrice());
		return new ResponseEntity(book_searched, HttpStatus.OK);

	}

	@GetMapping("/books/{ISBN}")
	public ResponseEntity getBook(@PathVariable long ISBN) {

		Book book = bookDAO.getBook(ISBN);
		if (null == book) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(book, HttpStatus.OK);
	}

	@DeleteMapping("/books/{ISBN}")
	public ResponseEntity<Book> deleteBook(@PathVariable long ISBN) {

		Book book = bookDAO.getBook(ISBN);
		
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		boolean deleted = bookDAO.deleteBook(ISBN);
		return new ResponseEntity(book, HttpStatus.OK);
	}

}
