import org.springframework.web.client.RestTemplate;

import com.packt.ch03.beans.Book;

public class Main_Delete {
	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		template.delete("http://localhost:8081/Ch09_Spring_Rest_JDBC/books/1234");


	}

}
