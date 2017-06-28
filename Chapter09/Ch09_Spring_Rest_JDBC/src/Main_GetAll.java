import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packt.ch03.beans.Book;

public class Main_GetAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestTemplate template = new RestTemplate();

		ResponseEntity<Book[]> responseEntity=template.getForEntity("http://localhost:8081/Ch09_Spring_Rest_JDBC/books", Book[].class);
		Book[] books=responseEntity.getBody();
		for(Book book:books)
		System.out.println(book.getAuthor()+"\t"+book.getISBN());
		
	}
}