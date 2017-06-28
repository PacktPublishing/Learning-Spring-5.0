import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;

import com.packt.ch03.beans.Book;

import reactor.core.publisher.Mono;

public class Test_WebClient {
	public static void main(String[] args) {
		WebClient webClient = WebClient.create("http://localhost:8080");

		 Book book_mono=webClient.get()
		        .uri("/Ch11_Spring_Reactive_Web/books/{ISNBN}",14)
		        .accept(MediaType.APPLICATION_JSON)
		        .exchange()
		        .then(response -> response.bodyToMono(Book.class)).block();		
		System.out.println(book_mono);
		
	}
	

}
