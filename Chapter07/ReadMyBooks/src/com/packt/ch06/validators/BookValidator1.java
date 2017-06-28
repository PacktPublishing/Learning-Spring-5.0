package com.packt.ch06.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.ch03.beans.Book;

public class BookValidator1 implements Validator {

	@Override
	public boolean supports(Class<?> book_class) {
		// TODO Auto-generated method stub
		return book_class.equals(Book.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Book book=(Book) obj;
		if (book.getBookName().length() < 5) {
			errors.rejectValue("bookName", "bookName.required");
		}

		if (book.getAuthor().length() <=0) {
			errors.rejectValue("author", "authorName.required");
					
		}

		if (book.getDescription().length() <= 0)
		{
			errors.rejectValue("description", "description.required");
					
		}
		else if (book.getDescription().length() < 10 || book.getDescription().length() <  40) {
			errors.rejectValue("description", "description.length");
					
		}
		
		if (book.getISBN()<=150l) {
			errors.rejectValue("ISBN", "ISBN.required");
					
		}
		
		if (book.getPrice()<=0 ) {
			errors.rejectValue("price", "price.incorrect");
		}

		if (book.getPublication().length() <=0) {
			errors.rejectValue("publication", "publication.required");
			
		}
	}

}
