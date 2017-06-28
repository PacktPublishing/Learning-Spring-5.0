package com.packt.ch03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.packt.ch03.beans.Book;
@Repository(value="bookDAO_new")
public class BookDAO_Annotation implements BookDAO {
    @Autowired
	private DataSource dataSource;
	
	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int rows=0;
		String INSERT_BOOK="insert into book values(?,?,?,?,?,?)";
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement ps= connection.prepareStatement(INSERT_BOOK);
			ps.setString(1,book.getBookName());
			ps.setLong(2,book.getISBN());
			ps.setString(3,book.getPublication());
			ps.setInt(4,book.getPrice());
			ps.setString(5,book.getDescription());
			ps.setString(6,book.getAuthor());
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

}
