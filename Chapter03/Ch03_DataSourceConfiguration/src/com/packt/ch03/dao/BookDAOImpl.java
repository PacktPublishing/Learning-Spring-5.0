package com.packt.ch03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.packt.ch03.beans.Book;

public class BookDAOImpl implements BookDAO {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

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
