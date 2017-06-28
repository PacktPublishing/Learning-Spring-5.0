import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.packt.ch03.beans.Book;

public class Main_AddBook {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestTemplate template = new RestTemplate();
		
		Book book=new Book("add book",1234l,"adding book",1000,"description adding","abcd");
		book.setDescription("new description");
		Book book2=template.postForObject("http://localhost:8080/Ch09_Spring_Rest_JDBC/books", book,Book.class);
		
		System.out.println(book2.getAuthor());


	}


}
