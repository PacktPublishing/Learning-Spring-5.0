package com.packt.ch06.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.packt.ch06.beans.Book;

public class BookValidator2 implements Validator {

	@Override
	public boolean supports(Class<?> book_class) {
		// TODO Auto-generated method stub
		return book_class.equals(Book.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Book book = (Book) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookName", "bookName.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "authorName.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");

		if (book.getDescription().length() < 10 || book.getDescription().length() < 40) {
			errors.rejectValue("description", "description.length",
					"Please enter description within 40 charaters only");
		}

		if (book.getISBN() <= 150l) {
			errors.rejectValue("ISBN", "ISBN.required", "Please Enter Correct ISBN number");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.incorrect");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publication", "publication.required");

	}

}
