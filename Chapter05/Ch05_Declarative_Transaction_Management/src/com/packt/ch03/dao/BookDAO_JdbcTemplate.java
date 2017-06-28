package com.packt.ch03.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

		rows = jdbcTemplate.update(INSERT_BOOK, book.getBookName(), book.getISBN(), book.getPublication(),
				book.getPrice(), book.getDescription(), book.getAuthor());

		System.out.println("inserted");
		return rows;
	}

	@Override
	public int updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub
		int rows = 0;
		String UPDATE_BOOK = "update book set price=? where ISBN=?";

		rows = jdbcTemplate.update(UPDATE_BOOK, price, ISBN);
		return rows;

	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		int rows = 0;
		boolean flag = false;
		String DELETE_BOOK = "delete from book where ISBN=?";

		rows = jdbcTemplate.update(DELETE_BOOK, ISBN);
		if (rows > 0)
			flag = true;

		return flag;
	}

	@Override
	public Book serachBook(long ISBN) {
		// TODO Auto-generated method stub
		String SEARCH_BOOK = "select * from book where ISBN=?";
		Book book_serached = null;
		try {
			book_serached = jdbcTemplate.queryForObject(SEARCH_BOOK, new Object[] { ISBN }, new RowMapper<Book>() {

				@Override
				public Book mapRow(ResultSet set, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
				
					Book book = new Book();
					book.setBookName(set.getString("bookName"));
					book.setAuthor(set.getString("author"));
					book.setDescription(set.getString("description"));
					book.setISBN(set.getLong("ISBN"));
					book.setPrice(set.getInt("price"));
					book.setPublication(set.getString("publication"));
					return book;
				}
			});
			return book_serached;
		} catch (EmptyResultDataAccessException ex) {
//			ex.printStackTrace();
			return new Book();
		}
	}

}
