package com.packt.ch05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	BookDAO bookDAO;

	@Override
	public Book searchBook(long ISBN) {
		// TODO Auto-generated method stub
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
		((DefaultTransactionDefinition) definition).setReadOnly(true);
		Book book = bookDAO.serachBook(ISBN);
		return book;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

		if (searchBook(book.getISBN()).getISBN() == 98564567l) {
			System.out.println("no book");
			int rows = bookDAO.addBook(book);
			
			if (rows > 0) {
				transactionManager.commit(transactionStatus);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

		if (searchBook(ISBN).getISBN() == ISBN) {
			int rows = bookDAO.updateBook(ISBN, price);
			if (rows > 0) {
				transactionManager.commit(transactionStatus);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		TransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transactionStatus = transactionManager.getTransaction(definition);

		if (searchBook(ISBN).getISBN() != 98564567l) {
			boolean deleted = bookDAO.deleteBook(ISBN);

			if (deleted) {
				transactionManager.commit(transactionStatus);
				return true;
			}
		}
		return false;
	}

}
