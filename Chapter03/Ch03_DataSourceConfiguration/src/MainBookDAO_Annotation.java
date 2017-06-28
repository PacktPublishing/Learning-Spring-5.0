import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.ch03.beans.Book;
import com.packt.ch03.dao.BookDAO;

public class MainBookDAO_Annotation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("connection_new.xml");
		BookDAO bookDAO=(BookDAO) context.getBean("bookDAO_new");
		int rows=bookDAO.addBook(new Book("Learning Modular Java Programming", 9781236L,"PacktPub publication",800,"explore the power of Modular programming","T.M.Jog"));
	    if(rows>0)
	    {
	    	System.out.println("book inserted successfully");
	    }
	    else
	    	System.out.println("SORRY!cannot add book");

	}


}
