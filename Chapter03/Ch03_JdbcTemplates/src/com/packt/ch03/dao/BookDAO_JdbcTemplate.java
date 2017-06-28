package com.packt.ch03.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.packt.ch03.beans.Book;
@Repository(value = "bookDAO_jdbcTemplate")
public class BookDAO_JdbcTemplate implements BookDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int rows = 0;
		String INSERT_BOOK = "insert into book values(?,?,?,?,?,?)";

		rows=jdbcTemplate.update(INSERT_BOOK, book.getBookName(), book.getISBN(), book.getPublication(), book.getPrice(),
				book.getDescription(), book.getAuthor());

		return rows;
	}

	@Override
	public int updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub
		int rows = 0;
		String UPDATE_BOOK = "update book set price=? where ISBN=?";

		rows=jdbcTemplate.update(UPDATE_BOOK, price,ISBN);
		return rows;

	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		int rows = 0;
		boolean flag=false;
		String DELETE_BOOK = "delete from book where ISBN=?";

		rows=jdbcTemplate.update(DELETE_BOOK, ISBN);
		if(rows>0)
		  flag=true;

		return flag;
	}

}
