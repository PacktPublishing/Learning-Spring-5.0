import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

public class MainBookDAO_Cache {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("connection_new.xml");
		BookDAO bookDAO=(BookDAO) context.getBean("bookDAO_sessionFactory");
	
	    Book book=bookDAO.getBook(97815674L);
	    System.out.println("book:-"+book.getBookName()+"\t"+book.getAuthor());
	    
	   Book book1=bookDAO.getBook(97815674L);
	    System.out.println("book1:-"+book1.getBookName()+"\t"+book1.getAuthor());
	}


}
