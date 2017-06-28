package com.packt.ch03.dao;

import java.util.List;

import com.packt.ch03.beans.Book;

public interface BookDAO {
	public int addBook(Book book);
	public int updateBook(long ISBN,int price);
	public boolean deleteBook(long ISBN);
	public List<Book> findAllBooks();
	public List<Book> findAllBooks(String author);
}
