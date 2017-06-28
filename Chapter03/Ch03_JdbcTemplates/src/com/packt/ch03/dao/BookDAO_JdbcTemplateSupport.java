package com.packt.ch03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.packt.ch03.beans.Book;

@Repository(value="daoSupport")
public class BookDAO_JdbcTemplateSupport extends JdbcDaoSupport implements BookDAO {

	@Autowired
	public BookDAO_JdbcTemplateSupport(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		setJdbcTemplate(jdbcTemplate);
	}
	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int rows = 0;
		String INSERT_BOOK = "insert into book values(?,?,?,?,?,?)";

		rows=getJdbcTemplate().update(INSERT_BOOK, book.getBookName(), book.getISBN(), book.getPublication(), book.getPrice(),
				book.getDescription(), book.getAuthor());

		return rows;

	}

	@Override
	public int updateBook(long ISBN, int price) {
		// TODO Auto-generated method stub
		int rows = 0;
		String UPDATE_BOOK = "update book set price=? where ISBN=?";

		rows=getJdbcTemplate().update(UPDATE_BOOK, price,ISBN);
		return rows;

	}

	@Override
	public boolean deleteBook(long ISBN) {
		// TODO Auto-generated method stub
		int rows = 0;
		boolean flag=false;
		String DELETE_BOOK = "delete from book where ISBN=?";

		rows=getJdbcTemplate().update(DELETE_BOOK, ISBN);
		if(rows>0)
		  flag=true;

		return flag;

	}

}
