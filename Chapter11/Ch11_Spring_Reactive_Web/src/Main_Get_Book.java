
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import com.packt.ch03.beans.Book;
import reactor.core.publisher.Mono;

public class Main_Get_Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestTemplate template = new RestTemplate();
		Book book = template.getForObject("http://localhost:8080/Ch11_Spring_Reactive_Web/books/14", Book.class);
		System.out.println(book.getAuthor() + "\t" + book.getISBN());

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<List> responseEntity = template
				.getForEntity("http://localhost:8080/Ch11_Spring_Reactive_Web/books", List.class);
		List<ArrayList<Book>> books = responseEntity.getBody();
		int i = 0;
		for (ArrayList l : books) {
			for (int j = 0; i < l.size(); j++) {
				LinkedHashMap<String, Book> map = (LinkedHashMap<String, Book>) l.get(i);
				Set<Entry<String, Book>> set = map.entrySet();
				System.out.println("***\tBook:-"+i +"\t****");
				for (Entry<String, Book> entry : set) {
					System.out.print(entry.getValue() + "\t");
				}
				i++;
				System.out.println();
			}
		}
	}
}
