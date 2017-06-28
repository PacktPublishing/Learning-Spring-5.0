package com.packt.ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;

	@Override
	@Transactional(readOnly=true)
	public Book searchBook(long ISBN) {
		// TODO Auto-generated method stub
		Book book = bookDAO.serachBook(ISBN);
		return book;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub

		if (searchBook(book.getISBN()).getISBN() == 98564567l) {
			System.out.println("no book");
			int rows = bookDAO.addBook(book);
			
			if (rows > 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub
		if (searchBook(ISBN).getISBN() == ISBN) {
			int rows = bookDAO.updateBook(ISBN, price);
			if (rows > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		if (searchBook(ISBN).getISBN() != 98564567l) {
			boolean deleted = bookDAO.deleteBook(ISBN);

			if (deleted) {
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Book> findAllBooks(String author) {
		
		return bookDAO.findAllBooks(author);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Book> findAllBooks() 
	{
		return bookDAO.findAllBooks();
	}
	
}
