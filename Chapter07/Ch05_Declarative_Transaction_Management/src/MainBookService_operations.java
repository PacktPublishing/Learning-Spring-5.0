import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.ch03.beans.Book;
import com.packt.ch05.service.BookService;

public class MainBookService_operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("connection_new.xml");
		BookService service = (BookService) context.getBean("bookService");
		// add book
		boolean added = service.addBook(new Book("Java EE 7 Developer Handbook", 97815674L, "PacktPub publication", 332,
				"explore the Java EE7 programming", "Peter pilgrim"));
		if (added) {
			System.out.println("book inserted successfully");
		} else
			System.out.println("SORRY!cannot add book");

	    List<Book>books=service.findAllBooks("Peter pilgrim");
	    System.out.println("books returned by :-"+books.size());
	   books= service.findAllBooks();
	   System.out.println("All books returned  :-"+books.size());

		// update the book
		boolean updated = service.updateBook(97815674L, 800);
		if (updated) {
			System.out.println("book updated successfully");
		} else
			System.out.println("SORRY!cannot update book");

		// // delete the book
		boolean deleted = service.deleteBook(97815674L);
		if (deleted) {
			System.out.println("book deleted successfully");
		} else
			System.out.println("SORRY!cannot delete book");

	}

}
