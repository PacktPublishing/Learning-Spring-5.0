

import org.springframework.web.client.RestTemplate;

import com.packt.ch03.beans.Book;

public class Main_Get_Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestTemplate template=new RestTemplate();
		Book book=template.getForObject("http://localhost:8080/Ch09_Spring_Rest_JDBC/books/14",Book.class);
		
		System.out.println(book.getAuthor()+"\t"+book.getISBN());

	}

}
