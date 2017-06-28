package com.packt.ch03.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="book")
public class Book implements Serializable{
	private String bookName;
	private long ISBN;
	private String publication;
	private int price;
	private String description;
	private String author;
	
	public Book() {
		// TODO Auto-generated constructor stub
		this.bookName="Book Name";
		this.ISBN =98564567l;
		this.publication="Packt Publication";
		this.price=200;
		this.description="this is book in general";
		this.author="ABCD";
	}
	
	public Book(String bookName, long ISBN, String publication,int price,String description, String author) {
		// TODO Auto-generated constructor stub
		this.bookName=bookName;
		this.ISBN =ISBN;
		this.publication=publication;
		this.price=price;
		this.description=description;
		this.author=author;
	}

	public String getBookName() {
		return bookName;
	}

	@XmlElement
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getISBN() {
		return ISBN;
	}

	@XmlElement
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getPublication() {
		return publication;
	}

	@XmlElement
	public void setPublication(String publication) {
		this.publication = publication;
	}

	public int getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bookName+"\t"+description+"\t"+price;
	}

}
