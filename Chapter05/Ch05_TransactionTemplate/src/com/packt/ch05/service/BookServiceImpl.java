package com.packt.ch05.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	TransactionTemplate transactionTemplate;

	@Autowired
	BookDAO bookDAO;

	@Override
	public Book searchBook(long ISBN) {
		// TODO Auto-generated method stub
		 transactionTemplate.setReadOnly(true);
		return transactionTemplate.execute(new TransactionCallback<Book>() {

			@Override
			public Book doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
//				Book book = bookDAO.serachBook(ISBN);
				Book book=new Book();
				book.setISBN(ISBN);
				bookDAO.addBook(book);
				return book;
			}

		});

	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub

		if (searchBook(book.getISBN()).getISBN() == 98564567l) {
			transactionTemplate.setReadOnly(false);
			return transactionTemplate.execute(new TransactionCallback<Boolean>() {

				@Override
				public Boolean doInTransaction(TransactionStatus status) {
					// TODO Auto-generated method stub
					try {

						int rows = bookDAO.addBook(book);
						if (rows > 0)
							return true;

					} catch (Exception exception) {
						status.setRollbackOnly();
					}
					return false;

				}
			});
		}
		return false;
	}

	@Override
	public boolean updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub
		if (searchBook(ISBN).getISBN() == ISBN) {
			transactionTemplate.setReadOnly(false);
		return transactionTemplate.execute(new TransactionCallback<Boolean>() {

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				try {
			
						int rows = bookDAO.updateBook(ISBN, price);
						if (rows > 0)
							return true;

				} catch (Exception exception) {
					status.setRollbackOnly();
				}
				return false;

			}
		});
		}
		return false;
	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		if (searchBook(ISBN).getISBN() == ISBN) {
		transactionTemplate.setReadOnly(false);	
				return transactionTemplate.execute(new TransactionCallback<Boolean>() {

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				try {
						boolean result = bookDAO.deleteBook(ISBN);
						return result;

				} catch (Exception exception) {
					status.setRollbackOnly();
				}
				return false;

			}
		});
		}
		return false;
	}

}
