package com.packt.ch03.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.packt.ch03.beans.Book;

@Repository(value = "bookDAO_sessionFactory")
public class BookDAO_SessionFactory_Cache implements BookDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(book);
			transaction.commit();
			session.close();
			return 1;
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return 0;

	}

	@Override
	public int updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Book book = session.get(Book.class, ISBN);
			book.setPrice(price);

			session.saveOrUpdate(book);
			transaction.commit();
			session.close();
			return 1;
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return 0;

	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Book book = session.get(Book.class, ISBN);
			session.delete(book);
			transaction.commit();
			session.close();
			return true;
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return false;

	}

	@Override
	@Cacheable("repo")
	public Book getBook(long ISBN) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Book book = null;
		try {
			book = session.get(Book.class, ISBN);
			transaction.commit();
			session.close();
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}
		return book;
	}

}
