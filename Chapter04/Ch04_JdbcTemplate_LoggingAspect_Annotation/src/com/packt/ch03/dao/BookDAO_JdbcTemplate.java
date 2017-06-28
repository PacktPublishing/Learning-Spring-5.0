package com.packt.ch03.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	
	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		
		List<Book> books=new ArrayList<>();
		String FIND_ALL="select * from book";
		List<Map<String,Object>>entries=		 jdbcTemplate.queryForList(FIND_ALL);	
      for(Map<String,Object> m:entries)
		{
			Book book=new Book();
		
			book.setAuthor((String)m.get("author"));
			book.setBookName((String)m.get("bookName"));
			book.setISBN((Long)m.get("ISBN"));
			book.setPublication((String)m.get("publication"));
			book.setDescription((String)m.get("description"));
			book.setPrice((Integer)m.get("price"));
             books.add(book);
		}
      return books;
		}

	@Override
	public List<Book> findAllBooks(String author) {
		// TODO Auto-generated method stub
		System.out.println(author);
		String FIND_ALL_Author="select * from book where author=?";
		return jdbcTemplate.query(FIND_ALL_Author,new String[]{author}, new ResultSetExtractor<List<Book>>() {

			List<Book>books=new ArrayList();
			@Override
			public List<Book> extractData(ResultSet set) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(set.next())
				{
					Book book=new Book();
					book.setAuthor(set.getString("author"));
					book.setBookName(set.getString("bookName"));
					book.setISBN(set.getLong("ISBN"));
					book.setPublication(set.getString("publication"));
					book.setDescription(set.getString("description"));
					books.add(book);
				}
				return books;
			}
		});
	}


}
