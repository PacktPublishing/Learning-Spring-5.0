package com.packt.ch05.service;

import com.packt.ch03.beans.Book;

public interface BookService {
	public Book searchBook(long ISBN);
	public boolean addBook(Book book);
	public boolean updateBook(long ISBN, int price);
	public boolean deleteBook(long ISBN);
}
