package com.packt.ch11.controllers;

import java.time.Duration;

import java.util.ArrayList;

import java.util.List;

import org.reactivestreams.Subscriber;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@EnableWebMvc
public class MyBookController {


	@PostMapping("/books")
	public ResponseEntity<Flux<Book>> addBook(@RequestBody Mono<Book> book) {
		if (book == null) {
			return new ResponseEntity<Flux<Book>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Flux<Book>>(HttpStatus.NOT_FOUND);
	}

	
	@PutMapping("/books/{ISBN}")
	public ResponseEntity<Flux<Book>> updateBook(@PathVariable long ISBN, @RequestBody Mono<Book> book) {
				return new ResponseEntity(book.flux(), HttpStatus.OK);

	}

	@GetMapping("/books/{ISBN}")
	public Mono<Book> getBook(@PathVariable long ISBN) {
		Book book=new Book();
		book.setISBN(ISBN);
		return Mono.justOrEmpty(book);
		}
	
	@GetMapping("/books")
	public Flux<List<Book>> getAllBooks() {

		ArrayList<Book> books=new ArrayList<Book>();
		books.add(new Book("Spring 5.0",1234l,"Packt Pub Publication",500,"Learn Spring", "T.M.Jog"));
		books.add(new Book("Learn Modular Java",1234l,"Packt Pub Publication",500,"Learn java", "Author1"));
		return Flux.just(books);
	}


	@RequestMapping("/books/book")
	public Flux<Book> findBook() {
		Book book=new Book("bookName",1234l," publication",1000," description"," author");
		return Flux.interval(Duration.ofMillis(100)).map(l ->new Book("bookName",1234l," publication",1000," description"," author"));
	}
	
	
	@DeleteMapping("/books/{ISBN}")
	public ResponseEntity<Book> deleteBook(@PathVariable long ISBN) {
		return new ResponseEntity(new Book(), HttpStatus.OK);
	}

}
