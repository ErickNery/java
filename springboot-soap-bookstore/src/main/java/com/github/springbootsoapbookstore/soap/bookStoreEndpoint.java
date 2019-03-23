package com.github.springbootsoapbookstore.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.github.springbootsoapbookstore.generated.Book;
import com.github.springbootsoapbookstore.generated.GetBookRequest;
import com.github.springbootsoapbookstore.generated.GetBookResponse;

@Endpoint
public class bookStoreEndpoint {

	@PayloadRoot(namespace = "https://github.com/ErickNery/java", localPart = "getBookRequest")
	@ResponsePayload
	public GetBookResponse processBookStoreRequest(@RequestPayload GetBookRequest request) {

		GetBookResponse response = new GetBookResponse();
		Book book = new Book();
		book.setISBN(9780300185430L);
		book.setAuthor("Marcel Proust");
		book.setTitle("Swann's Way: In Search of Lost Time, Volume 1");
		book.setDescription(
				"Swann's Way, the first part of A la recherche de temps perdu, Marcel Proust's seven-part cycle, was published in 1913. In it, Proust introduces the themes that run through the entire work.");
		response.setBook(book);
		return response;
	}

}