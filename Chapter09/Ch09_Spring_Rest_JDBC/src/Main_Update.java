import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.packt.ch03.beans.Book;

public class Main_Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestTemplate template = new RestTemplate();
		
		Map<String,Long> request_parms=new HashMap<>();
		request_parms.put("ISBN",13l);
		
		Book book=new Book();
		book.setPrice(200);
		template.put("http://localhost:8081/Ch09_Spring_Rest_JDBC/books/13",book,request_parms);


	}

}
