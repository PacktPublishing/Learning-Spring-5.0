package com.packt.ch03.dao;

import com.packt.ch03.beans.Book;

public interface BookDAO {
	public int addBook(Book book);
	public int updateBook(long ISBN,int price);
	public boolean deleteBook(long ISBN);
	public Book serachBook(long ISBN);
}
