package com.packt.ch06.beans;


public class Book {
	private String bookName;

	private long ISBN;

	private String publication;


	private int price;

	private String description;

	private String author;

	public Book() {
		// TODO Auto-generated constructor stub
		// this.bookName="Book Name";
		// this.ISBN =98564567l;
		// this.publication="Packt Publication";
		// this.price=200;
		// this.description="this is book in general";
		// this.author="ABCD";
	}

	public Book(String bookName, long ISBN, String publication, int price, String description, String author) {
		// TODO Auto-generated constructor stub
		this.bookName = bookName;
		this.ISBN = ISBN;
		this.publication = publication;
		this.price = price;
		this.description = description;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bookName + "\t" + description + "\t" + price;
	}

}
