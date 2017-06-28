package com.packt.ch06.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.packt.ch03.beans.Book;

public class BookValidator implements Validator {

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
			errors.rejectValue("bookName", "bookName.required",
					"Please Enter the book Name");
		}

		if (book.getAuthor().length() <=0) {
			errors.rejectValue("author", "authorName.required",
					"Please Enter Author's Name");
		}

		if (book.getDescription().length() <= 0)
		{
			errors.rejectValue("description", "description.required",
					"Please enter book description");
		}
		else if (book.getDescription().length() < 10 || book.getDescription().length() >  40) {
			errors.rejectValue("description", "description.length",
					"Please enter description within 40 charaters only");
		}
		
		if (book.getISBN()<=150l) {
			errors.rejectValue("ISBN", "ISBN.required",
					"Please Enter Correct ISBN number");
		}
		
		if (book.getPrice()<=0 ) {
			errors.rejectValue("price", "price.incorrect",	"Please enter a Correct correct price");
		}

		if (book.getPublication().length() <=0) {
			errors.rejectValue("publication", "publication.required",
					"Please enter publication ");

		}


	}

}
